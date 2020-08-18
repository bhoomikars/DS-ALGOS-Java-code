import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Integer> heap;
    public PriorityQueue(){
        heap = new ArrayList<>();
    }
    public int size(){
        return heap.size();
    }
    public boolean isEmpty(){
        return (heap.size()==0);
    }
    public int getMin() throws PriorityQueueEmptyException{
        if(isEmpty()){
            throw new PriorityQueueEmptyException();
        }
        return heap.get(0);
    }
    public void insert(int element){
        heap.add(element);
        int childIndex = size()-1;
        int parentIndex = (childIndex-1)/2;
        while(childIndex>0 && heap.get(childIndex)<heap.get(parentIndex)){
            int temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
    }
    public int removeMin() throws PriorityQueueEmptyException {
        if(isEmpty())
            throw new PriorityQueueEmptyException();
        int element = heap.get(0);
        heap.set(0, heap.get(size()-1));
        heap.remove(size()-1);
        int i = 0;
        while(true){
            int left = 2*i+1;
            int right = 2*i+2;
            int change = i;
            if(left<size() && heap.get(change)>heap.get(left)){
                change = left;
            }
            if(right<size() && heap.get(change)>heap.get(right)){
                change = right;
            }
            if(change == i)
                break;
            else{
                int temp = heap.get(i);
                heap.set(i, heap.get(change));
                heap.set(change, temp);
                i=change;
            }
        }
        return element;
    }
}
