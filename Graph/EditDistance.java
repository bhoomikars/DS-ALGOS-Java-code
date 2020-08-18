import java.util.Scanner;

public class EditDistance {
    public static int editDistance(String s1, String s2){
        if(s2.length()==0)
            return s1.length();
        if(s1.length() ==0)
            return s2.length();
        if(s1.charAt(0) == s2.charAt(0))
            return editDistance(s1.substring(1), s2.substring(1));
        else{
            int op1 = editDistance(s1, s2.substring(1)); // insert
            int op2 = editDistance(s1.substring(1), s2); // delete
            int op3 = editDistance(s1.substring(1), s2.substring(1));
            return 1 + Math.min(op1, Math.min(op2, op3));
        }
    }

    public static int editDistanceM(String s1, String s2, int[][] storage){
        int m = s1.length();
        int n = s2.length();
        if(m==0){
            storage[m][n] = n;
            return storage[m][n];
        }
        if(n==0){
            storage[m][n] = m;
            return storage[m][n];
        }
        if(storage[m][n] != -1)
            return storage[m][n];
        if(s1.charAt(0) == s2.charAt(0))
            storage[m][n] = editDistanceM(s1.substring(1), s2.substring(1), storage);
        else{
            int op1 = editDistanceM(s1, s2.substring(1), storage);
            int op2 = editDistanceM(s1.substring(1), s2, storage);
            int op3 = editDistanceM(s1.substring(1), s2.substring(1), storage);
            storage[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
        }
        return storage[m][n];
    }

    public static int editDistanceM(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] storage = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++)
                storage[i][j] = -1;
        }
        return editDistanceM(s1, s2, storage);
    }

    public static int editDistanceDP(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] storage = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0)
                    storage[i][j] = j;
                else if(j==0)
                    storage[i][j] = i;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    storage[i][j] = storage[i-1][j-1];
                else{
                    storage[i][j] = 1 + Math.min(storage[i][j-1], Math.min(storage[i-1][j], storage[i-1][j-1]));
                }
            }
        }
        return storage[m][n];
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        System.out.println(editDistanceDP(str1, str2));
        System.out.println(editDistanceM(str1, str2));
        System.out.println(editDistance(str1, str2));
    }
}
