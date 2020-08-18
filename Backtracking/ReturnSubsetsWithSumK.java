public class ReturnSubsetsWithSumK {

    public static int[][] subsetsSumK(int input[], int start_index, int k){
        if(start_index == input.length){
            if(k==0){
                int[][] ans = {{}};
                return ans;
            }
            else {
                int[][] ans = {};
                return ans;
            }
        }
        int item = input[start_index];
        int[][] smallAns1 = subsetsSumK(input, start_index+1, k-input[start_index]);
        int[][] smallAns2 = subsetsSumK(input, start_index+1, k);
        int[][] ans = new int[smallAns1.length + smallAns2.length][];
        for(int i=0;i<smallAns1.length;i++){
            ans[i] = new int[smallAns1[i].length+1];
            ans[i][0] = item;
            for(int j=0;j<smallAns1[i].length;j++){
                ans[i][j+1] = smallAns1[i][j];
            }
        }
        for(int i=0;i<smallAns2.length;i++){
            ans[i+smallAns1.length] = new int[smallAns2[i].length];
            for(int j=0;j<smallAns2[i].length;j++){
                ans[i+smallAns1.length][j] = smallAns2[i][j];
            }
        }
        return ans;
    }

    public static int[][] subsetsSumK(int input[], int k) {
        return subsetsSumK(input, 0, k);
    }

    public static void main(String[] args){
        int[] arr = {2,1,3,2};
        int k = 4;
        int[][] result = subsetsSumK(arr,k);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
