package com.eomcs.net.ex11.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {

  String logo;

  public CalculatorServer() {
    StringBuilder logoStr = new StringBuilder();
    //로고 이미지 텍스트가 저장된 welcome.txt에 연결하는 객체를 만든다
    try (BufferedReader welcomeIn = new BufferedReader(new FileReader("welcome.txt"));) {
      while (true) {
        String str = welcomeIn.readLine(); //텍스트 파일에서 한 줄씩 읽는다
        if (str == null) { //읽을게 없으면 멈춘다.
          break;
        }
        logoStr.append(str + "\n");//StringBuilder 객체 한줄씩 넣어 
      }
    } catch (Exception e) {
      if (logoStr.length() > 0) {
        logoStr.setLength(0);
      }
      logoStr.append("환영합니다!\n"); //예외가 발생하지 않으면 실행되지 않는다
    }

    logo = logoStr.toString();
  }

  public void launch(int port) {
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("서버 실행 중...");

      while (true) {
        new RequestHandler(serverSocket.accept()).start();
      }//1. 클라이언트 1개가 대기열에 쌓이면 Thread 1개를 만든다 
      //2. RequestHandler는 Thread를 상속 받아서 start() 사용 가능

    } catch (Exception e) {
      System.out.println("서버 소켓 생성 중 오류 발생!");
    }
  }

  public static void main(String[] args) {
    new CalculatorServer().launch(8888); //new CalculatorServer() ->인스턴스 임
  }

  class RequestHandler extends Thread { //Thread를 상속 받음
    Socket socket;

    public RequestHandler(Socket socket) {//RequestHandler 생성자
      this.socket = socket;
    }

    @Override
    public void run() {
      try (
          Socket socket2 = socket; // close() 자동 호출하기 위해
          Scanner in = new Scanner(socket.getInputStream());
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {

        out.print(logo);

        out.println("계산식을 입력하세요!");
        out.println("예) 23 + 7 ");
        out.println();

        while (true) {
          String str = in.nextLine();
          if (str.equals("quit")) {
            out.println("Goodbye!");
            out.flush();
            break;
          }

          try {
            String[] values = str.split(" ");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[2]);
            String op = values[1];

            switch (op) {
              case "+": out.printf("%d %s %d = %d\n", a, op, b, a + b); break;
              case "-": out.printf("%d %s %d = %d\n", a, op, b, a - b); break;
              case "*": out.printf("%d %s %d = %d\n", a, op, b, a * b); break;
              case "/": out.printf("%d %s %d = %d\n", a, op, b, a / b); break;
              case "%": out.printf("%d %s %d = %d\n", a, op, b, a % b); break;
              default:  out.printf("%d %s %d = %s\n", a, op, b, "지원하지 않는 연산입니다");
            }
            out.flush();

          } catch (Exception e) {
            out.println("계산 중 오류 발생 - " + e.getMessage());
            out.flush();
          }
        }

      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
      }
    }
  }

}








