import java.util.HashMap;
import java.util.Scanner;

public class NearestRepetition {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scanner.nextInt();
        System.out.println(minDistance(arr));
    }
    public static int minDistance(int[] arr){
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                int v = map.get(arr[i]);
                if(min>i-v)
                    min = i-v;
                map.put(arr[i], v);
            }
            else
                map.put(arr[i],i);
        }
        return min;
    }
}
