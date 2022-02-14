package com.eomcs.oop.ex11.h.test1;

public class LinkedList {
  Node head;
  Node tail;
  int size;

  public void add(Object value) {
    Node node = new Node(value);

    if (head == null) {
      tail = head = node;
    } else {
      node.prev = tail;
      tail.next = node;
      tail = node;
    }

    size++;
  }

  //노드 추가
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

  //노드의 길이를 반환
  public int size() {
    return size;
  }

  //특정 노드의 값을 반환
  public Object get(int index) {
    Node node = getNode(index);
    return node.value;
  }

  //노드를 삭제
  public Object remove(int index) {
    Node node = getNode(index);

    if (size == 1) { //첫번째 1개 밖에 없는 경우
      head = tail = null;
    } else if (node == head) { //첫번째 노드를 삭제하는 경우
      head = node.next;
    } else if (node == tail) {//마지막 노드를 삭제하는 경우
      tail = node.prev;
    } else { ////중간 노드를 삭제하는 경우
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

  public Object set(int index, Object value) { //특정 index node에 특정 값을 넣음
    Node node = getNode(index);
    Object old = node.value;
    node.value = value;
    return old; // 변경되기 전의 값 리턴
  }

  //해당 노드를 반환
  private Node getNode(int index) { //node의 index가 0보다 유효한 index 보다 큰 index를 요청하는지 확인
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








