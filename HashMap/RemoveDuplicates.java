import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
    public static ArrayList<Integer> removeDuplicate(int a[]){
        ArrayList<Integer> output = new ArrayList<Integer>();
        HashMap<Integer, Boolean> seen = new HashMap<Integer, Boolean>();
        for(int i=0;i<a.length;i++){
            if(seen.containsKey(a[i])){
                continue;
            }
            output.add(a[i]);
            seen.put(a[i], true);
        }
        return output;
    }
    public static void main(String[] args){

        int a[] = {1,3,2,4,1,2,2,2,10000,3,2};
        ArrayList<Integer> out = removeDuplicate(a);
        for(int i=0;i<out.size();i++){
            System.out.println(out.get(i));
        }
    }
}
