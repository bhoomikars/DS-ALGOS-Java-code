import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    public static ArrayList<Integer> getPathDFS(int edges[][],int start, int end, boolean[] visited){
        if(start == end){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(start);
            return ans;
        }
        ArrayList<Integer> ans = null;
        visited[start] = true;
        int n = edges.length;
        for(int i=0;i<n;i++){
            if(edges[start][i] == 1 && !visited[i]){
                ans = getPathDFS(edges, i, end, visited);
                if(ans == null){
                    continue;
                }
                else{
                    ans.add(start);
                    break;
                }
            }
        }
        return ans;
    }

    private static void DFSHelper(int edges[][], int src, boolean visited[]){
        System.out.println(src);
        visited[src] = true;
        int n = edges.length;
        for(int i=0;i<n;i++){
            if(edges[src][i] == 1 && !visited[i])
                DFSHelper(edges, i, visited);
        }
    }

    public static void DFS(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for(int i=0;i<visited.length;i++) {
            if (!visited[i])
                DFSHelper(edges, i, visited);
        }
    }

    public static void BFS(int[][] edges){
        int V = edges.length;
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v + " ");
            for(int i=0;i<V;i++){
                if(edges[v][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static boolean hasPath(int[][] edges, int start, int end){
        int V = edges.length;
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            if(v == end)
                return true;
            for(int i=0;i<V;i++){
                if(edges[v][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int n;
        int e;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        e = scanner.nextInt();
        int edges[][] = new int[n][n];
        for(int i=0;i<e;i++){
            int src = scanner.nextInt();
            int des = scanner.nextInt();
            edges[src][des] = 1;
            edges[des][src] = 1;
        }
        System.out.println(hasPath(edges, 0, 2));
        System.out.println(hasPath(edges, 0, 3));
    }
}
