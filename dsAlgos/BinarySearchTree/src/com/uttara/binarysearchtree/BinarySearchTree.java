package com.uttara.binarysearchtree;

import java.util.LinkedList;
import java.util.Stack;

import com.uttara.genericqueue.GenericQueue;



public class BinarySearchTree {
	
	private BinaryTreeNode root = null;
	private  int count = 0;
	private int diameter;
	private int prev;
	
	private Stack<BinaryTreeNode> s=new Stack<>();
	private BinaryTreeNode n;
	
	//Insert into the Tree
	public void insert(int data) {
		root = insert(root,data);
	}
	
	public BinaryTreeNode getRootNode() {
		return root;
	}
	
	public BinaryTreeNode insert(BinaryTreeNode root,int data) {
		if(null == root) {
			BinaryTreeNode newBinNode = new BinaryTreeNode(data);
			root = newBinNode;
		}
		else {
			if(data < root.getData()) {
				root.setLeft(insert(root.getLeft(), data));
			}
			else {
				root.setRight(insert(root.getRight(), data));
			}
		}
		return root;
	}
	
	public void insertIterative(int value) {  
		if(root == null) {
			root = new BinaryTreeNode(value);
			return;
		}
	    BinaryTreeNode current = root;
	    while (current != null)
	    {
	        if(value < current.getData())  {       
	            if(current.getLeft() == null) { 
	            	current.setLeft(new BinaryTreeNode(value)); 
	            	return; 
	            }
	            else {
	            	current = current.getLeft();  
	            }
	        }
	        else {
	            if(current.getRight() == null) { 
	            	current.setRight(new BinaryTreeNode(value));
	            	return; 
	            }
	            else {
	            	current = current.getRight(); 
	            }
	        }
	    }
	}
	
