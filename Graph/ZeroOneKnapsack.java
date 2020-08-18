import java.util.Scanner;

public class ZeroOneKnapsack {

    public static int knapsack(int[] weight,int value[], int maxWeight, int n){
        if(n==0 || maxWeight==0)
            return 0;
        if(weight[n-1]>maxWeight)
            return knapsack(weight, value, maxWeight, n-1);
        else{
            int op1 = value[n-1] + knapsack(weight, value, maxWeight-weight[n-1], n-1);
            int op2 = knapsack(weight, value, maxWeight, n-1);
            return Math.max(op1, op2);
        }
    }

    public static int knapsackDP(int[] weight, int value[], int maxWeight){
        int n = weight.length;
        int dp[][] = new int[n+1][maxWeight+1];
        for(int i=0;i<=n;i++){
            for(int w=0;w<=maxWeight;w++){
                if(i==0 || w==0)
                    dp[i][w] = 0;
                else if(weight[i-1]<=w)
                    dp[i][w] = Math.max(value[i-1] + dp[i-1][w-weight[i-1]], dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }
        return dp[n][maxWeight];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int weight[] = new int[n];
        for(int i = 0 ; i < n; i++){
            weight[i] = s.nextInt();
        }
        int value[] = new int[n];
        for(int i = 0 ; i < n; i++){
            value[i] = s.nextInt();
        }
        int maxWeight = s.nextInt();
        System.out.println(knapsackDP(weight, value, maxWeight));
        System.out.println(knapsack(weight, value, maxWeight, n));

    }

}
