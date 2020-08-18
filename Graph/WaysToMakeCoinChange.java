import java.util.Scanner;

public class WaysToMakeCoinChange {

    public static int countWaysToMakeChange(int denominations[], int value, int n){
        if(value==0)
            return 1;
        if(value<=0)
            return 0;
        if(n<=0 && value>=1)
            return 0;
        return countWaysToMakeChange(denominations, value,n-1) + countWaysToMakeChange(denominations, value-denominations[n-1],n);
    }


    public static int countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
        return countWaysToMakeChange(denominations, value, n);
    }

    public static int countWaysToMakeChangeDP(int denominations[], int value){
        int n = denominations.length;
        int table[][] = new int[value+1][n];
        for(int i=0;i<n;i++){
            table[0][i] = 1;
            System.out.print(table[0][i] + " ");
        }
        System.out.println();
        for(int i=1;i<=value;i++){
            for(int j=0;j<n;j++){
                int x = (i-denominations[j]>=0)?table[i-denominations[j]][j]:0;
                int y = (j>=1)?table[i][j-1]:0;
                table[i][j] = x+y;
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        return table[value][n-1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        int numDenominations = s.nextInt();
        int denominations[] = new int[numDenominations];
        for(int i = 0; i < numDenominations; i++){
            denominations[i] = s.nextInt();
        }

        int value = s.nextInt();

        System.out.println(countWaysToMakeChangeDP(denominations, value));
        System.out.println(countWaysToMakeChange(denominations, value));

    }
}
