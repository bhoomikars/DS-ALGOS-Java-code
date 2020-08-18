public class Interleavings {
    public static void main(String[] args){
        String first = "abc";
        String second = "def";
        interleavings(first,second);
    }

    public static void interleavings(String first, String second, String result){
        if(first.length()==0 && second.length()==0){
            System.out.println(result);
            return;
        }
        if(first.length()!=0)
            interleavings(first.substring(1),second,result+first.charAt(0));
        if(second.length()!=0)
            interleavings(first,second.substring(1),result+second.charAt(0));
    }

    public static void interleavings(String first, String second){
        interleavings(first,second,"");

    }
}
