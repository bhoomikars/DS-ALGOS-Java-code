import java.util.Scanner;

public class MCM{

    public static int mcm(int[] p, int i, int j){ // recursive
        if(i == j)
            return 0;
        int mn = Integer.MAX_VALUE;
        int count;
        for(int k=i;k<j;k++){
            count = mcm(p, i, k) + mcm(p, k+1, j) + p[i-1]*p[k]*p[j];
            if(count<mn)
                mn = count;
        }
        return mn;
    }

    public static int mcm(int[] p){
        int n = p.length;
        return mcm(p, 1, n-1);

    }
    public static int mcmDP(int[] p){
        int n = p.length;
        int dp[][] = new int[n][n];
        for(int l=2;l<n;l++){
            for(int i=1;i<n-l+1;i++){
                int j = i+l-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost = dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j];
                    if(cost<dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }
        return dp[1][n-1];
    }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int p[] = new int[n + 1];
        for(int i = 0; i <= n; i++){
            p[i] = s.nextInt();
        }
        System.out.println(mcmDP(p));
    }
}
