package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0431{

  static void m(int i) throws Exception, RuntimeException, SQLException, IOException{

    if(i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if(i == 2)
      throw new SQLException();
    else
      throw new IOException();

  }

  public static void main(String[] args) throws Exception {


    try {
      m(3);      
    }
    catch(IOException e){
      System.out.println("IOException 발생");

    }
    catch(SQLException e){
      System.out.println("SQLException 발생");

    }
    catch(RuntimeException e){
      System.out.println("RuntimeException 발생");

    }
    catch(Exception e){
      System.out.println("Exception 발생");

    }



  }

}

