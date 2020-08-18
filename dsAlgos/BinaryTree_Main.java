package com.uttara.tree;

public class BinaryTree_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binTree = new BinaryTree();
		binTree.insert(4);
		binTree.insert(45);
		binTree.insert(76);
		binTree.insert(87);
		binTree.insert(92);
		binTree.insert(6);
		binTree.insert(34);
		binTree.insert(95);
		System.out.println("Level Order Traversal");
		binTree.levelOrder();
		System.out.println();
		System.out.println("Pre Order Traversal");
		binTree.preOrderTraversal();
		System.out.println();
		System.out.println("In Order Traversal");
		binTree.inOrderTraversal();
		System.out.println();
		System.out.println("Post Order Traversal");
		binTree.postOrderTraversal();
		System.out.println();
		
		
	}

}
