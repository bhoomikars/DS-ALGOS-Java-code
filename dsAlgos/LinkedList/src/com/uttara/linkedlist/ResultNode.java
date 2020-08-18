package com.uttara.linkedlist;

public class ResultNode {
	private Node node;
	private boolean isPalindrome;
	
	public ResultNode(Node node, boolean isPalindrome) {
		super();
		this.node = node;
		this.isPalindrome = isPalindrome;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public boolean isPalindrome() {
		return isPalindrome;
	}

	public void setPalindrome(boolean isPalindrome) {
		this.isPalindrome = isPalindrome;
	}
	
	

}