	//PreOrder Traversal
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(BinaryTreeNode root) {
		if(null != root) {
		
			System.out.print(" " +root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
		
	}
	
	//InOrder Traversal
	public void inOrder() {
		inOrder(root);
	}
	
	private  void inOrder(BinaryTreeNode root) {
	if(null == root) {
			return;
		}
		else { 
			inOrder(root.getLeft());
			System.out.print(" "+root.getData());
			inOrder(root.getRight());
		}	
	}
	
	//PostOrder Traversal
	public void postOrder() {
		postOrder(root);
	}
	
	public void postOrder(BinaryTreeNode root) {
		if(null == root) {
			return;
		}
		else {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(" " +root.getData());
		}
		
	}
	
	//Delete a Node from the Tree
	public void  delete(int data) {
		
		root = delete(root, data);
	}
	
	
	public BinaryTreeNode delete(BinaryTreeNode root,int data) {
		BinaryTreeNode temp;
		if(null == root) {
			System.out.println("Element Not Found");
			return null;
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
				//temp = root;
				
				 if(root.getLeft() != null) {
					root = root.getLeft();
				}
				 else if(root.getRight() != null) {
					root = root.getRight();
				}
				 else {
					 root = null;
				 }
					 
				root = null;
			}
				
		}
		return root;
		
	}
	
	//Find the Maximum Value in the Tree
	private BinaryTreeNode findMax(BinaryTreeNode root) {
		BinaryTreeNode temp = root;
		while(temp.getRight() != null) {
			temp = temp.getRight();
	}
		return temp;
   }
	
	//Find the Maximum Value in the Tree
		private BinaryTreeNode findMin(BinaryTreeNode root) {
			BinaryTreeNode temp = root;
			while(temp.getLeft() != null) {
				temp = temp.getLeft();
		}
			return temp;
	   }
	
	// Find Max Value using Recursion 
	public BinaryTreeNode findMaxRec(BinaryTreeNode root) {
		if(null == root){
			return root;
		}
		else if(null == root.getRight()) {
			return root;
		}
		else {
			return findMaxRec(root.getRight());
		}
		
	}
	
	//Calculate Sum of all the elements in the Tree
	public int treeSum() {
		return treeSum(root);
	}
	
	private int treeSum(BinaryTreeNode root) {
		if(null == root) {
			return 0;
		}
		else {
			return(root.getData() + treeSum(root.getLeft()) + treeSum(root.getRight()));
		}
	}
	
	//LevelOrder Traversal
	public void levelOrder() {
		levelOrder(root);
	}
	
	
	public void levelOrder(BinaryTreeNode root) {
		BinaryTreeNode temp = root;
		if(null == temp) {
			System.out.println("No Elements in the Tree");
			return;
		}
		
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
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
	
	//LevelOrder Traversal
	public void levelOrderCustom() {
			levelOrderCustom(root);
	}
	
	private void levelOrderCustom(BinaryTreeNode root) {
		BinaryTreeNode temp = root;
		if(null == temp) {
			System.out.println("No Elements in the Tree");
			return;
		}
		
		GenericQueue<BinaryTreeNode> queue = new GenericQueue<>();
		
		queue.enQueue(temp);
		while(!(queue.isEmpty())) {
			temp = queue.deQueue();
			System.out.print(" " +temp.getData());
			if(null != temp.getLeft()) {
				queue.enQueue(temp.getLeft());
			}
			if(null != temp.getRight()) {
				queue.enQueue(temp.getRight());
			}		
		}
	}
	
	public void preOrderIterativeImp() {
		preOrderIterativeImp(root);
		System.out.println();
	}
	
	private void preOrderIterativeImp(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(null == root)
			return ;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			if(root!=null){
				System.out.print(" "+root.getData());
				stack.push(root);
				root=root.getLeft();
			}
			else {
				
			root =(BinaryTreeNode)stack.pop();
			//stack.push(root);
			root = root.getRight();
			//stack.pop();
			}
		}	
	}
	
	//Height of the Tree
	public int heightBST() {
		return heightOfBinaryTree(root);
	}
	
	private int heightOfBinaryTree(BinaryTreeNode root) {
		
		int leftHeight, rightHeight;
		
		if(null == root) {
			return 0;
		}
		else {
			
			leftHeight = heightOfBinaryTree(root.getLeft()) + 1;
			
			rightHeight = heightOfBinaryTree(root.getRight()) + 1;
			
			if(leftHeight > rightHeight) {
				return (leftHeight);
			}
			else {
				return (rightHeight);
			}
		}
	}
	
	
	/* Does not work
	 * //Kth Smallest Node the Tree
	public  BinaryTreeNode pubkthSmallestNode(int k) {
		int cnt=0;
		BinaryTreeNode kthNode=kthSmallestNode( root,  k, cnt);
		System.out.println("kth Node"+kthNode);
		return kthNode;
		//resetCount();
	}
	
	private BinaryTreeNode kthSmallestNode(BinaryTreeNode root, int k,int cnt) {
		
		if(null == root) 
			return null;
		System.out.println("kth Smallest Node"+root.getData());
		BinaryTreeNode left=kthSmallestNode(root.getLeft(),k,cnt);
			if(left!=null)
				return left;
			++cnt;
			System.out.println("Count Value = "+cnt);
			if(cnt == k) {
				System.out.println("Kth Smallest"+root.getData());
			return root;
			}
		return kthSmallestNode(root.getRight(), k,cnt);
	}
	*/
	private void resetCount() {
		count = 0;
	}
	
	public BinaryTreeNode pubkthSmallestNodeSecond(int k) {
		resetCount();
		return kthSmallestNodeSecond(root,k);
	}
	
	private BinaryTreeNode kthSmallestNodeSecond(BinaryTreeNode root, int k) {
		if(null == root) {
			return null;
		}

			BinaryTreeNode left = kthSmallestNodeSecond(root.getLeft(),k);
			if(left != null) return left;
			if(++count == k) {
			
			//System.out.println(+k +"th Node" + ":" +root.getData());
			return root;
		}
		 return kthSmallestNodeSecond(root.getRight(), k);
	}

	
	
	
	
	//Print different paths from the root
	private void printArray(int [] arr, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(" " +arr[i]);
		}
		System.out.println();
	}
	
