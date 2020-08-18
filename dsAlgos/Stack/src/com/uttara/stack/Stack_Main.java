/**
 * 
 */
package com.uttara.stack;

/**
 * @author A
 *
 */
public class Stack_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//Stack Example	 and Stack Sorter
		Stack stack = new Stack();
		stack.push(2);
		stack.push(18);
		stack.push(25);
		stack.push(8);
		
		stack.traverse();
		
		System.out.println(" Poping :  "+stack.pop());
		stack.traverse();
		
		System.out.println("Sorting Stack");
		
		StackSorter sortStack = new StackSorter();
		Stack sortedStack = sortStack.sort(stack);
		while(!sortedStack.isEmpty()) {
			System.out.print(" " +sortedStack.pop());
		}
		System.out.println();
		
		System.out.println("Is original stack empty : " +stack.isEmpty());
			
		
		// Min Stack Example
		MinStack minStack = new MinStack();
		minStack.push(25);
		minStack.push(15);
		minStack.push(35);
		minStack.push(5);
		minStack.push(75);
		
		while(!minStack.isEmpty()) {
			System.out.println("Min " +minStack.getMinimum());
			System.out.println("Pop " +minStack.pop());
			minStack.traverse();
			System.out.println("*************************");	
		}
		
		// Stack using Two Queues
		StackUsingQueues queueStack = new StackUsingQueues();
		queueStack.push(5);
		queueStack.push(17);
		queueStack.push(4);
		queueStack.push(35);
		queueStack.pop();
		queueStack.push(35);
		queueStack.push(45);
		System.out.print("Pushing : ");
		queueStack.traverse();
		
		
		
		System.out.println("Size : " +queueStack.getSize());
		System.out.print("Poping :");
		while(!queueStack.isEmpty()) {
			System.out.print(" " +queueStack.pop());
		}
		System.out.println();
	}

}
