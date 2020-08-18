package com.uttara.stack;

public class MyQueue {
	
	private QueueNode front = null;
	private QueueNode rear = null;
	private int size = 0;
	
	public void enQueue(int data) {
		QueueNode newNode = new QueueNode(data);
		if(size == 0){
			front = rear = null;
		}
		if(front == rear) {
			if(null == front)  {
				front = rear = newNode;
			}
			else {
				rear.setNext(newNode);
				rear = newNode;
			}
			
		}
		else {
			rear.setNext(newNode);
			rear = newNode;
		}
		size++;
		
	}
	
	public int deQueue() {
		int value = 0;
		QueueNode temp = front;
		if(null == front) {
			rear = null;
			System.out.println("Queue is Empty");
		}
		else {
			front = front.getNext();
			value = temp.getData();
			temp = null;
		}
		size--;
		return value;
		
	}
	
	public  void traverse() {
		QueueNode temp = front;
		if(front == null) {
			System.out.println("Queue is Empty");
		}
		else {
			while(temp != rear) {
				System.out.print(" "+temp.getData());
				temp = temp.getNext();
			}
			System.out.print(" "+temp.getData());
			System.out.println();
		}
		
	}
	
	public boolean isEmpty() {
		return(size ==0);
	}
	
	public int getSize() {
		return size;
	}

}
