import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    int v,time,toll;
    public Node(int v, int time, int toll) {
        this.v = v;
        this.time = time;
        this.toll = toll;
    }
}

class MinPQComaparator implements Comparator<Node>{
    @Override
    public int compare(Node n1, Node n2){
        return n1.time - n2.time;
    }
}

public class FishMonger {
    public static int minTime(int time[], boolean visited[]){
        int min = Integer.MAX_VALUE, min_index = -1;
        int n = time.length;
        for(int i=0;i<n;i++)
            if(!visited[i] && min>time[i]){
                min = time[i];
                min_index = i;
            }
        return min_index;
    }

    public static void dijkstra(int[][] time, int[][] toll, int t){
        int n = time.length;
        int[] mintime = new int[n];
        for(int i=0;i<n;i++)
            mintime[i] = Integer.MAX_VALUE;
        int[] mintoll = new int[n];
        for(int i=0;i<n;i++)
            mintoll[i] = Integer.MAX_VALUE;
        PriorityQueue<Node> PQ = new PriorityQueue<>(new MinPQComaparator());
        PQ.add(new Node(0,0,0));
        while(!PQ.isEmpty()){
            Node m = PQ.remove();
            if(mintoll[m.v]<=m.toll)
                continue;
            mintoll[m.v] = m.toll;
            mintime[m.v] = m.time;
            for(int i=0;i<n;i++){
                if(i!=m.v && m.time+time[m.v][i]<=t){
                    PQ.add(new Node(i, m.time+time[m.v][i], m.toll+toll[m.v][i]));
                }
            }
        }
        System.out.println(mintoll[n-1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[][] time = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                time[i][j] = in.nextInt();
            }
        }
        int[][] toll = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                toll[i][j] = in.nextInt();
            }
        }
        dijkstra(time, toll, t);
    }
}
