package com.Arrays;

public interface Stack<E> {
    public void push(E e);
    public int size();
    public E pop();
    public boolean isEmpty();
    public E top();
}
