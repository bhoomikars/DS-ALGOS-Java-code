/**
 * 
 */
package com.uttara.binarysearchtree;

/**
 * @author A
 *
 */
public class BinarySearchTree_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree binTree = new BinarySearchTree();
		 binTree.insertIterative(20);
		 binTree.insertIterative(10);
		 binTree.insertIterative(30);
		 binTree.insertIterative(5);
		 binTree.insertIterative(15);
		 binTree.insertIterative(13);
		 binTree.insertIterative(18);
		 binTree.insertIterative(14);
		 
		System.out.println("Is the Tree BST : " +binTree.isBinarySearchTree());
		System.out.println("Is BST Improved : " +binTree.isBSTImprovedSec());
		System.out.println("Is this Tree Balanced = " +binTree.isBalanced());
		//System.out.println("Find LCA : "+binTree.findLCA(12,25).getData());
	
		System.out.println("PreOrder Traversal ");
		binTree.preOrder();
		System.out.println();
		binTree.preOrderIterativeImp();
		System.out.println();
		
		System.out.println("PostOrder Traversal ");
		binTree.postOrder();
		System.out.println();
		
		System.out.println("InOrder Traversal");
		
		binTree.inOrder();
		System.out.println();
		
		System.out.println("LevelOrder Traversal");
		binTree.levelOrderCustom();
		System.out.println();
		
		System.out.println("Height of the Tree : " +binTree.heightBST());
		
		
		//System.out.println("6th Node : " +binTree.pubkthSmallestNode(4).getData());
		//binTree.pubkthSmallestNode(4);
		
		System.out.println("6th Node : " +binTree.pubkthSmallestNodeSecond(6).getData());
		System.out.println("4th Node : "+binTree.pubkthSmallestNodeSecond(4).getData());
		
		System.out.println("Print Paths");
		binTree.printPaths();
		
		System.out.println("Diameter of the Tree : " +binTree.diameterTree());
		System.out.println("Print Ancestor : " +binTree.printAllAncestors(8));
		
		System.out.println("Sum of Elements in the tree = " +binTree.treeSum());
		
		//System.out.println("Deletion");
		//binTree.delete(5);
		//System.out.println("After Deletion");
		System.out.println("PreOrder Traversal ");
		binTree.preOrder();
		System.out.println();
		
		System.out.println("PostOrder Traversal ");
		binTree.postOrder();
		System.out.println();
		
		System.out.println("InOrder Traversal");
		binTree.inOrder();
		System.out.println();
		
		/*System.out.println("pre Order Successors : ");
		BinaryTreeNode node = binTree.preOrderSuccessor(binTree.getRootNode());
		System.out.print(" "+node.getData());
		System.out.print(" "+binTree.preOrderSuccessor(null).getData());
		System.out.print(" "+binTree.preOrderSuccessor(null).getData());
		System.out.print(" "+binTree.preOrderSuccessor(null).getData());
		System.out.print(" "+binTree.preOrderSuccessor(null).getData());
		System.out.println();*/
		
		System.out.println("pre order Successor Second : ");
		CessorResult res= binTree.preSuccessor(18);
		System.out.println(" "+res.isFound());
		if(res.isFound() && res.getResult()!=null)
			System.out.println(" "+res.getResult().getData());
		else
			System.out.println("No Successor present: ");
		
		System.out.println("pre order predecessor Second : ");
		CessorResult resPre= binTree.prePredecessor(18);
		System.out.println(" "+resPre.isFound());
		if(resPre.isFound() && resPre.getResult()!=null)
			System.out.println(" "+resPre.getResult().getData());
		else
			System.out.println("No Predecessor: ");
		
		System.out.println("Print the values in the range : ");
		binTree.printRange(5, 15);
		System.out.println("InOrder Traversal ");
		binTree.inOrder();
		System.out.println();
		
		System.out.println("Pruning the tree : ");
		binTree.pruneTree(12, 25);
		System.out.println("InOrder Traversal ");
		binTree.inOrder();
		System.out.println();
	}

}
