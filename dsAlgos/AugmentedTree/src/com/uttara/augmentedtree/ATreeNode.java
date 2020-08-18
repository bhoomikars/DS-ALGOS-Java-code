package com.uttara.augmentedtree;

public class ATreeNode {
	
	private int data;
	private ATreeNode left; 
	private ATreeNode right;
	private int size;
	
	public ATreeNode(int data) {
		
		this.data = data;
		this .size = 1;
		this.left = null;
		this.right = null;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ATreeNode getLeft() {
		return left;
	}
	public void setLeft(ATreeNode left) {
		this.left = left;
	}
	public ATreeNode getRight() {
		return right;
	}
	public void setRight(ATreeNode right) {
		this.right = right;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
