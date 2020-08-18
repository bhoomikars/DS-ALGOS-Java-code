class StackEmptyException extends Exception{

}

public class StackUsingArray {

    private int data[];
    private int top;

    public StackUsingArray(){
        data = new int[10];
        top = -1;
    }

    public StackUsingArray(int capacity){
        data = new int[capacity];
        top = -1;
    }

    public void push(int item){
        if(top == data.length-1){
            restructure();
        }
        data[++top] = item;
    }

    private void restructure(){
        int[] temp = data;
        data = new int[2*data.length];
        for(int i=0;i<temp.length;i++){
            data[i] = temp[i];
        }
    }

    public int pop() throws StackEmptyException{
        if(top == -1){
            System.out.println("Stack Empty");
            return -1;
        }
        int item = data[top];
        top--;
        return item;
    }

    public boolean isEmptyy(){
        if(top==-1)
            return true;
        return false;
    }

    public int top() throws StackEmptyException{
        if(top==-1){
            System.out.println("Stack Empty");
            return -1;
        }
        return data[top];
    }

    public int size(){
        return top+1;
    }

    public static void main(String[] args) {

        StackUsingArray stack = new StackUsingArray();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        try{
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.top());
        }catch (StackEmptyException ex) {

        }

    }
}