	private  void printPath(BinaryTreeNode root, int[] path, int pathLen) {
		if(root == null) {
			return;
		}
		path[pathLen] = root.getData();
		pathLen++;
		if(root.getLeft() == null && root.getRight() == null) {
			printArray(path, pathLen);
		}
		else {
			printPath(root.getLeft(), path, pathLen);
			printPath(root.getRight(), path, pathLen);
		}	
		
	}
	
	public void  printPaths() {
		int[] path = new int[heightBST()];
		printPath(root, path, 0);
	}
	
	//Is this Binary Search Tree
	public boolean isBinarySearchTree() {
		return isBST(root);
	}
	
	
	private  boolean isBST(BinaryTreeNode root) {
		if(null == root) 
			return true;
		if(root.getLeft() != null && findMax(root.getLeft()).getData() > root.getData())
			return false;
		if(root.getRight() != null && findMin(root.getRight()).getData() < root.getData())
			return false;
		if(!isBST(root.getLeft()) || !isBST(root.getRight()))
			return false;
		
		return true;
	}
	
	
	/*//Does not work
	public boolean isBSTImproved() {
		return isBSTImproved(root, Integer.MIN_VALUE);
	}
	
	private boolean isBSTImproved(BinaryTreeNode root, int prev) {
		// TODO Auto-generated method stub
		if(null == root) return true;
		
		if(!isBSTImproved(root.getLeft(), prev)) return false;
		
		if(root.getData()<prev) return false;
		System.out.println("prev = "+prev +" root = "+root.getData());
		prev = root.getData();
		//System.out.println("prev"+prev +"root"+root.getData());
		return (isBSTImproved(root.getRight(), prev));
	}
*/	
	public boolean isBSTImprovedSec() {
		prev=0;
		return isBSTImprovedSec(root);
	}
	
	

	private boolean isBSTImprovedSec(BinaryTreeNode root) {
		if(null == root) return true;
		
		if(!isBSTImprovedSec(root.getLeft())) return false;
		
		if(root.getData()<prev) return false;
		System.out.println("prev = "+prev +" root = "+root.getData());
		prev = root.getData();
		//System.out.println("prev"+prev +"root"+root.getData());
		return (isBSTImprovedSec(root.getRight()));
	}

	//Find the diameter of the Tree
	public int diameterTree() {
		diameterTree(root);
		return diameter+1;
	}
	
	public int diameterTree(BinaryTreeNode root) {
		int left, right;
		if(null == root) {
			return 0;
		}
		else {
			left = diameterTree(root.getLeft());
			right = diameterTree(root.getRight());
			if(left+right > diameter)
				diameter = left+ right;
			return Math.max(left, right)+1;
		}
		
	}
	
	//Is this Balanced Tree
	public boolean isBalanced() {
		if(-1==isBalanced(root))
			return false;
		else
			return true;
		
	}

	private int isBalanced(BinaryTreeNode root) {
		int left,right;
		if(root==null)
			return 0;
		left = isBalanced(root.getLeft());
		if(left==-1)
			return left;
		right = isBalanced(root.getRight());
		if(right==-1)
			return right;
		if((Math.abs(left-right))>1)
				return -1;
		return Math.max(left, right)+1;
		
	}
	
	//Print Ancestor Nodes(General)
	public boolean printAllAncestors(int data) {
			System.out.println("Ancestor Nodes:");
			boolean hasAncestor = printAllAncestors(root,data);
			System.out.println();
		return hasAncestor;
	}

	private boolean printAllAncestors(BinaryTreeNode root, int data) {
		if(null == root)
			return false;
		if((root.getData() == data) || (root.getData() == data) ||
			(printAllAncestors(root.getLeft(), data)) || (printAllAncestors(root.getRight(), data))) {
			System.out.print(" " +root.getData());
			return true;
		}		
		return false;
	}
	
	//LCA(General)
	public BinaryTreeNode findLCA(int num1, int  num2) {
		return findLCA(root,num1, num2 );
	}

