public class CheckPalindrome {
    public static int index = 0;
    public static boolean isStringPalindrome(String input) {
        if(index>input.length()/2){
            return true;
        }
        if(!(input.charAt(index++) == input.charAt(input.length() - index)) )
            return false;
        return isStringPalindrome(input);

    }
    public static void main(String[] args){
        String str = "racecar";
        System.out.println(isStringPalindrome(str));
    }
}
