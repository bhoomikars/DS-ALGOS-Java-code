public class PrintSubsetsOfAnArray {
    public static void printSubsets(int input[], int result[][]) {
        if(input.length == 0){
            for(int i=0;i<result.length;i++){
                for(int j=0;j<result[i].length;j++){
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        int item = input[0];
        int [][] ans = new int[2*result.length][];
        for(int i=0;i<result.length;i++){
            ans[i] = new int[result[i].length];
            ans[i+result.length] = new int[result[i].length+1];
            for(int j=0;j<result[i].length;j++){
                ans[i][j] = result[i][j];
                ans[i+result.length][j] = result[i][j];
            }
            ans[i+result.length][result[i].length] = item;
        }
        int[] arr = new int[input.length-1];
        for(int i=0;i<input.length-1;i++)
            arr[i] = input[i+1];
        printSubsets(arr, ans);
    }

    public static void printSubsets(int input[]){
        int result[][] = {{}};
        printSubsets(input, result);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        printSubsets(arr);
    }
}
