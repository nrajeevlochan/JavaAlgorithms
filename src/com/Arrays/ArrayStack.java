package com.Arrays;

public class ArrayStack<E> implements Stack<E>{
    public static final int CAPACITY = 1000;
    private E[] data;
    int stackSize = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E e) {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++stackSize] = e;
    }

    @Override
    public int size() {
        return stackSize + 1;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E popItem = data[stackSize];
        data[stackSize] = null;
        stackSize--;
        return popItem;
    }

    @Override
    public boolean isEmpty() {
        return stackSize == -1;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[stackSize];
    }
}
