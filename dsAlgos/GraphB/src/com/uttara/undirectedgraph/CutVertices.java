package com.uttara.undirectedgraph;

public class CutVertices {
	
	private int[] dfsNum;
	private int[] low;
	private int[] parent;
	private int num;
	
	
	public CutVertices(Graph G) {
		 //Graph G = new Graph(in);
		 Cycle cycle = new Cycle(G);
		 dfsNum = new int[G.V()];
		 low = new int[G.V()];
		 parent =new int[G.V()];
		 for(int i=0; i<G.V();i++)
			 dfsNum[i]=low[i]=parent[i]=-1;
		 
		 cutVerticesDFS(G, 0);
		
	}

	private void cutVerticesDFS(Graph G, int v) {
		// TODO Auto-generated method stub
		low[v]=dfsNum[v]=num++;
		int children=0;
		
		for(int w: G.adj(v)){
			
			if(dfsNum[w]==-1) {
				children++;
				parent[w]=v;
				cutVerticesDFS(G, w);
				
				if(low[w]>=dfsNum[v] && parent[v]!=-1)
					System.out.println("Cut Vertex : "+v);
				
				if(parent[v]==-1 && children>1)
					System.out.println("Cut Vertex : "+v);
				
				low[v]=Math.min(low[v], low[w]);
			}
			else {
				//back edge
				low[v]=Math.min(low[v], dfsNum[w]);
			}
				
		}
		
	}
	

}
