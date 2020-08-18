import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

    public static Scanner s = new Scanner(System.in);
	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + "";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ",";
		}
		
		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
        System.out.println("Enter root data");
        int n = s.nextInt();
        if(n==-1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(n);
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.poll();
            System.out.println("Enter left child data of " + node.data);
            int l = s.nextInt();
            BinaryTreeNode<Integer> lchild = new BinaryTreeNode<Integer>(l);
            if (l == -1)
                lchild = null;
            System.out.println("Enter right child data of " + node.data);
            int r = s.nextInt();
            BinaryTreeNode<Integer> rchild = new BinaryTreeNode<Integer>(r);
            if (r == -1)
                rchild = null;
            node.left = lchild;
            node.right = rchild;
            if (l != -1)
                queue.add(lchild);
            if (r != -1)
                queue.add(rchild);
        }
        return root;
    }
	

	public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root, int q) {
		if (root == null) {
			return null;
		}
		if (root.data == q) {
			return root;
		} else if (root.data > q) {
			return searchInBST(root.left, q);
		} else {
			return searchInBST(root.right, q);
		}
	}
	
	public static void printBetweenK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
		if (root == null) {
			return;
		}
		if (root.data >= k1 && root.data <= k2) {
			System.out.println(root.data);
		}
		
		if (root.data > k1) {
			printBetweenK1K2(root.left, k1, k2);
		}
		
		if (root.data <= k2) {
			printBetweenK1K2(root.right, k1, k2);
		}
		
	}
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}
	
	public static int maximum(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);
		if (root.data <= leftMax) {
			return false;
		}
		
		if (root.data > rightMin) {
			return false;
		}
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		if (isLeftBST && isRightBST) {
			return true;
		} else {
			return false;
		}
	}

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int start, int end){
        if(start<=end){
            int mid = (start+end)/2;
            BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(arr[mid]);
            node.left = SortedArrayToBST(arr, start, mid-1);
            node.right = SortedArrayToBST(arr, mid+1, end);
            return node;
        }
        else
            return null;
    }

    public static ArrayList<Integer> getPathFromRoot(BinaryTreeNode<Integer> root, int item){ // Binary Tree
	    if(root == null){
            return null;
        }
        if(root.data == item){
            ArrayList<Integer> output = new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> leftOutput = getPathFromRoot(root.left, item);
        if(leftOutput != null){
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer> rightOutput = getPathFromRoot(root.right, item);
        if(rightOutput != null){
            rightOutput.add(root.data);
            return rightOutput;
        }
        else
            return null;
    }

    public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data){ // BST
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(root == null)
            return null;
        if(root.data == data){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> output;
        if(root.data>data)
            output = findPath(root.left, data);
        else
            output = findPath(root.right, data);
        if(output != null){
            output.add(root.data);
            return output;
        }
        else
            return null;
    }
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
        ArrayList<Integer> output = getPathFromRoot(root, 6);
        for(int i=0;i<output.size();i++)
            System.out.println(output.get(i));
//      printTree(root);
	}
}
