package com.json;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Parse {
  public static void main(String[] args) throws IOException, ParseException  {

    Object ob = new JSONParser().parse(new FileReader("data.json"));

    //     typecasting ob to JSONObject
    JSONObject js = (JSONObject) ob;
    //
    //    String firstName = (String) js.get("firstName");
    //    String lastName = (String) js.get("lastName");
    //
    //    System.out.println("First name is: " + firstName);
    //    System.out.println("Last name is: " +lastName);

    //    System.out.println(js);
    //   System.out.println(js.get("my"));
    String str = js.toString();
    System.out.println(str);
    String[] arr = str.split(",\"py\":");

    for(int i = 0 ; i < arr.length ; i++) {
      //      System.out.println(arr[i]);
      String[] arr1 = arr[i].split(",\"memo\"");
      System.out.println(arr1[0]);


    }


    //    for(int i = 0 ; i < arr.length ;i++) {
    //      String[] arr1 = arr[i].split("px");
    //            String[] arr2 = arr1[0].split("\",\"");
    //            String[] arr3 = arr2[1].split("\":\"");
    //      System.out.println(arr1[0]);
    //    }



    //    System.out.println(arr[0]);
    //    String[] arr1 = arr[1].split("\":\"");
    //    System.out.println(arr1[0]);
    //    System.out.println(arr1[1]);

    //    String[] arr2 = arr[2].split("\":\"");
    //    System.out.println(arr2[0]);
    //    System.out.println(arr2[1]);


    //    for(int i = 0 ; i <= arr.length; i++) {
    //      arr[i].split("displayName\":\"",500);
    //      System.out.println(arr[1]);
    //    }


    //    System.out.println(js.get("my"));
    //    (js.get("my")).get("bookmark");


  }

}
