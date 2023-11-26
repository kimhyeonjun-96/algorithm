package data_structure;

/*
* 1. 간단한 개념 설명
*   a. List
*      배열과 많이 비교
*      원소에 순서가 있는 선형 데이터 구조! ( 그래서 배열과 비교가 많이 된다 )
*      동일한 타입의 여러 원소를 선형 집합으로 관리하는 동적 데이터 구
*      원소가 추가/삭제에 따라 크기가 변경 가능!
*      List 인터페이스 구현체에 따라 특성이 다름!!
*       - ArrayList
*           index를 통한 원소 접급니 빠르지만 원소의 삽입/제거가 느림
*       - LinkedList
*           index를 통한 원소 접근이 느리지만 원소의 삽입/제거가 빠름
*       - Vector
*           ArrayList와 비슷하며 thread-safe하기에 비교적 느릴수 있음
*   b. ArrayList
*      동적 배열을 사용한 List 구현체
*       - 원소가 추가될 때 배열에 남은 공간이 없다면 크기를 일정 배수로 늘린 배열을 만들어 기존 원소를 옮긴다
*       - 원소가 배열에 저장되어 있기 때문에 지정한 위치의 원소 접근이 빠르다
*       - 중간 원소의 삽입/제거 연산은 기존 배열 연산과 같이 해당 위치 이후의 모든 원소를 이동시키므로 느리다
*   c. LinkedList
*      차례로 연결된 Node를 사용한 구현체
*       - 원소가 추가/삭제될 때마다 해당 원소의 노드가 추가/삭제 된다
*       - 지정된 위치의 원소 접근하기 위해서는 성형 탐색이 필요
*       - 순차적인 접근 시 iterator를 사용해 효율저긍로 관리할 수 있다
*       - 중간 원소 삽입/제거 연산은 해당 노드와 연결된 참조값만을 갱신하여 다른 노드에 영향을 미치지 않는다
* 2.
* */

import java.util.Arrays;
import java.util.Objects;

class MyArrayList<E>{
    private static final int DEFAULT_CAPACIT = 10;
    private int size = 0;
    private Object[] elementsData;

    public MyArrayList(){
        elementsData = new Objects[DEFAULT_CAPACIT];
    }
    public MyArrayList(int initialCapacity) {
        elementsData = new Objects[initialCapacity];
    }
    public void add(E e){
        if(size == elementsData.length){
            growCapacity();
        }
        elementsData[size++] = e;
    }
    private void growCapacity() {
        int newCapacity = elementsData.length + (elementsData.length >> 1);
        elementsData = Arrays.copyOf(elementsData, newCapacity);
    }
    public void insert(int idx, E e){
        if(size == elementsData.length) growCapacity();
        System.arraycopy(elementsData, idx, elementsData, idx+1, size++ - idx);
        elementsData[idx] = e;
    }
    public void remove(int idx){
        int copyLength = elementsData.length - idx - 1;
        System.arraycopy(elementsData, idx+1, elementsData, idx, copyLength);
        size--;
    }
}

class MyLinkedList<E>{
    private int size = 0;
    private Node<E> firstNode = null;
    private Node<E> lastNode = null;

    public static class Node<E> {
        E item;
        Node<E> next;
        Node(E element, Node<E> next){
            this.item = element;
            this.next = next;
        }
    }
    public void addLast(E element){
        Node<E> newNode = new Node<>(element, null);
        if(size == 0) firstNode = newNode;
        else lastNode.next = newNode;
        lastNode = newNode;
        size++;
    }
    public void addFirst(E element){
        Node<E> newNode = new Node<>(element, firstNode);
        if(size == 0) lastNode = newNode;
        firstNode = newNode;
        size++;
    }
    public Node<E> getNode(int idx){
        Node<E> currentNode = firstNode;
        while (idx-- > 0){
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    public E get(int idx){
        return getNode(idx).item;
    }
    public void insert(Node<E> prevNode, E element){
        Node<E>  newNode = new Node<>(element, prevNode.next);
        prevNode.next = newNode;
        if(newNode.next == null) lastNode = newNode;
        size++;
    }
    public void insert(int idx, E element){
        if(idx == 0) addFirst(element);
        else if (idx == size) addLast(element);
        else insert(getNode(idx-1), element);
    }
    public void removeNext(Node<E> prevNode){
        if(prevNode.next == null) return;
        prevNode.next = prevNode.next.next;
        if(prevNode.next == null) lastNode = prevNode;
        size--;
    }
//    public void remove(int idx){
//        if(idx == 0) removeFirst();
//        else removeNext(getNode(idx-1));
//    }
}
public class DataStructure_List {

}

