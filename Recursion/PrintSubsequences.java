public class PrintSubsequences {
    public static void main(String[] args){
        String str="xyz";
        String[] temp = {""};
        printSubsequences(str,temp);
    }

    public static void printSubsequences(String str, String[] output){
        if(str.length() == 0){
            return;
        }
        String[] ans = new String[2*output.length];
        for(int i=0;i<output.length;i++){
            if(output.length == 1)
                System.out.println("");
            ans[i] = output[i];
            ans[output.length + i]  = output[i] + str.charAt(0);
            System.out.println(ans[output.length + i]);
        }
        printSubsequences(str.substring(1), ans);
    }
}
