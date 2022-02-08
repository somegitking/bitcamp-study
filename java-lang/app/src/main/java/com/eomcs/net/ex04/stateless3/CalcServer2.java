package com.eomcs.net.ex04.stateless3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CalcServer2{

  static Map<Long, Integer> resultMap = new HashMap<>();

  static class RequestHandler extends Thread{

    Socket socket;

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try(Socket socket2 = socket;
          DataInputStream in = new DataInputStream(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());){

        long clientId = in.readLong();

        String op = in.readUTF();
        int value = in.readInt();

        Integer obj = resultMap.get(clientId);
        int result = 0;

        if(obj != null) {
          System.out.printf("%d 기존 고객 요청 처리!\n", clientId);
          result = obj;
        }else {
          clientId = System.currentTimeMillis();
          System.out.printf("%d 신규 고객 요청 처리!\n",clientId);
        }

        switch(op) {
          case "+":
            System.out.println(result);
            result += value;
            System.out.println(result);
            break;

          case "-":
            result -= value;
            break;

          case "*":
            result *= value;
            break;

          case "/":
            Thread.sleep(10000);
            result /= value;
            break;
        }
        out.writeLong(clientId);


        out.writeInt(result);

        out.flush();

        resultMap.put(clientId, result);

      }catch(Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
      }finally {
        System.out.println("클라이언트 연결 종료!");
      }
    }
  }

  public static void main(String[] args)throws Exception{
    System.out.println("서버 실행 중");

    ServerSocket ss = new ServerSocket(8888);

    while(true) {
      System.out.println("클라이언트 연결을 기다림");
      Socket socket = ss.accept();
      InetSocketAddress remoteAddr = (InetSocketAddress)socket.getRemoteSocketAddress();

      System.out.printf("클라이언트(%s:%d)가 연결되었음\n",
          remoteAddr.getAddress(), remoteAddr.getPort());

      RequestHandler requestHandler = new RequestHandler(socket);

      requestHandler.start();
      System.out.printf("%s 클라이언트 요청을 스레드에게 맡겼습니다. \n",
          remoteAddr.getAddress());


    }

  }


}