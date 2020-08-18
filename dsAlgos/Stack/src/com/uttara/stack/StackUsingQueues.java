package com.uttara.stack;

public class StackUsingQueues {
	
	MyQueue queueOne = new MyQueue();
	MyQueue queueTwo = new MyQueue();
	
	public void push(int data) {
		if(queueOne.isEmpty())
			queueTwo.enQueue(data);
		else {
			queueOne.enQueue(data);
		}
	}
	
	public void traverse() {
		if(queueOne.isEmpty())
			queueTwo.traverse();
		else
			queueOne.traverse();
	}
	
	public int getSize() {
		if(queueOne.isEmpty())
		return queueTwo.getSize();
		else
			return queueOne.getSize();
	}
	
	public boolean isEmpty() {
		return (queueOne.isEmpty() && queueTwo.isEmpty());
	}
	
	public int pop() {
		int i=0,size;
		if(queueTwo.isEmpty()) {
			size = queueOne.getSize();
			while(i<(size-1)) {
				queueTwo.enQueue(queueOne.deQueue());
				i++;
			}
			return queueOne.deQueue();
		}
		else {
			size = queueTwo.getSize();
			while(i<(size-1)) {
				queueOne.enQueue(queueTwo.deQueue());
				i++;
			}
			return queueTwo.deQueue();
		}
		
	}

}
