package com.uttara.avltree;

public class AVLTreeNode {
		
		private int data;
		private AVLTreeNode left;
		private AVLTreeNode right;
		private int height;
		
	
		
		
		public AVLTreeNode(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.height = 0;
			this.left = null;
			this.right = null;
			
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public AVLTreeNode getLeft() {
			return left;
		}
		public void setLeft(AVLTreeNode left) {
			this.left = left;
		}
		public AVLTreeNode getRight() {
			return right;
		}
		public void setRight(AVLTreeNode right) {
			this.right = right;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
	
}
