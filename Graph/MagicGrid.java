import java.util.Scanner;

public class MagicGrid {
    private static Scanner in = new Scanner(System.in);

    public static int solve(int[][] S){
        int R = S.length;
        int C = S[0].length;
        int dp[][] = new int[R][C];
        dp[R-1][C-1] = 1;
        for(int i=R-2;i>=0;i--)
            dp[i][C-1] = Math.max(1, dp[i+1][C-1] - S[i][C-1]);
        for(int i=C-2;i>=0;i--)
            dp[R-1][i] = Math.max(1, dp[R-1][i+1] - S[R-1][i]);
        for(int i=R-2;i>=0;i--){
            for(int j=C-2;j>=0;j--){
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j]-S[i][j], dp[i][j+1]-S[i][j]));
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {
        int T = in.nextInt();
        while(T-->0){
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] S = new int[R][C];
            for(int i=0;i<R;i++)
                for(int j=0;j<C;j++)
                    S[i][j] = in.nextInt();
            System.out.println(solve(S));
        }

    }
}
