package com.eomcs.app2;

import com.eomcs.app2.handler.ScoreHandler;
import com.eomcs.util.Prompt;

public class App{

  ScoreHandler scoreHandler = new ScoreHandler();

  public static void main(String[] args) {
    new App().service();
  }

  public void service() {
    while (true) {
      printMenu();
      String input = Prompt.promptString("명령> ");

      if (checkQuit(input)) {
        break;
      }

      try {
        switch (input) {
          case "1": scoreHandler.create(); break;
          case "2": scoreHandler.list(); break;
          case "3": scoreHandler.detail(); break;
          case "4": scoreHandler.update(); break;
          case "5": scoreHandler.delete(); break;
          default:
            System.out.println("올바른 메뉴 번호를 입력하세요!");
        }
      } catch (Exception e) {
        System.out.println("실행 중 오류 발생: " + e.getMessage());
      }





    }
  }

  private void printMenu() {
    System.out.println("메뉴:");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 상세");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }

  private boolean checkQuit(String input) {
    return input.equals("quit") || input.equals("exit");
  }




}