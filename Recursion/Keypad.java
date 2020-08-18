public class Keypad {
    public static void main(String[] args){
        String[] res = keypad(234);
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);

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
    public static String[] keypad(int n){
        if(n==0){
            String[] ans = {""};
            return ans;
        }
        String[] smallAns = keypad(n/10);
        String temp = helperKey(n%10);
        String[] ans = new String[smallAns.length * temp.length()];
        int k=0;
        for(int i=0;i<smallAns.length;i++){
            for(int j=0;j<temp.length();j++)
                ans[k++] = smallAns[i] + temp.charAt(j);
        }
        return ans;
    }
}
