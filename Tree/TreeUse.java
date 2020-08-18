import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

    private static Scanner scanner = new Scanner(System.in);
    public static TreeNode<Integer> takeInput(){
        System.out.println("Enter next node data");
        int n = scanner.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);
        System.out.println("Enter number of children for : " + n);
        int childCount = scanner.nextInt();
        for(int i=0;i<childCount;i++){
            TreeNode<Integer> child = takeInput();
            root.children.add(child);
        }
        return root;
    }

    public static void print(TreeNode<Integer> root){
        String s = root.data + " : ";
        for(int i=0;i<root.children.size();i++)
            s = s + root.children.get(i).data + ", ";
        System.out.println(s);
        for(int i=0;i<root.children.size();i++)
            print(root.children.get(i));
    }

    public static TreeNode<Integer> takeInputLevelWise(){
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        System.out.println("Enter root data");
        int rootData = scanner.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.poll();
            System.out.println("Enter number of children of : " + frontNode.data);
            int childCount = scanner.nextInt();
            for(int i=0;i<childCount;i++) {
                System.out.println("Enter " + i + "th child of " + frontNode.data);
                int childData = scanner.nextInt();
                TreeNode<Integer> childNode = new TreeNode<Integer>(childData);
                queue.add(childNode);
                frontNode.children.add(childNode);
            }
        }
        return root;
    }

    public static void printLevelWise(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            String s = node.data + " : ";
            for(int i=0;i<node.children.size();i++){
                s = s + node.children.get(i).data + ", ";
                queue.add(node.children.get(i));
            }
            System.out.println(s.substring(0, s.length()-1));
        }
    }

    public static int numNodes(TreeNode<Integer> root){
        if(root==null)
            return 0;
        if(root.children.size()==0)
            return 1;
        int smallAns = 0;
        for(int i=0;i<root.children.size();i++){
            smallAns += numNodes(root.children.get(i));
        }
        return 1+ smallAns;
    }

    public static int largest(TreeNode<Integer> root){
        if(root == null)
            return Integer.MIN_VALUE;
        int ans = root.data;
        for(int i=0;i<root.children.size();i++){
            int childLargest = largest(root.children.get(i));
            if(childLargest>ans)
                ans = childLargest;
        }
        return ans;
    }

    public static void depth(TreeNode<Integer> root, int d){
        if(d==0){
            System.out.println(root.data);
            return;
        }
        for(int i=0;i<root.children.size();i++)
            depth(root.children.get(i),d-1);
    }

    public static void preorder(TreeNode<Integer> root){
        System.out.print(root.data + " ");
        for(int i=0;i<root.children.size();i++)
            preorder(root.children.get(i));
    }


    public static void postorder(TreeNode<Integer> root){
        for(int i=0;i<root.children.size();i++)
            postorder(root.children.get(i));
        System.out.print(root.data + " ");

    }


    public static void main(String[] args){
        TreeNode<Integer> root = takeInputLevelWise();
//        printLevelWise(root);
//        System.out.println();
//        TreeNode<Integer> root=null;
//        System.out.println(numNodes(root));
//        System.out.println(largest(root));
//        depth(root,1);
        preorder(root);
        System.out.println();
        System.out.println();
        postorder(root);
//        TreeNode<Integer> root = new TreeNode<Integer>(4);
//        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
//        TreeNode<Integer> node2 = new TreeNode<Integer>(3);
//        TreeNode<Integer> node3 = new TreeNode<Integer>(5);
//        TreeNode<Integer> node4 = new TreeNode<Integer>(6);
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);
//        System.out.println(root);


    }
}
