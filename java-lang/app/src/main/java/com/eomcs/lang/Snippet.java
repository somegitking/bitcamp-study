package com.eomcs.lang;

public class Snippet {
  byte b = Byte.valueOf("100");
  short s = Short.valueOf("32767");
  int i1 = Integer.valueOf("2122223333"); // 문자열 ==> int
  int i2 = Integer.parseInt("2122223333"); // 문자열 ==> int
  long l = Long.valueOf("9221111222233334444"); 
  float f1 = Float.valueOf("3.14f");
  float f2 = Float.parseFloat("3.14f");
  double d = Double.valueOf("9876.54321");
  boolean bool1 = Boolean.valueOf("TRUE");   // 문자열 ==> boolean
  boolean bool2 = Boolean.parseBoolean("TRUE");   // 문자열 ==> boolean
  char c = "가".charAt(0);
}

