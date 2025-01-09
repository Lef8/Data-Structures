/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
	Name: Anna-Lefkothea Papavasileiou
	Student Number: 6190101
*/

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl<T> implements StringDoubleEndedQueue<T> {

    private Node first; // Front of the queue
    private Node last;  // End of the queue
    private int size;   // Number of elements in the queue

    private class Node {
        T item;
        Node next;
        Node prev;

        Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    
    public StringDoubleEndedQueueImpl() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, first, null);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    @Override
    public T removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return item;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, null, last);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public T removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = last.item;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return item;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }
    
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    @Override
    public void printQueue(PrintStream stream) {
        Node current = first;
        while (current != null) {
            stream.print(current.item + " ");
            current = current.next;
        }
        stream.println();
    }

    @Override
    public int size() {
        return size;
    }
}