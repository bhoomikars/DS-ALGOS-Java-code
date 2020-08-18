import java.util.*;

public class CombinatorialSum {

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int start_index, int sum) {
        if(sum<0){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
            return ans;
        }
        if(arr.length == start_index){
            if(sum == 0){
                ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
                ans.add(new ArrayList<Integer>());
                return ans;
            }
            else{
                ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
                return ans;
            }
        }

        ArrayList<ArrayList<Integer>> smallAns1 = combinationSum(arr, start_index,sum-arr[start_index]);
        ArrayList<ArrayList<Integer>> smallAns2 = combinationSum(arr, start_index+1,sum);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<smallAns1.size();i++){
            ans.add(new ArrayList<Integer>());
            ans.get(i).add(arr[start_index]);
            for(int j=0;j<smallAns1.get(i).size();j++)
                ans.get(i).add(smallAns1.get(i).get(j));
        }

        for(int i=0;i<smallAns2.size();i++){
            ans.add(new ArrayList<Integer>());
            for(int j=0;j<smallAns2.get(i).size();j++)
                ans.get(i+smallAns1.size()).add(smallAns2.get(i).get(j));
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        arr = new int[set.size()];
        Iterator it = set.iterator();
        for(int i=0;i<set.size();i++)
            arr[i] = (Integer) it.next();
        Arrays.sort(arr);
        return combinationSum(arr, 0, sum);
    }



    public static void main(String[] args){
        int[] arr = {7, 2, 6, 5};
        int sum = 16;
        ArrayList<ArrayList<Integer>> result = combinationSum(arr, sum);
        for(int i=0;i<result.size();i++){
            for(int j=0;j<result.get(i).size();j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
