package com.eomcs.app1;

public class App {

  public static void main(String[] args) {

    Console console = new Console();
    CommandHandler commandHandler = new CommandHandler();

    while (true) {
      Command command = console.prompt();

      try {
        if (command.getName().equals("quit") || command.getName().equals("exit")) {
          break;

        } else if (command.getName().equals("")) {
          continue;

        } else if (command.getName().equals("help")) {
          commandHandler.doHelp();

        } else if (command.getName().equals("add")) {
          commandHandler.doAdd(command);

        } else if (command.getName().equals("minus")) {
          commandHandler.doMinus(command);

        } else if (command.getName().equals("divide")) {
          commandHandler.doDivide(command);


        } else {
          System.out.println("지원하지 않는 연산자입니다.");
        }

      }catch(Exception e) {
        System.out.println("명령어 처리 중 오류 발생");

      }
    }

    console.close();
  }

}







