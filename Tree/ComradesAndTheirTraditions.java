import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ComradesAndTheirTraditions {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            for(int i=0;i<N;i++)
                arr[i] = Integer.parseInt(strs[i]);
            HashMap<Integer, ArrayList<Integer>> map = makeTree(arr);
            long handshakeCount = handshake(map);
            long fistbumpCount = (((long)N*((long)N-1))/2) - handshakeCount;
            System.out.println(handshakeCount + " " + fistbumpCount);
        }

    }

    public static HashMap<Integer, ArrayList<Integer>> makeTree(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                ArrayList<Integer> v = map.get(arr[i]);
                v.add(i + 1);
                map.put(arr[i], v);
            } else {
                ArrayList<Integer> v = new ArrayList<Integer>();
                v.add(i + 1);
                map.put(arr[i], v);
            }
        }
        return map;

    }


    public static long handshake(HashMap<Integer, ArrayList<Integer>> map){
        Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
        long level = 0;
        long result = 0;
        queue.add(map.get(0));
        while(!queue.isEmpty()){
            int n = queue.size();
            while (n-->0){
                ArrayList<Integer> v = queue.poll();
                for(int i=0;i<v.size();i++){
                    result += level;
                    if(map.containsKey(v.get(i))){
                        queue.add(map.get(v.get(i)));
                    }
                }
            }
            level++;
        }
        return result;
    }

}
