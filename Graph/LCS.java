import java.util.Scanner;

public class LCS {

    public static int lcs(String s, String t){  // Recursive
        if(s.length() == 0 || t.length() == 0)
            return 0;
        if(s.charAt(0) == t.charAt(0))
            return 1 + lcs(s.substring(1), t.substring(1));
        else{
            int op1 = lcs(s.substring(1), t);
            int op2 = lcs(s, t.substring(1));
            return Math.max(op1, op2);
        }
    }

    public static int lcsM(String s, String t, int[][] storage){
        int m = s.length();
        int n = t.length();
        if(m == 0 || n == 0) {
            storage[m][n] = 0;
            return storage[m][n];
        }
        if(storage[m][n] != -1)
            return storage[m][n];
        if(s.charAt(0) == t.charAt(0)){
            storage[m][n] = 1 + lcsM(s.substring(1), t.substring(1), storage);
        }
        else{
            int op1 = lcsM(s.substring(1), t, storage);
            int op2 = lcsM(s, t.substring(1), storage);
            storage[m][n] = Math.max(op1, op2);
        }
        return storage[m][n];
    }

    public static int lcsM(String s, String t){
        int m = s.length();
        int n = t.length();
        int storage[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                storage[i][j] = -1;
            }
        }
        return lcsM(s, t, storage);
    }

    public static int lcsDP(String s, String t){
        int m = s.length();
        int n = t.length();
        int storage[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            storage[i][0] = 0;
        for(int j=0;j<=n;j++)
            storage[0][j] = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    storage[i][j] = 1 + storage[i-1][j-1];
                else
                    storage[i][j] = Math.max(storage[i-1][j], storage[i][j-1]);
            }
        }
        return storage[m][n];
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(lcsDP(s, t));
        System.out.println(lcsM(s, t));
        System.out.println(lcs(s, t));
    }
}
