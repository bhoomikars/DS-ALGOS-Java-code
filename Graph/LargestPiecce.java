import java.util.Scanner;

class Res{
    int val;
}

public class LargestPiecce {
    private int[] x = {-1,1,0,0};
    private int[] y = {0,0,-1,1};
    private int size;
    void findOnes(String[] cake, int i, int j, boolean[][] check, Res res){
        for(int k=0;k<4;k++) {
            int row = x[k] + i;
            int col = y[k] + j;
            if (row >= size || row < 0 || col >= size || col < 0)
                continue;
            if (cake[row].charAt(col) == '1') {
                if (!check[row][col]) {
                    check[row][col] = true;
                    res.val++;
                    findOnes(cake, row, col, check, res);
                }
            }
        }
    }

    public int solve(int n,String cake[]) {
        size = n;
        boolean[][] check = new boolean[size][size];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(cake[i].charAt(j)=='1'){
                    check[i][j] = true;
                    Res res = new Res();
                    res.val++;
                    findOnes(cake, i, j, check, res);
                    max = Math.max(max, res.val);
                    check = new boolean[size][size];
                }
            }
        }
        return max;
    }
    public static String[]cake=new String [55];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n,m;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<n;i++)
        {
            cake[i]=scan.nextLine();
        }
        System.out.println(new LargestPiecce().solve(n,cake));
    }

}
