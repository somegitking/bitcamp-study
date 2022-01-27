package com.eomcs.util;

public class ArrayList {

  Object[] list = new Object[5];
  int size = 0;

  public void add(Object obj) {
    if(this.size == this.list.length) {
      this.list = this.grow();
    }
    this.list[this.size++] = obj;

  }

  public void addAll(Object[] arr) {
    for(Object obj : arr) {
      this.add(obj);
    }
  }

  Object[] grow() {
    Object[] arr = new Object[this.newLength()];
    this.copy(arr);
    return arr;
  }

  int newLength() {
    return this.list.length + (this.list.length >> 1);
  }

  void copy(Object[] target) {
    int length = this.list.length;
    if (target.length < this.list.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = this.list[i];
    }
  }

  public Object[] toArray() {
    Object[] arr= new Object[this.size];
    for(int i = 0; i< this.size ; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  public Object remove(int index) {
    if (index < 0 || index >= this.size) { // 값이 저장된 위치가 무효한 인덱스라면 
      return null;
    }
    Object old = this.list[index];
    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.size--;
    return old;
  }

  public Object set(int index, Object obj) {
    if(index < 0 || index >= this.size) {
      return null;
    }
    Object old = this.list[index];
    this.list[index] = obj;
    return old;

  }

  public int size() {
    return this.size;
  }

  public Object get(int index) {
    return this.list[index];
  }




}
