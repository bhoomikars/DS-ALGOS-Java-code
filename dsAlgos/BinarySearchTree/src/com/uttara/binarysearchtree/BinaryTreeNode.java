package com.uttara.binarysearchtree;

public class BinaryTreeNode{
	
	private int data;
	private BinaryTreeNode left = null;
	private BinaryTreeNode right = null;
	
	
	public BinaryTreeNode() {
		
	}
	
	
	/**
	 * @param data
	 */
	public BinaryTreeNode(int data) {
		super();
		this.data = data;
	}
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	/**
	 * @return the left
	 */
	public BinaryTreeNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BinaryTreeNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
		
}
