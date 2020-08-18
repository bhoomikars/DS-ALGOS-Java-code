package com.uttara.stack;

public class MinStack extends Stack{
	
	private Stack genStack = new Stack();
	private Stack minStack = new Stack();
	
	@Override
	public void push(int data) {
		genStack.push(data);
		if(minStack.isEmpty() || minStack.peek() >= data)
			minStack.push(data);
		
	}
	@Override
	public int pop() {
		int value = genStack.pop();
		if(minStack.peek() == value)
			minStack.pop();
		return value;
		
	}
	
	@Override
	public int peek() {
		return genStack.peek();
	}
	
	@Override
	public boolean isEmpty() {
		return genStack.isEmpty();
	}
	
	@Override
	public void  traverse() {
		genStack.traverse();
	}
	
	public int getMinimum() {
		return minStack.peek();
		
	}
	
	
	
	
	

}
