package com.uttara.avltree;

public class AVLMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree avlTree = new AVLTree();
		for (int i = 1; i < 13; i++) {
			avlTree.insert(i);
		}
		
		/*avlTree.insert(1);
		avlTree.insert(2);
		avlTree.insert(3);
		avlTree.insert(4);
		avlTree.insert(5);
		avlTree.insert(6);
		avlTree.insert(7);
		avlTree.insert(8);
		avlTree.insert(10);*/
		System.out.println("Check AVL : "+avlTree.isAVL());
		avlTree.preOrder();
		System.out.println();
		avlTree.inOrder();
		System.out.println();
		avlTree.postOrder();
		System.out.println();
		System.out.print("Deleting 9 : ");
		avlTree.delete(9);
		System.out.println();
		avlTree.inOrder();
		System.out.println("Check AVL : "+avlTree.isAVL());
		
		System.out.println();
		System.out.print("Deleting 10 : ");
		avlTree.delete(10);
		System.out.println();
		avlTree.inOrder();
		System.out.println("Check AVL : "+avlTree.isAVL());
		
		System.out.println();
		System.out.print("Deleting 6 : ");
		avlTree.delete(6);
		System.out.println();
		avlTree.inOrder();
		System.out.println("Check AVL : "+avlTree.isAVL());
		
		System.out.println();
		System.out.print("Deleting 8 : ");
		avlTree.delete(8);
		System.out.println();
		avlTree.inOrder();
		System.out.println("Check AVL : "+avlTree.isAVL());
		
		System.out.println();
		System.out.print("Deleting 5 : ");
		avlTree.delete(5);
		System.out.println();
		avlTree.inOrder();
		System.out.println("Check AVL : "+avlTree.isAVL());
		
		System.out.println();
		System.out.print("Deleting 1 : ");
		avlTree.delete(1);
		System.out.println();
		avlTree.inOrder();
		
		System.out.println();
		System.out.println("Printing only leaves");
		avlTree.printLeaves();
		System.out.println("Printing Left Border");
		avlTree.printLeft();
		System.out.println("Printing Right Border");
		avlTree.printRight();
		avlTree.printBorder();
		

	}

}
