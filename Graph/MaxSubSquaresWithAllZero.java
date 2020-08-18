import java.util.Scanner;

public class MaxSubSquaresWithAllZero {


    public static int findMaxSquareWithAllZeros(int[][] input){
        int m = input.length;
        int n = input[0].length;
        int dp[][] = new int[m][n];
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    if(input[i][j]==0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 0;
                }
                else{
                    if(input[i][j]==0){
                        dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    }
                    else
                        dp[i][j] = 0;
                }
                if(mx<dp[i][j])
                    mx = dp[i][j];
            }
        }
    return mx;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                arr[i][j]=s.nextInt();
        System.out.println(findMaxSquareWithAllZeros(arr));
    }
}
