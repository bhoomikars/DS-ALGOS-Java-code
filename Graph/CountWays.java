import java.util.ArrayList;
import java.util.Scanner;

public class CountWays {
    public static int pathCountUtil(ArrayList<Integer>[] adj, int u, int v, boolean[] visited){
        int n = adj.length;
        if(u==v)
            return 1;
        visited[u] = true;
        int ans = 0;
        for(int i=0;i<adj[u].size(); i++){
            if(!visited[adj[u].get(i)])
                ans += pathCountUtil(adj, adj[u].get(i), v, visited);
        }
        visited[u] = false;
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            adj[x-1].add(y-1);

        }
        int s = in.nextInt();
        boolean visited[] = new boolean[n];
        long pathCount = 0;
        for(int i=0;i<n;i++){
            pathCount += pathCountUtil(adj, s-1, i, visited);
        }
        System.out.println(pathCount%1000000007);
    }
}
