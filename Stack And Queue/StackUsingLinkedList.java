import java.util.Scanner;

class Node<T>{
    T data;
    Node<T> next;
    public Node(T data){
        this.data = data;
    }
}

class Stack<T> {
    private Node<T> head;
    private int size;
    public Stack() {
        size = 0;
        head = null;
    }

    public int size() {
        return size;
    }

    public void push(T data) {
        Node<T> temp = new Node<T>(data);
        if(head == null){
            head = temp;
        }
        else{
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public boolean isEmpty() {
        if(size==0)
            return true;
        return false;
    }

    public T pop() throws StackEmptyException {
        if(size==0)
            return null;
        T item = head.data;
        head = head.next;
        size--;
        return item;
    }

    public T top() throws StackEmptyException {
        if(size==0)
            return null;
        return head.data;
    }
}

public class StackUsingLinkedList {

    public static void main(String[] args) throws StackEmptyException{

        Scanner s = new Scanner(System.in);

        Stack<Integer> st = new Stack<Integer>();

        int choice = s.nextInt();
        int input;

        while (choice !=-1) {
            if(choice == 1) {
                input = s.nextInt();
                st.push(input);
            }
            else if(choice == 2) {
                try {
                    System.out.println(st.pop());
                } catch (StackEmptyException e) {
                    System.out.println(-1);
                }
            }
            else if(choice == 3) {
                try {
                    System.out.println(st.top());
                } catch (StackEmptyException e) {
                    System.out.println(-1);
                }
            }
            else if(choice == 4) {
                System.out.println(st.size());
            }
            else if(choice == 5) {
                System.out.println(st.isEmpty());
            }
            choice = s.nextInt();
        }

    }



}
