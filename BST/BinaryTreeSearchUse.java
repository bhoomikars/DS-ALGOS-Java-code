import java.util.Scanner;

public class BinaryTreeSearchUse {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertData(20);
        bst.insertData(40);
        bst.insertData(10);
        bst.insertData(30);
        bst.insertData(70);
        bst.insertData(15);
        bst.insertData(65);
        bst.insertData(35);
        bst.insertData(25);
        System.out.println(bst.search(40));
        bst.deleteData(40);
        System.out.println(bst.search(40));
        bst.printTree();

    }
}
