import java.util.HashMap;
import java.util.Scanner;

public class LongestSubset {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scanner.nextInt();
        int result = max(arr);
        System.out.println(result);
    }

    public static int max(int[] arr){
        int maxLen = -1;
        int sum = 0;
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++)
            arr[i] = (arr[i]==0)?-1:1;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum == 0)
                maxLen = i+1;
            if(map.containsKey(sum)){
                if(maxLen<i-map.get(sum)){
                    maxLen = i - map.get(sum);
                    System.out.println(maxLen);
                }

            }
            else{
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
