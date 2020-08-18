import java.util.Scanner;

public class MinCostPath {

    public static int minCostPath(int input[][], int i, int j){ // Recursive
        if(i>=input.length || j>=input[0].length)
            return Integer.MAX_VALUE;
        if(i==input.length-1 && j==input[0].length-1)
            return input[i][j];
        int op1 = minCostPath(input, i, j+1);
        int op2 = minCostPath(input, i+1, j+1);
        int op3 = minCostPath(input, i+1, j);
        return input[i][j] + Math.min(op1, Math.min(op2, op3));
    }

    public static int minCostPathM(int input[][], int i, int j, int[][] storage){
        int n = input.length;
        int m = input[0].length;
        if(i==n-1 && j==m-1){
            storage[i][j] = input[i][j];
            return storage[i][j];
        }
        if(i>=n || j>=m)
            return Integer.MAX_VALUE;
        if(storage[i][j] != -1)
            return storage[i][j];
        int op1 = minCostPathM(input, i, j+1, storage);
        int op2 = minCostPathM(input, i+1, j+1, storage);
        int op3 = minCostPathM(input, i+1, j, storage);
        storage[i][j] = input[i][j] + Math.min(op1, Math.min(op2, op3));
        return storage[i][j];
    }

    public static int minCostPathDP(int input[][]){
        int n = input.length;
        int m = input[0].length;
        int[][] storage = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                storage[i][j] = -1;
        storage[0][0] = input[0][0];
        for(int i=1;i<n;i++)
            storage[i][0] = storage[i-1][0] + input[i][0];
        for(int j=1;j<m;j++)
            storage[0][j] = storage[0][j-1] + input[0][j];
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
                storage[i][j] = Math.min(storage[i-1][j], Math.min(storage[i-1][j-1], storage[i][j-1])) + input[i][j];

        return storage[n-1][m-1];
    }

    public static int minCostPath(int input[][]) {
//        int n = input.length;
//        int m = input[0].length;
//        int[][] storage = new int[n][m];
//        for(int i=0;i<n;i++)
//            for(int j=0;j<m;j++)
//                storage[i][j] = -1;
//        return minCostPathM(input, 0, 0, storage);
        return minCostPathDP(input);
    }

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int m = s.nextInt();
        int n = s.nextInt();
        int input[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                input[i][j] = s.nextInt();
            }
        }
        System.out.println(minCostPath(input));
    }
}
