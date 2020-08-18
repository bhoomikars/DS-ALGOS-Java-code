package com.uttara.avltree;

public class AVLTree {
	
	private AVLTreeNode root = null;
	
	
	public void insert(int data) {
		root = insert(root,data);
	}
	
	private AVLTreeNode insert(AVLTreeNode root, int data) {
		// TODO Auto-generated method stub
		if(null == root) {
			AVLTreeNode newNode = new AVLTreeNode(data);
			root=newNode;
		}
		else {
			if(data < root.getData()) {
				root.setLeft(insert(root.getLeft(), data));
				if(height(root.getLeft())-height(root.getRight())==2) {
					if(data<root.getLeft().getData())
						root = rotateRight(root);
					else 
						root = rotateLeftRight(root);
				}
			}
			else {
				root.setRight(insert(root.getRight(), data));
				if(height(root.getRight())-height(root.getLeft())==2) {
					if(data >= root.getRight().getData())
						root = rotateLeft(root);
					else
						root = rotateRightLeft(root);
				}
			}
		}
		root.setHeight(Math.max(height(root.getLeft()), height(root.getRight()))+1);
		return root;
	}
	
	private AVLTreeNode rotateRight(AVLTreeNode X) {
		AVLTreeNode W = X.getLeft();
		X.setLeft(W.getRight());
		W.setRight(X);
		X.setHeight(Math.max(height(X.getLeft()), height(X.getRight()))+1);
		W.setHeight(Math.max(height(W.getLeft()), X.getHeight())+1);
		return W;
	}
	
	private AVLTreeNode rotateLeft(AVLTreeNode W) {
		AVLTreeNode X = W.getRight();
		W.setRight(X.getLeft());
		X.setLeft(W);
		W.setHeight(Math.max(height(W.getLeft()),height(W.getRight())) +1);
		X.setHeight(Math.max(height(X.getRight()), W.getHeight()) +1);
		
		return X;
	}
	
	private AVLTreeNode rotateLeftRight(AVLTreeNode Z) {
		Z.setLeft(rotateLeft(Z.getLeft()));
		return rotateRight(Z);
	}
	
	private AVLTreeNode rotateRightLeft(AVLTreeNode X) {
		X.setRight(rotateRight(X.getRight()));
		return rotateLeft(X);
	}
	
	
	public int height(AVLTreeNode node) {
		if(null == node)
			return 0;
		return node.getHeight();
	}
	
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(AVLTreeNode root) {
		if(null != root) {
		
			System.out.print(" " +root.getData() + " " +root.getHeight() + ";");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
		
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private  void inOrder(AVLTreeNode root) {
	if(null == root) {
			return;
		}
		else { 
			inOrder(root.getLeft());
			System.out.print(" "+root.getData() + " " +root.getHeight() + ";");
			inOrder(root.getRight());
		}
		
		
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(AVLTreeNode root) {
		if(null == root) {
			return;
		}
		else {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(" " +root.getData() + " " +root.getHeight() + ";");
		}
		
	}
	
public void  delete(int data) {
		
		root = delete(root, data);
	}
	
	
	public AVLTreeNode delete(AVLTreeNode root,int data) {
		AVLTreeNode temp;
		
		if(null == root) {
			System.out.println("Element Not Found");
		}
		else if(data < root.getData()) {
			root.setLeft(delete(root.getLeft(), data));
		}
		else if(data > root.getData()) {
			root.setRight(delete(root.getRight(), data));
		}
		else {
			if(root.getLeft() != null && root.getRight() != null) {
				temp = findMax(root.getLeft()); 
				
				root.setData(temp.getData());
				
				root.setLeft(delete(root.getLeft(), root.getData()));
			}
			else {
				temp = root;
				
				 if(root.getLeft() == null) {
					root = root.getRight();
				}
				 else if(root.getRight() == null) {
					root = root.getLeft();
				}
				
				temp = null;
				
			}
		}
		
		//If tree had only one node
		if(null == root)
			return null;
		//Manipulate height of the current node
		root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);
		//Get the Balance Factor
		int balance = getBalance(root);
		
		if(balance > 1 && getBalance(root.getLeft()) >= 0)
			return rotateRight(root);
		if(balance > 1 && getBalance(root.getRight()) < 0) {
			return rotateLeftRight(root);
		}
		if(balance < -1 && getBalance(root.getRight()) <= 0)
			return rotateLeft(root);
		if(balance < -1 && getBalance(root.getRight()) > 0)
			return rotateRightLeft(root);
			
		
		return root;	
	}
	
	private int getBalance(AVLTreeNode root) {
		if(root == null)
			return 0;
		else
			return (height(root.getLeft()) - height(root.getRight()));
	}
	
	public AVLTreeNode findMax(AVLTreeNode root) {
		AVLTreeNode temp = root;
		while(temp.getRight() != null) {
			temp = temp.getRight();
		}
		return temp;
	}
	
	public void printLeaves() {
		printLeaves(root);
		System.out.println();
	}

	private void printLeaves(AVLTreeNode root) {
		if(root==null)
			return;
		if(root.getRight()==null && root.getLeft()==null)
			System.out.print(" " +root.getData());
		else {
			printLeaves(root.getLeft());
			printLeaves(root.getRight());
		}
		
	}
	
	public void printLeft() {
		printLeft(root);
		System.out.println();
	}

	private void printLeft(AVLTreeNode root) {
		if(null == root) 
			return;
		if(root.getLeft()==null && root.getRight()==null)
			return;
		System.out.print(" " +root.getData());
		if(root.getLeft() != null)
			printLeft(root.getLeft());
		else
			printLeft(root.getRight());	
	}
	
	public void printRight() {
		printRight(root.getRight());
		System.out.println();
	}

	private void printRight(AVLTreeNode root) {
		if(null == root) 
			return;
		if(root.getLeft()==null && root.getRight()==null)
			return;
		if(root.getRight() != null)
			printLeft(root.getRight());
		else
			printRight(root.getLeft());
		System.out.print(" " +root.getData());
		
	}
	
	//Print Only the Borders of the Tree
	public void printBorder() {
		printLeft();
		printLeaves();
		printRight();
	}
	
	//Is this AVL Tree
		public boolean isAVL() {
			if(-1==isAVL(root))
				return false;
			else
				return true;
			
		}

		private int isAVL(AVLTreeNode root) {
			int left,right;
			if(root==null)
				return 0;
			left = isAVL(root.getLeft());
			if(left==-1)
				return left;
			right = isAVL(root.getRight());
			if(right==-1)
				return right;
			if((Math.abs(left-right))>1)
					return -1;
			return Math.max(left, right)+1;
			
		}
}
