public class QueueUsingArray {
    private int[] data;
    private int front;
    private int rear;
    public QueueUsingArray(){
        data = new int[10];
        front = -1;
        rear = -1;
    }
    public QueueUsingArray(int size){
        data = new int[size];
        front = -1;
        rear = -1;
    }
    public void enqueue(int item){
        if(rear == data.length)
            restructure();
        if(front==-1){
            front++;
        }
        rear++;
        data[rear] = item;
    }
    private void restructure(){
        int[] temp = data;
        data = new int[2*data.length];
        for(int i=0;i<temp.length;i++){
            data[i] = temp[i];
        }
    }
    public int dequeue(){
        if(front == -1){
            System.out.println("Queue Empty");
            return -1;
        }
        int item = data[front];
        front++;
        if(front ==rear+1){
            front = -1;
            rear = -1;
        }
        return item;
    }

    public int size(){
        if(front == -1)
            return 0;
        else
            return rear-front+1;
    }

    public int getFront(){
        if(front == -1)
            return -1;
        return data[front];
    }


    public static void main(String[] args){
        QueueUsingArray queue = new QueueUsingArray();
        System.out.println(queue.size());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.enqueue(90);
        queue.enqueue(100);
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.getFront());
        System.out.println(queue.size());
    }
}
