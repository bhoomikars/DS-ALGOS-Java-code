package com.uttara.augmentedtree;


public class AugmentedTreeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AugmentedTree augTree = new AugmentedTree();
		augTree.insertV(13);
		augTree.insertV(2);
		augTree.insertV(8);
		augTree.insertV(10);
		augTree.insertV(7);
		augTree.insertV(15);
		augTree.insertV(25);
		 augTree.inOrder();
		 augTree.preOrder();

		 System.out.println("Third Node : " +augTree.search(3));
		 System.out.println("Seventh Node : " +augTree.search(7));
		 System.out.println("Fifth Node : " +augTree.search(5));
		 System.out.println("Size at Root node  : " +augTree.numNodes());
		 System.out.println("Tenth Node : " +augTree.search(10));
		 
		 System.out.println("Deleting 8 On Tree : ");
		 augTree.delete(8);
		 augTree.inOrder();
		 System.out.println();
		 
		 System.out.println("Deleting 25 On Tree : ");
		 augTree.delete(15);
		 augTree.inOrder();
		 System.out.println();
		 
		 AugmentedTree augmentedTree = new AugmentedTree();
		 augmentedTree.insertV(34);
		 augmentedTree.insertV(24);
		 augmentedTree.insertV(48);
		 augmentedTree.inOrder();
		 augmentedTree.preOrder();
		 System.out.println("Size at Root Node : " +augmentedTree.numNodes());
		 
	}

}
