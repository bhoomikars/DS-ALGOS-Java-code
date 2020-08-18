import java.util.ArrayList;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
        public static ArrayList<Integer> longestSubsequence(int[] arr){
            ArrayList<Integer> result = new ArrayList<Integer>();
            HashSet<Integer> h = new HashSet<Integer>();
            int start = Integer.MAX_VALUE;
            int length = 0;
            for(int i=0;i<arr.length;i++){
                h.add(arr[i]);
            }
            for(int i=0;i<arr.length;i++){
                if(!h.contains(arr[i]-1)){
                    int j = arr[i];
                    while(h.contains(j))
                        j++;
                    if(length<j-arr[i]){
                        length = j-arr[i];
                        start = arr[i];
                    }
                }
            }
            for(int i=0;i<length;i++)
                result.add(start+i);
            return result;

        }
    }
