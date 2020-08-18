public class Palindrome {
    public static void main(String[] args){
        String str = "abccba";
        String s = "";
        for(int i=str.length()-1;i>=0;i--){
            s = s + str.charAt(i);
        }
        if(str.equals(s))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
