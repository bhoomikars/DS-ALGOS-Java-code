import java.util.LinkedList;
import java.util.Scanner;

public class MonkAndTheIslands {
    static void BFS(int[][] adj,int s,int d){

        int[] visi = new int[d];
        int dis[] = new int[d];

        LinkedList<Integer> qu = new LinkedList<>();

        visi[s] = 1;
        dis[s] = 0;
        qu.add(s);
        while(!qu.isEmpty()){
            int x = qu.poll();
            for(int i = 0; i<d;i++){
                if(visi[i] ==0 && adj[x][i] ==1){
                    visi[i] = 1;
                    dis[i] = dis[x]+1;
                    qu.add(i);
                }
            }
        }
        System.out.println(dis[d-1]);
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[n][n];
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
            int s = 0;
            int d = n;
            BFS(adj,s,d);
        }
    }
}
