package com.eomcs.net.ex12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

  int port;

  public ChatServer(int port) {
    this.port = port;
  }

  public void service() {
    //ServerSocket 객체는 Socket 객체와 다르다.
    //ChatServer 인스턴스가 생성되면서 8888 포트 번호가 전달됨.
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");

      while (true) {//클라이언트가 하나 대기열에 걸릴 때 까지 기다린다.
        //start()는 thread의 메소드이다
        new RequestHandler(serverSocket.accept()).start();
      }

    } catch (Exception e) {
      System.out.println("서버 실행 오류 - " + e.getMessage());
    }
  }

  class RequestHandler extends Thread { //Tread를 상속 받는다.
    Socket socket;

    public RequestHandler(Socket socket) {//생성자가 호출되면 
      this.socket = socket; //파라미터로 넘어온 객체를 socket에 저장
    }

    @Override
    public void run() {
      try (Socket socket2 = socket; //소켓을 자동으로 클로즈 하기 위함.
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())) {

        out.writeUTF("환영합니다!"); //서버 접속시 첫 메시지
        out.flush();

        while (true) {
          String message = in.readUTF(); //클라언트가 보낸 문자열을 읽어 들인가
          if (message.equals("\\quit")) {//\\quit를 입력 하면 종료한다
            out.writeUTF("Goodbye!");
            out.flush();
            break;
          }
          out.writeUTF(message);//읽어 들인 문자열을 출력한다.
          out.flush();
        }
      } catch (Exception e) {
        System.out.println("클라이언트와의 통신 오류! - " + e.getMessage());
      }
    }
  }


  public static void main(String[] args) {
    new ChatServer(8888).service();//인스턴스 생성하여 메소드 호출
  }
}
