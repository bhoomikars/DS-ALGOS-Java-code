import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String str = findMinSubstringContainingString("Looks for minimum string","mums");
        System.out.println(str);
    }

    public static String findMinSubstringContainingString(String large, String small){
        if(large.length()<small.length())
            return null;
        int v;
        HashMap<Character, Integer> map_large = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map_small = new HashMap<Character, Integer>();
        for(int i=0;i<256;i++){
            char ch = (char)i;
            map_large.put(ch, 0);
            map_small.put(ch, 0);
        }
        for(int i=0;i<small.length();i++){
            v = map_small.get(small.charAt(i));
            map_small.put(small.charAt(i), v+1);
        }
        int start=0, start_index = -1, l = Integer.MAX_VALUE;
        int count=0;
        for(int i=0;i<large.length();i++){
            v = map_large.get(large.charAt(i));
            map_large.put(large.charAt(i), v+1);

            if(map_small.get(large.charAt(i))!=0 && map_large.get(large.charAt(i))<=map_small.get(large.charAt(i)))
                count++;
            if(count==small.length()){
                while(map_large.get(large.charAt(start)) > map_small.get(large.charAt(start)) || map_small.get(large.charAt(start))==0){
                    if(map_large.get(large.charAt(start)) > map_small.get(large.charAt(start))){
                        v = map_large.get(large.charAt(start));
                        map_large.put(large.charAt(start), v-1);
                    }
                    start++;
                }
                int w = i-start+1;
                if(l>w){
                    l = w;
                    start_index = start;
                }
            }

        }
        if(start_index != -1)
            return large.substring(start_index, start_index+l);
        else
            return null;

    }
}
