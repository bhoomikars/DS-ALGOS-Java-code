import java.util.Stack;
public class StackInCollections {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        System.out.println(stack.size());
    }
}
