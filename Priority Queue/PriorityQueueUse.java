import java.util.Comparator;
import java.util.PriorityQueue;

class MinPQComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if(o1.length()<o2.length())
            return -1;
        else if(o1.length()>o2.length())
            return 1;
        return 0;
    }
}

public class PriorityQueueUse {

    public static void sortKSortedd(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for(i=0;i<k;i++)
            pq.add(arr[i]);
        for(;i<arr.length;i++){
            arr[i-k] = pq.remove();
            pq.add(arr[i]);
        }
        while(i-k<arr.length){
            arr[i-k] = pq.remove();
            i++;
        }
    }

    public static void main(String[] args){
        MinPQComparator m = new MinPQComparator();
        PriorityQueue<String> pq = new PriorityQueue<>(m);
        int arr[] = {2, 4, 1, 9, 6, 8};
        String s[] = {"this", "at", "there", "a", "queues"};
//        sortKSortedd(arr,3);
//        for(int i=0;i<arr.length;i++)
//            System.out.print(arr[i] + " ");
        for(int i=0;i<s.length;i++)
            pq.add(s[i]);
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }


    }
}
