package com.eomcs.algorithm.data_structure.linkedlist2.step1;

public class LinkedList {
  Node head;
  Node tail;
  int size;

  public void add(Object value) { //앞에서 부터 순서대로 노드 추가
    Node node = new Node(value); //노드 객체 생성

    if (head == null) {//head가 null = 첫 node
      tail = head = node;
    } else { //null 아니면 1개 이상 이미 존재함으로
      //그 다음에 추가
      node.prev = tail;//새로 추가한 node에 
      tail.next = node; //새로 추가한 node를 현재 마지막 다음에 위치
      tail = node;//새로 추가한 node가 마지막이 된다.
    }

    size++;
  }
  //특정 index 다음에 값을 추가
  public void add(int index, Object value) {
    Node node = getNode(index);

    Node newNode = new Node(value);

    if (node.prev != null) {
      node.prev.next = newNode; // 앞 노드 뒤의 노드를 새 노드로 설정
    }
    newNode.prev = node.prev; // 새 노드의 앞 노드 설정

    node.prev = newNode; // 현재 노드의 앞 노드를 새 노드로 설정
    newNode.next = node; // 새 노드의 다음 노드를 현재 노드로 설정. 

    if (node == head) { // 첫 번째 노드라면
      head = newNode; // 새 노드를 첫 번째 노드로 만든다.
    }

    size++;
  }

  public int size() {//노드의 길이/갯수
    return size; 
  }

  public Object get(int index) {//index 번호의 node
    Node node = getNode(index);
    return node.value;
  }

  public Object remove(int index) {//노드를 제거
    Node node = getNode(index);

    if (size == 1) {//노드의 길이/갯수가 1인 경우
      head = tail = null;
    } else if (node == head) { //첫번째 노드인 경우
      head = node.next;
    } else if (node == tail) {//마지막 노드인 경우
      tail = node.prev;
    } else { //중간에 있는 노드인 경우
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    // 삭제된 노드는 다른 노드나 객체를 참조하지 않도록 초기화시킨다.
    // => 삭제된 노드끼리 참조하는 경우 가비지가 되지 않는 문제가 발생한다.
    // => 삭제된 노드가 값 객체의 주소를 갖고 있으면 값 객체가 가비지가 되지 않는 문제가 발생한다.
    // 
    node.prev = null;
    node.next = null;
    Object deleted = node.value;
    node.value = null;
    size--;
    return deleted; // 삭제되기 전의 값 리턴
  }

  public Object set(int index, Object value) {//특정 index의 노드값 변경
    Node node = getNode(index);
    Object old = node.value;
    node.value = value;
    return old; // 변경되기 전의 값 리턴
  }

  private Node getNode(int index) {//특정 index의 노드 값 가져 오기
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    Node node = head;
    int count = 0;
    while (count < index) {
      node = node.next;
      count++;
    }

    return node;
  }
}








