package com.johnowl;

public class LinkedLists {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.print();
        list.remove(1);
        list.print();
        list.remove(3);
        list.print();
        list.remove(4);
        list.print();
        list.remove(2);
        list.print();
    }
}


class Node {
    private final Object value;
    private Node next;

    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}

class DoublyNode {

    private Object value;
    private DoublyNode next;
    private DoublyNode previous;

    public DoublyNode(Object value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public Object getValue() {
        return value;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public DoublyNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyNode previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "DoublyNode{" +
                "value=" + value +
                ", next=" + (next == null ? "null" : next.value) +
                ", previous=" + (previous == null ? "null" : previous.value) +
                '}';
    }
}

class DoublyLinkedList {
    private DoublyNode head = null;
    private DoublyNode tail = null;
    private int size = 0;

    public void append(Object value) {
        if (head == null) {
            head = new DoublyNode(value);
            tail = head;
        } else {
            DoublyNode newNode = new DoublyNode(value);
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    public void remove(Object value) {
        DoublyNode current = head;
        DoublyNode previous = null;
        while (current != null) {
            if (current.getValue() == value) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                if (current.getNext() != null) {
                    current.getNext().setPrevious(previous);
                } else {
                    tail = current.getPrevious();
                }
                size--;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public void print() {
        System.out.println("First = " + head);
        System.out.println("Last = " + tail);
        System.out.println("Items: ");
        if (size == 0) {
            System.out.println("empty");
            return;
        } else {
            DoublyNode current = head;
            while(current != null) {
                System.out.println(current);
                current = current.getNext();
            }
        }
        System.out.println("-----------------");
    }

    public int getSize() {
        return size;
    }
}

class LinkedList {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public void insert(Object value) {
        if (size == 0) {
            first = new Node(value, null);
            last = first;
        } else {
            first = new Node(value, first);
        }
        size++;
    }

    public void append(Object value) {
        if (size  == 0) {
            first = new Node(value, null);
            last = first;
        } else {
            last.setNext(new Node(value, null));
            last = last.getNext();
        }

        size++;
    }

    public void remove(Object value) {
        Node next = first;
        Node previous = null;
        while (next != null) {
            if (next.getValue().equals(value)) {
                if (previous != null) {
                    previous.setNext(next.getNext());
                } else {
                    first = next.getNext();
                }
                size--;
                break;
            }
            previous = next;
            next = next.getNext();
        }
    }

    public void reverse() {
        Node next = first;
        Node previous = null;
        for (int i = 0; i < size; i++) {
            final Node tempNext = next.getNext();
            next.setNext(previous);
            previous = next;
            next = tempNext;
        }
        final Node tempFirst = first;
        first = last;
        last = tempFirst;
    }

    public void print() {


        System.out.println("First = " + first);
        System.out.println("Last = " + last);
        System.out.println("Items: ");

        if (size == 0) {
            System.out.println("empty");
            return;
        } else {
            Node current = first;
            while (current != null) {
                System.out.println(current);
                current = current.getNext();
            }
        }
        System.out.println("-------------------");
    }

}
