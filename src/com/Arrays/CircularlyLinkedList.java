package com.Arrays;

public class CircularlyLinkedList<E> {

    private Node<E> tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<E>(e, null);
            tail.SetNext(tail);
        }
        Node<E> newest = new Node<E>(e, tail);
        tail.SetNext(newest);
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if(isEmpty()) {
            return null;
        }
        Node<E> head = tail.getNext();
        if (tail == head) {
            tail = null;
        } else {
            tail.SetNext(head.getNext());
        }
        size--;
        return head.getElement();
    }

}
