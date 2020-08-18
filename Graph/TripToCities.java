import javafx.util.Pair;

import javax.swing.*;
import java.util.*;

public class TripToCities {

    private static int cnt = 0;

    public static int minDistances(int distances[], boolean visited[]){
        int min = Integer.MAX_VALUE, min_index = -1;
        int n = distances.length;
        for(int i=0;i<n;i++)
            if(!visited[i] && min>distances[i]){
                min = distances[i];
                min_index = i;
            }
        return min_index;
    }

    public static void dijkstra(ArrayList<Pair<Integer, Integer>>[] adj, int c, int k){
        int n = adj.length;
        TreeSet<Pair<Integer, Integer>> s = new TreeSet<>();
        int[] distances = new int[n];
        for(int i=0;i<n;i++)
            distances[i] = Integer.MAX_VALUE;
        distances[c] = 0;
        Pair<Integer, Integer> p = new Pair<>(distances[c],0);
        s.add(p);
        while(!s.isEmpty()){
            Pair<Integer, Integer> temp = s.first();
            s.remove(s.first());
            int u = temp.getValue();
            if(distances[u]<=k)
                cnt++;
            for(int i=0;i<adj[u].size();i++){
                int v = adj[u].get(i).getKey();
                int w = adj[u].get(i).getValue();
                if(distances[u] + w < distances[v]){
                    if(distances[v]!=Integer.MAX_VALUE)
                        s.remove(new Pair<Integer, Integer>(distances[v], v));
                    distances[v] = distances[u] + w;
                    s.add(new Pair<Integer, Integer>(distances[v], v));

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();
        int k = in.nextInt();
        ArrayList<Pair<Integer, Integer>> adj[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            adj[x-1].add(new Pair(y-1, z));
            adj[y-1].add(new Pair(x-1, z));

        }
        cnt = 0;
        dijkstra(adj, c-1, k);
        System.out.println(cnt);
    }


}
