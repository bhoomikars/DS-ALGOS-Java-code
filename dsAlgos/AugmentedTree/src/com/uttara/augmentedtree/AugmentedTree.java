package com.uttara.augmentedtree;


public class AugmentedTree {
	
	private ATreeNode root;
	
	private ATreeNode insert(ATreeNode root,int data) {
		
		if(null == root) {
			ATreeNode newNode = new ATreeNode(data);
			root = newNode;
		}
		else {
			if(data < root.getData()) {
				root.setLeft(insert(root.getLeft(), data));
			}
			else {
				root.setRight(insert(root.getRight(), data));
			}
			root.setSize(size(root.getLeft())+size(root.getRight())+1);
		}
		return root;
	}
	
	
	public void insertV(int data) {
		root = insert(root,data);
	}
	
	private ATreeNode search(ATreeNode node, int k) {
		int  r = size(node.getLeft())+1;
		if(k==r) 
			return node;
		else if(k<r) 
			return search(node.getLeft(), k);
		else {
			return search(node.getRight(), k-r);
		}
		
	}
	
	public int search(int k) {
		if(k>numNodes()) {
			System.out.println("Not So Many Elements");
			return 0;
		}
		return search(root, k).getData();
	}
	
	private  int size(ATreeNode node) {
		if(node == null)
			return 0;
		
		return node.getSize();	
	}
	
	private  void inOrder(ATreeNode root) {
		if(null == root) {
				return;
			}
			else { 
				inOrder(root.getLeft());
				System.out.print(" "+root.getData() + " " +root.getSize() +";");
				inOrder(root.getRight());
			}		
		}
	
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}
	
	private void preOrder(ATreeNode root) {
		if(null != root) {
		
			System.out.print(" " +root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
		
	}
	
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	
	public int numNodes() {
		if(null!= root)
			return root.getSize();
		else
			return 0;
	}
	
	//Delete a Node from the Tree
	public void  delete(int data) {
			root = delete(root, data);
		}
		
		
	private ATreeNode delete(ATreeNode root,int data) {
		ATreeNode temp;
			
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
		if(null != root)	
		root.setSize(size(root.getLeft())+size(root.getRight())+1);
		
		return root;
	}
		
	//Find the Maximum Value in the Tree
	private ATreeNode findMax(ATreeNode root) {
		ATreeNode temp = root;
		while(temp.getRight() != null) {
			temp = temp.getRight();
		}
		return temp;	
	   }
	

}
