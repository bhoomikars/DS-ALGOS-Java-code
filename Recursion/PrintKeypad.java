public class PrintKeypad {
    public static void main(String[] args){
        String[] temp = {""};
        keypad(234,temp);

    }

    private static String helperKey(int n){
        switch (n){
            case 2: return "abc";
            case 3: return "def";
            case 4: return "ghi";
            case 5: return "jkl";
            case 6: return "mno";
            case 7: return "pqrs";
            case 8: return "tuv";
            case 9: return "wxyz";
        }
        return "";
    }
    public static void keypad(int n, String[] output){
        if(n==0){
            for(int i=0;i<output.length;i++)
                System.out.println(output[i]);
            return;
        }
        String temp = helperKey(n%10);
        String[] ans = new String[output.length * temp.length()];
        int k=0;
        for(int i=0;i<output.length;i++){
            for(int j=0;j<temp.length();j++)
                ans[k++] = temp.charAt(j) + output[i];
        }
        keypad(n/10, ans);
    }
}
