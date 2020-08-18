package com.uttara.binarysearchtree;

public class BinarySearchUtility {
	
	private  static int preIndex;
	
	public static BinaryTreeNode constructDLL(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		BinaryTreeNode leftHead, rightHead;
		if(root!=null) {
			leftHead = constructDLL(root.getLeft());
			rightHead = constructDLL(root.getRight());
			
			BinaryTreeNode temp=null;
			
			if(leftHead != null) {
                temp = leftHead;
                while(temp.getRight() != null){
                    temp = temp.getRight();
                }
                temp.setRight(root);
            }
			else{
                leftHead = root;
            }
            root.setLeft(temp);
            
            if(rightHead != null){
                root.setRight(rightHead);
                rightHead.setLeft(root);
            }else{	
                rightHead = root;
            }
            return leftHead;
		}
		
		return null;
	}
	
	public static void traverse(BinaryTreeNode head) {
		BinaryTreeNode temp = head;
		while(null != temp) {
			System.out.print(" " +temp.getData());
			temp = temp.getRight();
		}
		System.out.println();
	}
	
	/*public static BinaryTreeNode constructDLL(BinaryTreeNode root, BinaryTreeNode tail) {
	BinaryTreeNode left,right,ltail=null,rtail=null;
	if(null==root) {
		ltail=null;
		return null;
	}
	
	left = constructDLL(root.getLeft(), ltail);
	right = constructDLL(root.getRight(), rtail);
	root.setLeft(ltail);
	root.setRight(right);
	
	if(right == null) {
		ltail=root;
	}
	else {
		right.setLeft(root);
		ltail=rtail;
	}
	
	if(null==left) {
		return root;
	}
	else {
		ltail.setRight(root);
		return left;
	}
  }*/
	
	private static boolean matchTree(BinaryTreeNode n1, BinaryTreeNode n2) {
		if (n2 == null && n1 == null) 
			return true; 
		if(n2 == null && n1 != null)
			return true;
		if (n1 == null || n2 == null) 
			return false; 
		if (n1.getData() != n2.getData()) 
			return false;  
		return (matchTree(n1.getLeft(), n2.getLeft()) && 
				matchTree(n1.getRight(), n2.getRight()));
	}

	public static boolean subTree(BinaryTreeNode t1, BinaryTreeNode t2) {
		if (t1 == null)
			return false; 
		if (t1.getData() == t2.getData()) {
			if (matchTree(t1,t2)) return true;
		}
		return (subTree(t1.getLeft(), t2) || subTree(t1.getRight(), t2)); 
	}
	
	public static BinaryTreeNode buildBinaryTree(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
				
				if(inStart>inEnd) {
					return null;
				}
				BinaryTreeNode newNode = new BinaryTreeNode();
				newNode.setData(preOrder[preIndex]);
				preIndex++;
				if(inStart==inEnd)
					return newNode;
				
				
				int inIndex = binarySearch(inOrder, newNode.getData(), inStart, inEnd);
				//int inIndex = binarySearchIterative(inOrder, newNode.getData(), inStart, inEnd);
				newNode.setLeft(buildBinaryTree(preOrder, inOrder, inStart, inIndex-1));
				newNode.setRight(buildBinaryTree(preOrder, inOrder, inIndex+1, inEnd));
				
		return newNode;
	}
	
	public static void resetIndexValue() {
		preIndex=0;
	}
	
	public static int getPreIndex() {
		return preIndex;
	}
	
	public static int binarySearch(int[] arr, int value, int low, int high) {
		
		if(low>high)
			return -1;
		
		int mid =low + (high-low)/2;
		
		if(arr[mid] == value) {
			return mid;
		}
		else if(arr[mid] < value) {
			return binarySearch(arr, value, mid+1, high);
		}
		else {
			return binarySearch(arr, value,low , mid-1);
		}
		
	}
	
	
	public static int binarySearchIterative(int[] arr, int value, int low, int high) {
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(arr[mid] == value) return mid;
			else if(arr[mid] < value) low = mid + 1;
			else high = mid - 1;
		}
		return -1;
	}
	
    public static void preOrder(BinaryTreeNode root) {
		if(null != root) {
			System.out.print(" " +root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}	
	}
	
	public static  void inOrder(BinaryTreeNode root) {
		if(null != root) {
			inOrder(root.getLeft());
			System.out.print(" " +root.getData());
			inOrder(root.getRight());	
		}
		
	}



}
