import java.util.Scanner;

public class ShortestSubsequence {
    public static int solve(String S,String V){
        int m = S.length();
        int n = V.length();
        if(m==0)
            return 1005;
        if(n<=0)
            return 1;
        int k;
        for(k=0;k<n;k++)
            if(V.charAt(k) == S.charAt(0))
                break;
        if(k == n)
            return 1;
        return Math.min(solve(S.substring(1), V), 1+solve(S.substring(1),V.substring(k+1)));

    }

    public int solveDP(String S,String V){
        int m = S.length();
        int n = V.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0] = 1;
        for(int i=0;i<=n;i++)
            dp[0][i] = 1005;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                char ch = S.charAt(i-1);
                int k;
                for(k=j-1;k>=0;k--)
                    if(V.charAt(k) == ch)
                        break;
                if(k == -1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i-1][k]);
            }
        }
        int ans = dp[m][n];
        if(ans >= 1005)
            ans = -1;
        return ans;
    }

    public static void main(String[] args) {

        String S,V;

        Scanner scan = new Scanner(System.in);

        S = scan.next();
        V = scan.next();
        System.out.println(solve(S,V));

    }
}
