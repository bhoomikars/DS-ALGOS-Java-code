package com.uttara.stack;

public class Stack {
	
	private StackNode top = null;
	
	public void push(int data ) {
		StackNode newNode = new StackNode(data);
		if(null == top) {
			top = newNode;
			return;
		}
		else {
			newNode.setNext(top);
			top = newNode;
		}
	}
	
	public int pop() {
		int value = 0;
		StackNode temp = top;
		if(null == temp) {
			System.out.println("Stack is Empty");
		}
		else {
			top = top.getNext();
			value = temp.getData();
			temp = null;
			
		}
		return value;		
	} 
	
	public int peek() {
		if(null != top)
			return top.getData();
		else
			return 0;
	}
	
	public boolean isEmpty() {
		return(null == top);
	}
	
	public void traverse() {
		System.out.println("Traversing Stack");
		StackNode temp = top;
		while(null != temp) {
			System.out.print(" " +temp.getData());
			temp = temp.getNext();	
		}
		System.out.println();
	}

}
