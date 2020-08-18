package com.uttara.binarysearchtree;

public class CessorResult {
	
	private BinaryTreeNode result;
	private boolean found;
	
	
	
	public CessorResult(BinaryTreeNode result, boolean found) {
		super();
		this.result = result;
		this.found = found;
	}
	public BinaryTreeNode getResult() {
		return result;
	}
	public void setResult(BinaryTreeNode result) {
		this.result = result;
	}
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	
	
	
}