	private BinaryTreeNode findLCA(BinaryTreeNode root, int num1, int num2) {
		// TODO Auto-generated method stub
		BinaryTreeNode left, right;
		if(null==root) 
			return root;
		if(root.getData()==num1 || root.getData()==num2)
			return root;
		left=findLCA(root.getLeft(), num1, num2);
		right=findLCA(root.getRight(), num1, num2);
		if(left!=null && right!=null)
			return root;
		if(left!=null)
			return left;
		else
			return right;
	}
	
	public BinaryTreeNode searchNode(int data) {
		
		return searchNode(root, data);
	}

	private BinaryTreeNode searchNode(BinaryTreeNode root, int data) {
		// TODO Auto-generated method stub
		BinaryTreeNode left,right;
		if(root==null)
			return null;
		if(root.getData()==data)
			return root;
		left=searchNode(root.getLeft(), data);
		right=searchNode(root.getRight(), data);
		if(left!=null)
			return left;
		else 
			return right;
	}
		
	public boolean isTreeEmpty() {
		return (root==null);
	}
	
	public void deleteIterative(int key) {
		Stack<BinaryTreeNode> binNodeStack = new Stack<BinaryTreeNode>();
        if (root == null)
        		return ;
            BinaryTreeNode deleteNode = root;
            while (deleteNode != null){
                if (key < deleteNode.getData()){
                	binNodeStack.push(deleteNode);
                    deleteNode = deleteNode.getLeft();
                }else if (key > deleteNode.getData()){
                	binNodeStack.push(deleteNode);
                    deleteNode = deleteNode.getRight();
                }else{

                    if (deleteNode.getLeft() == null && deleteNode.getRight() == null){
                    	BinaryTreeNode temp = (BinaryTreeNode)binNodeStack.pop();
                    	if(temp.getLeft() == deleteNode)
                    		temp.setLeft(null);
                    	else
                    		temp.setRight(null);
                        deleteNode = null;
                    }else if (deleteNode.getLeft()== null){
                    	BinaryTreeNode temp = (BinaryTreeNode)binNodeStack.pop();
                    	if(temp.getLeft() == deleteNode)
                    		temp.setLeft(deleteNode.getRight());
                    	else
                    		temp.setRight(deleteNode.getRight());
                        deleteNode = null;
                    }else if (deleteNode.getRight() == null){
                    	BinaryTreeNode temp = (BinaryTreeNode)binNodeStack.pop();
                    	if(temp.getLeft() == deleteNode)
                    		temp.setLeft(deleteNode.getLeft());
                    	else
                    		temp.setRight(deleteNode.getLeft());
                        deleteNode = null;
                    }else{
                        BinaryTreeNode maxNode = findMax(deleteNode.getLeft());
                        deleteNode.setData(maxNode.getData());
                        key = maxNode.getData();
                        binNodeStack.push(deleteNode);
                        deleteNode = deleteNode.getLeft(); 
                    }
                }
            }
            binNodeStack=null;
	}
	
	
	public void deleteIterativeImproved(int key) {
		BinaryTreeNode binNodeParent = null;
        if (root == null)
        		return ;
            BinaryTreeNode deleteNode = root;
            while (deleteNode != null){
                if (key < deleteNode.getData()){
                	binNodeParent = deleteNode;
                    deleteNode = deleteNode.getLeft();
                }else if (key > deleteNode.getData()){
                	binNodeParent = deleteNode;
                    deleteNode = deleteNode.getRight();
                }else{

                    if (deleteNode.getLeft() == null && deleteNode.getRight() == null){
                    	BinaryTreeNode temp = binNodeParent;
                    	if(temp.getLeft() == deleteNode)
                    		temp.setLeft(null);
                    	else
                    		temp.setRight(null);
                        deleteNode = null;
                    }else if (deleteNode.getLeft()== null){
                    	BinaryTreeNode temp = binNodeParent;
                    	if(temp.getLeft() == deleteNode)
                    		temp.setLeft(deleteNode.getRight());
                    	else
                    		temp.setRight(deleteNode.getRight());
                        deleteNode = null;
                    }else if (deleteNode.getRight() == null){
                    	BinaryTreeNode temp = binNodeParent;
                    	if(temp.getLeft() == deleteNode)
                    		temp.setLeft(deleteNode.getLeft());
                    	else
                    		temp.setRight(deleteNode.getLeft());
                        deleteNode = null;
                    }else{
                        BinaryTreeNode maxNode = findMax(deleteNode.getLeft());
                        deleteNode.setData(maxNode.getData());
                        key = maxNode.getData();
                        binNodeParent = deleteNode;
                        deleteNode = deleteNode.getLeft(); 
                    }
                }
            }
	}
	
