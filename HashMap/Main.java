import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        HashMap<String,Integer> map = new HashMap<String, Integer>();
        //Insert
        map.put("abc", 1);
        map.put("def", 2);

        System.out.println("Size : " + map.size());

        // check presence
        if(map.containsKey("abc")){
            System.out.println("Has abc");
        }
        if(map.containsKey("abc1")){
            System.out.println("Has abc1");
        }

        if(map.containsValue(2)){ // expensive
            System.out.println("has 2 as value");
        }


        // get Value
        int v = map.get("abc");
        System.out.println(v);
        //int u = map.get("abc1");  // returns NULL
        //System.out.println(u);

        //remove
        int r = map.remove("abc");
        System.out.println(r);

        // iterate
        Set<String> keys = map.keySet();
        for(String s: keys){
            System.out.println(s);
        }
    }
}
