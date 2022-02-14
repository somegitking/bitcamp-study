package com.eomcs.oop.ex11.h.test;
//컬랙션의 값을 조회하는 일을 한다.
public class ListIterator implements java.util.Iterator{

  LinkedList list;
  int cursor;


  public ListIterator(LinkedList list) {
    this.list = list;
    // TODO Auto-generated constructor stub
  }

  @Override
  public boolean hasNext() {
    return cursor < list.size();

  }

  @Override
  public Object next() {
    return list.get(cursor++);
  }
}
