import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

class Node<T> {
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
    }
}

class QueueUsingLL<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public T front() throws Exception{
        if(size == 0){
            Exception e = new Exception();
            throw e;
        }

        return head.data;
    }


    public void enqueue(T element){
        Node<T> newNode = new Node<T>(element);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public T dequeue() throws Exception{
        if(head == null){
            Exception e = new Exception();
            throw e;
        }
        if(head == tail){
            tail = null;
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class VertcalOrder {
    static Scanner s = new Scanner(System.in);

    public static BinaryTreeNode<Integer> takeInput(){
        QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
        int rootData = s.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (Exception e) {
                return null;
            }
            int leftChildData = s.nextInt();
            if(leftChildData != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }
            int rightChildData = s.nextInt();
            if(rightChildData != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }
        return root;
    }

    public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root){
        QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<BinaryTreeNode<Integer>>();
        QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<BinaryTreeNode<Integer>>();

        primary.enqueue(root);

        while(!primary.isEmpty()){
            BinaryTreeNode<Integer> current=null;
            try {
                current = primary.dequeue();
            } catch (Exception e) {
                System.out.println("Not possible");
            }
            System.out.print(current.data + " ");
            if(current.left != null){
                secondary.enqueue(current.left);
            }
            if(current.right != null){
                secondary.enqueue(current.right);
            }
            if(primary.isEmpty()){
                QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondary;
                secondary = primary;
                primary = temp;
                System.out.println();
            }
        }
    }

    public static HashMap<Integer, Vector<Integer>> map = new HashMap<Integer, Vector<Integer>>();
    public static void createMap(BinaryTreeNode<Integer> root, int verLevel){
        if(root.data == null)
            return;
        Vector<Integer> temp = map.get(verLevel);
        if(temp == null){
            temp = new Vector<Integer>();
            temp.add(root.data);
        }
        else{
            temp.add(root.data);
        }
        map.put(verLevel, temp);
        createMap(root.left, verLevel-1);
        createMap(root.right, verLevel+1);
    }

    public static void printBinaryTreeVerticalOrder(BinaryTreeNode<Integer> root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */
        createMap(root, 0);
        for(Entry<Integer, Vector<Integer>> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInput();
        printBinaryTreeVerticalOrder(root);
    }
}