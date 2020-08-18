import java.util.*;
public class StringAnagram {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = makeAnagram(s1, s2);
        System.out.println(result);
    }
    public static int makeAnagram(String s1,String s2){
        int count = 0;
        int v,r;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s1.length();i++){
            if(map.containsKey(s1.charAt(i))){
                v = map.get(s1.charAt(i));
                map.put(s1.charAt(i),v+1);
            }
            else
                map.put(s1.charAt(i),1);
        }
        for(int i=0;i<s2.length();i++){
            if(map.containsKey(s2.charAt(i))){
                v = map.get(s2.charAt(i));
                v--;
                if(v!=0)
                    map.put(s2.charAt(i), v);
                else
                    r = map.remove(s2.charAt(i));
            }else{
                count++;
            }
        }

        Set<Character> keys = map.keySet();
        for(Character ch : keys) {
            count += map.get(ch);
        }
        return count;
    }

}
