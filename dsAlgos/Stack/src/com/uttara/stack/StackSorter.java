package com.uttara.stack;

public class StackSorter {
	
	public Stack sort(Stack source) {
		Stack dest = new Stack();
		while(!source.isEmpty()) {
			int temp = source.pop();
			while(!dest.isEmpty() && dest.peek() < temp) {
				source.push(dest.pop());
			}
			dest.push(temp);
		}
		
		return dest;
	}

}
