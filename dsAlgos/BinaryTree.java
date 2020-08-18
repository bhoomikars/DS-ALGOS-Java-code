package com.uttara.tree;

import java.util.LinkedList;


public class BinaryTree {
	
	private BinTreeNode root = null;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}	
	
	//Insert a Node
	public void insert(int data) {
		BinTreeNode temp;
		
		BinTreeNode newNode = new BinTreeNode(data);
		newNode.setLeft(null);
		newNode.setRight(null);
		
		if(null == root) {
			root = newNode;
			return;
		}
		
		LinkedList<BinTreeNode> queue = new LinkedList<BinTreeNode>();
		
		queue.addLast(root);
		while(!(queue.isEmpty())) {
			temp = queue.removeFirst();
			
			if(null != temp.getLeft()) {
				queue.addLast(temp.getLeft());
			}
				else {
					temp.setLeft(newNode);
					return;
				}
			if(null != temp.getRight()) {
				queue.addLast(temp.getRight());
			}
			else {
				temp.setRight(newNode);
				return;
			}
			
		}
	}
	
	
	//Level Order Traversal of the Tree
	public void levelOrder( ) {
		BinTreeNode temp = root;
		if(null == temp) {
			System.out.println("No Elements in the Tree");
			return;
		}
		
		LinkedList<BinTreeNode> queue = new LinkedList<BinTreeNode>();
		
		queue.addLast(temp);
		while(!(queue.isEmpty())) {
			temp = queue.removeFirst();
			System.out.print(" " +temp.getData());
			if(null != temp.getLeft()) {
				queue.addLast(temp.getLeft());
			}
			if(null != temp.getRight()) {
				queue.addLast(temp.getRight());
			}			
		}
	}
		
	//Pre Order Traversal (Recursive)
	public void preOrderTraversal() {
		preOrder(root);
	}
		
	private void preOrder(BinTreeNode root) {
			
		if(null != root) {
			System.out.print(" " +root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}	
	}
		
	//Post Order Traversal (Recursive)
	public void postOrderTraversal() {
		postOrder(root);
	}


		private void postOrder(BinTreeNode root) {
			if(null != root) {
				
				postOrder(root.getLeft());
				postOrder(root.getRight());
				System.out.print(" " +root.getData());
			}	
		}
		
	//In Order Traversal (Recursive)
	public void inOrderTraversal() {
			inOrder(root);
	}

	private void inOrder(BinTreeNode root) {
		if(null != root) {
			inOrder(root.getLeft());
			System.out.print(" " +root.getData());
			inOrder(root.getRight());	
		}		
	}
		
		public boolean isTreeEmpty() {
			return (root==null);
		}
		
		public BinTreeNode getRootNode() {
			return root;
		}
	
}
