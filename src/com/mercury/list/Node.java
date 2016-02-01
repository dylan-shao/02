package com.mercury.list;

/**
 * A node to be used for a singly-linked list.
 */
public class Node<E> {
    private E data;
    private Node<E> link;

    public Node(E data, Node<E> link) {
        this.data = data;
        this.link = link;
    }

    public Node() {

    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLink() {
        return link;
    }

    public void setLink(Node<E> link) {
        this.link = link;
    }

}
