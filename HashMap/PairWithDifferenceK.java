import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PairWithDifferenceK {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scanner.nextInt();
        int k = scanner.nextInt();
        findPairsDifferenceK(arr, k);

    }
    public static void findPairsDifferenceK(int[] input, int k){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<input.length;i++)
            if(map.containsKey(input[i])){
                int v = map.get(input[i]);
                map.put(input[i], v+1);
            }
            else
                map.put(input[i], 1);
        for(int i=0;i<input.length;i++){
            if(map.containsKey(input[i]+k)){
                for(int j=0;j<map.get(input[i]);j++)
                    for(int l=0;l<map.get(input[i]+k);l++)
                        System.out.println(input[i] + " " + (input[i]+k));
            }
            if(map.containsKey(input[i]-k)){
                for(int j=0;j<map.get(input[i]-k);j++)
                    for(int l=0;l<map.get(input[i]);l++)
                        System.out.println((input[i]-k) + " " + input[i]);
            }
            map.put(input[i],0);
        }
        }

    }
