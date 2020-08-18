import java.util.Scanner;

public class DelhiTraffic {
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

    public static void dijkstra(int[][] graph, int s, int d, int[] time){
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++)
            distances[i] = Integer.MAX_VALUE;
        distances[s] = 0;
        for(int count=0;count<n;count++){
            int u = minDistances(distances, visited);
            visited[u] = true;
            for(int i=0;i<n;i++){
                if(graph[u][i]!=0 && !visited[i]){
                    if(i!=d){
                        int rem = (distances[u] + graph[u][i])%time[i];
                        if(rem!=0 && distances[i] > distances[u] + graph[u][i] + time[i] - rem)
                            distances[i] = distances[u] + graph[u][i] + time[i] - rem;
                        if(rem==0 && distances[i] > distances[u] + graph[u][i])
                            distances[i] = distances[u] + graph[u][i];
                    }
                    else {
                        if (distances[i] > distances[u] + graph[u][i])
                            distances[i] = distances[u] + graph[u][i];
                    }
                }
            }
        }
        System.out.println(distances[d]);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] time = new int[n];
        for(int i=0;i<n;i++)
            time[i] = in.nextInt();
        int[][] graph = new int[n][n];
        for(int i=0;i<m;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            graph[x-1][y-1] = w;
            graph[y-1][x-1] = w;
        }
        int s = in.nextInt();
        int d = in.nextInt();
        dijkstra(graph,s-1, d-1, time);
    }
}
