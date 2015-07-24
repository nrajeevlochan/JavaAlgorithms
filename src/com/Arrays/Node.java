package com.Arrays;

public class Node<E> {
    private E element;
    private Node<E> next;
    public Node(E elem, Node<E> ne) {
        element = elem;
        next = ne;
    }

    public Node<E> getNext() {
        return next;
    }
    public void SetNext(Node<E> n) {
        next = n;
    }

    public E getElement() {
        return element;
    }
}
