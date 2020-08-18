public class ReturnSubsetOfAnArray {
    public static int[][] subsets(int input[]) {

        if(input.length == 0){
            int[][] ans = {{}};
            return ans;
        }
        int item = input[0];
        int[] arr = new int[input.length-1];
        for(int i=0;i<input.length-1;i++)
            arr[i] = input[i+1];
        int[][] smallAns = subsets(arr);
        int[][] ans = new int[2*smallAns.length][];
        for(int i=0;i<smallAns.length;i++){
            ans[i] = new int[smallAns[i].length];
            ans[i+smallAns.length] = new int[smallAns[i].length+1];
            ans[i+smallAns.length][0] = item;
            for(int j=0;j<smallAns[i].length;j++){
                ans[i][j] = smallAns[i][j];
                ans[i+smallAns.length][j+1] = smallAns[i][j];
            }
        }
        return ans;

    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        int[][] result = subsets(arr);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
