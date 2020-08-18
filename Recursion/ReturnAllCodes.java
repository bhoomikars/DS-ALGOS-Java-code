public class ReturnAllCodes {

    public static void main(String[] args){
        String[] res = getCode("1123");
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);
    }



    public static char helper(int n){
        return (char)(96+n);
    }

    private static String[] getCode(String input){
        if(input.length() <= 0){
            String[] ans ={""};
            return ans;
        }
        String[] smallAns1 = getCode(input.substring(1));
        String[] smallAns2 = {};
        if(input.length()>1 && Integer.valueOf(input.substring(0,2))<=26){
            smallAns2 = getCode(input.substring(2));
        }
        String[] ans = new String[smallAns1.length + smallAns2.length];
        for(int i=0;i<smallAns1.length;i++)
            ans[i] = helper(input.charAt(0) -'0') + smallAns1[i];
        for(int i=0;i<smallAns2.length;i++)
            ans[i + smallAns1.length] = helper(Integer.valueOf(input.substring(0,2))) + smallAns2[i];
        return ans;
    }



}
