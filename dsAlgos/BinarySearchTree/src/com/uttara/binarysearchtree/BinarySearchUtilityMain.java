package com.uttara.binarysearchtree;

public class BinarySearchUtilityMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree binTree = new BinarySearchTree();
		 binTree.insert(13);
		 binTree.insert(2);
		 binTree.insert(8);
		 binTree.insert(10);
		 binTree.insert(7);
		 binTree.insert(15);
		 binTree.insert(25);
		 binTree.insert(11);
		 binTree.insert(12);
		 
		 BinarySearchTree subTree=new BinarySearchTree();
		 subTree.insert(8);
		 subTree.insert(7);
		 subTree.insert(11);
		 
		 System.out.println("Is T2 subtree of T1 : " +BinarySearchUtility.subTree(binTree.getRootNode(), subTree.getRootNode()));
		 
		 BinaryTreeNode  dllhead = BinarySearchUtility.constructDLL(binTree.getRootNode());
		 System.out.println("DLL Traversal");
		 BinarySearchUtility.traverse(dllhead);
		 
		 System.out.println("Building Binary Tree using PreOrder and InOrder Travesal");
		 int[] preOrder = new int[]{7,3,1,0,2,5,4,6,11,9,8,10,13,12,14,15};
		 int[] inOrder = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		 BinaryTreeNode rootNode = BinarySearchUtility.buildBinaryTree(preOrder, inOrder, 0, 15);
		 BinarySearchUtility.preOrder(rootNode);
		 System.out.println();
		 BinarySearchUtility.inOrder(rootNode);
		 System.out.println();
		 BinarySearchUtility.resetIndexValue();
		 System.out.println("PreIndex Value after reset : " +BinarySearchUtility.getPreIndex());

	}

}
