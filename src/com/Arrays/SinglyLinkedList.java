package com.Arrays;

public class SinglyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
        
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E first) {
        head = new Node<E>(first, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E last) {
       Node<E> newest = new Node<E>(last, null);
       if (isEmpty()) {
           head = newest;
       } else {
           tail.SetNext(newest);
       }
       tail = newest;
       size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0) {
            tail = null;
        }
        return answer;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }
}