	/*public BinaryTreeNode preOrderSuccessor(BinaryTreeNode root) {
		if(root!= null)
			n=root;
		if(n.getLeft() != null){
			s.push(n);
			n = n.getLeft(); 
		}
		else {
			while(n.getRight()==null) {
				n=s.pop();
			}
			n=n.getRight();
		}
		return n;
	}*/
	
	public CessorResult preSuccessor(int key) {
		CessorResult res=preSuccessor(root,key);
		if(res.getResult()!=null)
			return res;
		else
		return new CessorResult(null, false);
	}
	
	
	
	private  CessorResult preSuccessor(BinaryTreeNode root, int key) {
			if(root == null)
				return new CessorResult(null, false);
			if(key==root.getData() && root.getLeft()!=null) {
				CessorResult res = new CessorResult(root.getLeft(), true);
				return res;
			}
			
			if(key==root.getData() && root.getRight()!=null){
				CessorResult res = new CessorResult(root.getRight(), true);
				return res;
			}
			if(key==root.getData()) {
				CessorResult res = new CessorResult(null, true);
				return res;
			}
			else if(key<root.getData()) {
				CessorResult res = preSuccessor(root.getLeft(), key);
						if(res.isFound() && res.getResult()==null && root.getRight()!=null) {
							res.setResult(root.getRight());
						}
					return res;
			}
			else {
				CessorResult res = preSuccessor(root.getRight(), key);
				return res;
			}
	}
	
	public CessorResult prePredecessor(int key) {
		return prePredecessor(root,key);
	}
	
	
	private  CessorResult prePredecessor(BinaryTreeNode root, int key) {
		if(root==null)
			return new CessorResult(null, false);
		if(key==root.getData())
			return new CessorResult(null, true);
		else if(key<root.getData()){
			CessorResult res=prePredecessor(root.getLeft(), key);
			if(res.isFound() && res.getResult()==null){
				res.setResult(root);
			}
			
			return res;
		}
		else {
			CessorResult res=prePredecessor(root.getRight(), key);
			if(res.isFound() && res.getResult()==null && root.getLeft()!=null) {
				res.setResult(findMax(root.getLeft()));
			}
			if(root.getLeft()==null)
				res.setResult(root);
				
			return res;
		}

	}
	
	public void printRange(int k1,int k2) {
		printRange(root,k1,k2);
		System.out.println();
	}

	private void printRange(BinaryTreeNode root, int k1, int k2) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		if(k1<=root.getData()) 
			printRange(root.getLeft(),k1,k2);
		
		if(k1<=root.getData() && k2>=root.getData())
			System.out.print(" "+root.getData());
		
		if(k2>=root.getData())
			printRange(root.getRight(),k1,k2);	
	}
	
	public void pruneTree(int k1,int k2) {
		root=pruneTree(root,k1,k2);
	}

	private BinaryTreeNode pruneTree(BinaryTreeNode root, int k1, int k2) {
		// TODO Auto-generated method stub
		if(root==null)
			return null;
		else{
			root.setLeft(pruneTree(root.getLeft(), k1, k2));
			root.setRight(pruneTree(root.getRight(), k1, k2));
			
			if(k1<=root.getData() && k2>=root.getData())
				return root;
			if(root.getData()<k1)
				return root.getRight();
			if(root.getData()>k2)
				return root.getLeft();
			
		}
		return root;
	}	
}
