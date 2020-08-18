public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;

    public BinaryTreeNode<Integer> insertDataHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
            return node;
        }
        if(root.data>data)
            root.left = insertDataHelper(root.left, data);
        else if(root.data <data)
            root.right = insertDataHelper(root.right, data);
        return root;
    }

    public void insertData(int data){
        root = insertDataHelper(root, data);
    }

    public int minimum(BinaryTreeNode<Integer> root){
        if(root.left == null)
            return root.data;
        else
            return minimum(root.left);
    }

    private BinaryTreeNode<Integer> deleteDataHelper(BinaryTreeNode<Integer> root, int data){
        if(root==null)
            return null;
        if(root.data == data) {
            if(root.left==null && root.right==null)
                return null;
            else if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else{
                root.data = minimum(root.right);
                root.right = deleteDataHelper(root.right, root.data);
                return root;
            }
        }
        else if(root.data>data)
            root.left = deleteDataHelper(root.left, data);
        else
            root.right = deleteDataHelper(root.right, data);
        return root;

    }

    public void deleteData(int data){
        root = deleteDataHelper(root, data);
    }

    private boolean searchHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null)
            return false;
        if(root.data == data)
            return true;
        else if(data>root.data)
            return searchHelper(root.right, data);
        else
            return searchHelper(root.left, data);
    }

    public boolean search(int data){
         return searchHelper(root, data);
    }

    private void printTreeHelper(BinaryTreeNode<Integer> root){
        if(root == null)
            return;
        String s = root.data +":";
        if(root.left != null){
            s = s + "L:"+root.left.data+",";
        }
        if(root.right != null){
            s = s + "R:"+root.right.data;
        }
        System.out.println(s);
        printTreeHelper(root.left);
        printTreeHelper(root.right);

    }

    public void printTree(){
        printTreeHelper(root);

    }


}
