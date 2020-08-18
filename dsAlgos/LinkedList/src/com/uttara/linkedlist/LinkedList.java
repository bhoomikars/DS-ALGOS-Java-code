package com.uttara.linkedlist;



public class LinkedList {

	private Node head = null;
	private int size = 0;
	
	
	
	public LinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkedList(Node head) {
		super();
		this.head = head;
	}

	protected Node getHead() {
		return head;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (null == head);
	}
	
	public int getSize() {
		return size;
	}
	
	public void insert(int data) {
		//Create a new node
		Node newNode = new Node(data);
		//If it is the head node
		if(null == head) {
			head = newNode;
		}
		else {
			//Traverse till the end
			Node temp = head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			// Append new node to last node
			temp.setNext( newNode);
		}
		size++;
	}
	
	public void insertBefore(int data) {
		//Create a new node
		Node newNode = new Node(data);
		//If it is the head node
		if(null == head) {
			head = newNode;
		}
		else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}
	
	public Node insertWithReturn(int data) {
		Node newNode = new Node(data);
		if(null == head) {
			head = newNode;
			return head;
			
		}
		else {
			Node temp = head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			
			temp.setNext( newNode);
			return newNode;
		}
		
	}
	
	public void delete(int data) {
		//If no nodes in linked list
		if(head == null) {
			System.out.println("No elements in the list");
			return;
		}
		//if node to be deleted is head node
		if(head.getData() == data) {
			Node temp = head;
			head = head.getNext();
			temp = null;
			size--;
			return;
		}
		
		else {
			Node previous = head;
			Node current = previous.getNext();
			//Traverse the list for node to be deleted
			while(current != null) {
			if(current.getData() == data){
				//if found, set previous.next with current.next
				previous.setNext(current.getNext());
				current.setNext(null);
				return;
				}
			
			previous = current;
			current = current.getNext();
			
			}
			//if node to be deleted is not found
			if(null == current) {
				System.out.println("No Specified element in the list");
			}
		}
		size--;
			
	}
	
	public void traverse() {
		Node temp = head;
		//Traverse till the end node by node
		while(null != temp) {
			//display data in each node
			System.out.print(" " +temp.getData());
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	public void reverse() {
		//Set prev node with null and current with head 
		Node prev = null;
		Node current = head;
		while( current != null ) {
			//set temp node to current.next
			Node temp = current.getNext();
			//Point current.next to prev
			current.setNext(prev);
			//move prev and current by one
			prev = current;
			current = temp;	
		}
		//set head node with prev
		head = prev;
	}
	
	public void reverseRecursive() {
		Node prev = null;
		//Node current = head;
		reverseRec(prev, head);
	}

	private void reverseRec(Node prev, Node current) {
		if(null == current) {
			head = prev;
			return;
		}
		Node temp = current.getNext();
		current.setNext(prev);
		reverseRec(current, temp);	
	}
	
	public boolean isLinkedListEvenLength() {
		Node temp = head; 
		while(temp != null && temp.getNext() != null) {
			temp = temp.getNext().getNext();
		}
		if(temp == null)
			return true;
		else
			return false;
	}
	
	public void printReverse() {
		printRec(head);
	}

	private void printRec(Node head) {
		if(null == head)
			return;
		printRec(head.getNext());
		System.out.print(" " +head.getData());
		
	}
	
	public boolean hasCycle() {
		
		Node slowRunner = head;
		Node fastRunner = head;
		
		while(null!=fastRunner && null!=fastRunner.getNext()) {
			slowRunner = slowRunner.getNext();
			fastRunner = fastRunner.getNext().getNext();
			if(slowRunner == fastRunner)
				return true;
		}
		
		if(null==fastRunner ||  null==fastRunner.getNext())
			return false;	
		return false;
		
	}
		
	//Finding the middle element
	public Node getMiddle() {
	    if(head == null) { return head; }
	    Node slow, fast; slow = fast = head;
	    while(fast != null && fast.getNext() != null) {
	        slow = slow.getNext(); fast = fast.getNext().getNext();
	    }
	    return slow;
	}
	
	
}
