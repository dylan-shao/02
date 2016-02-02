package com.mercury.list;

import java.util.*;

/**
 * Your linked list implementation.
 */
public class LinkedList<E> implements List<E>, Iterable<E> {

	private Node<E> head, tail;
	int length = 0;

	public LinkedList() {
		// Your code here
	}

	public boolean isEmpty() {
		// Your code here
		return head == null;
	}

	public void add(E item) {
		if (head == null)
			head = new Node<E>(item, head);
		else {
			Node<E> tmp = head;
			while (tmp.getLink() != null)
				tmp = tmp.getLink();
			tmp.setLink(new Node<E>(item, null));

		}
	}

	public void add(E... items) {
		int numNew = items.length;
		if (numNew == 0)
			return;

		for (int i = 0; i < numNew; i++) {
			this.add(items[i]);
		}
		return;

	}

	public void add(E item, int pos) throws IndexOutOfBoundsException {
		if (head == null)
			return;

		if (pos == 0) {
			head = new Node<E>(item, head);
			return;
		}

		Node<E> prev = null;
		Node<E> cur = head;
		int i = 0;
		while (cur != null && i < pos) {
			prev = cur;
			cur = cur.getLink();
			i++;
		}
		if (cur != null)
			prev.setLink(new Node<E>(item, cur));
	}

	public void remove(int pos) throws IndexOutOfBoundsException {
		if (head == null)
			return;

		if (pos == 0) {
			head = head.getLink();
			return;
		}

		Node<E> prev = null;
		Node<E> cur = head;
		int i = 0;
		while (cur != null && i < pos) {
			prev = cur;
			cur = cur.getLink();
			i++;
		}
		if (cur != null)
			prev.setLink(cur.getLink());
	}

	public E get(int pos) throws IndexOutOfBoundsException {
		Node<E> tmp = head;
		if (tmp == null)
			throw new IndexOutOfBoundsException();
		for (int i = 0; i < pos; i++) {
			tmp = tmp.getLink();
		}

		if (tmp == null)
			throw new IndexOutOfBoundsException();

		return tmp.getData();

	}

	public int length() {
		Node<E> tmp = head;
		if (head == null)
			return 0;
		int j = 1;

		while (tmp.getLink() != null) {
			j++;
			tmp = tmp.getLink();

		}

		return j;

	}

	public boolean contains(E target) {
		 Node<E> tmp = head;
		 for(int i=0;i<this.length();i++){
		 if(tmp.getData().equals(target)){
		 return true;
		 }
		 tmp = tmp.getLink();
		 }
		 return false;

		 /*
		  *Must implements Iterable and override Iterator to use the following method
		  */
//		for (E tmp : this)
//			if (tmp.equals(target))
//				return true;
//
//		return false;
	}

	public int findFirst(E target) throws NoSuchElementException {
		Node<E> tmp = head;
		 for(int i=0;i<this.length();i++){
			 if( tmp.getData().equals(target)) return i;
			 tmp = tmp.getLink();
		 }
		 return -1;
	}

	public void reverse() {
		//LinkedList<E> list = new LinkedList<E>();
	      Node<E> cur = head;
	      Node<E> prev = null;
	      while(cur != null)
	      {
	    	 Node<E> next = cur.getLink();
	    	 cur.setLink(prev);
	         prev = cur;
	         cur = next;
	      }
	      head = prev;
	     // System.out.println(head.getLink().getLink().getData());  print out 4
	      
	      
	}

	public void printList() {
		// Your code here
	}

	
	
	public Iterator<E> iterator() {
		return (Iterator<E>) new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<E> {
		private Node<E> nextNode;

		public LinkedListIterator() {
			nextNode = head;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E res = nextNode.getData();
			nextNode = nextNode.getLink();
			return res;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}