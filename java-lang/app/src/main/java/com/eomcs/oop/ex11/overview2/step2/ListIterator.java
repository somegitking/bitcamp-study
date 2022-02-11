package com.eomcs.oop.ex11.overview2.step2;

public class ListIterator implements Iterator{
  MyList list;
  int cursor;

  public ListIterator(MyList list) {
    this.list = list;
  }

  public boolean hasNext() {
    return cursor < list.size();
  }

  public Object next() {
    return list.get(cursor++);
  }
}