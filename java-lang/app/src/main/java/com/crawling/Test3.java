package com.crawling;

import java.io.IOException;
import java.text.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test3 {
  public static void main(String[] args) throws ParseException {

    String URL = "https://search.naver.com/search.naver?where=news&ie=utf8&sm=nws_hty&query=%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90";
    String URL1 = "https://map.naver.com/v5/api/bookmark/sync";
    Document doc;

    try {
      doc = Jsoup.connect(URL1).get();


      Elements todaylist =doc.select("bookmarkId" );

      System.out.println(todaylist.size());

      System.out.println(todaylist);


      //      String[] str = new String[20];
      //      for(int i = 0 ; i < todaylist.size() ; i++) {
      //        str[i]  = todaylist.get(i).attr("href");
      //        System.out.println(str[i]);
      //        System.out.println(todaylist.get(i).text());
      //
      //      }





    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}