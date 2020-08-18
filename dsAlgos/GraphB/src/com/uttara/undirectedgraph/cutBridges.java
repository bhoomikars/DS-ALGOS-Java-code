package com.uttara.undirectedgraph;

public class cutBridges {

	private int[] dfsNum;
	private int[] low;
	private int[] parent;
	private int num;
	private Graph G;
	private int source;
	private int srcChildren;
	
	
	public cutBridges(Graph G) {
		 //Graph G = new Graph(in);
		 this.G=G;
		 dfsNum = new int[G.V()];
		 low = new int[G.V()];
		 parent =new int[G.V()];
		 for(int i=0; i<G.V();i++)
			 dfsNum[i]=low[i]=parent[i]=-1;
		 
		 source = 0;
		 cutBrigesDFS(G, 0,0);
		 //System.out.println(" Source children : "+srcChildren);
		 if(srcChildren>1)
			 for(int w:G.adj(source))
				 System.out.println("Cut Bridge : ("+source+" "+w+")");
		
	}

	private void cutBrigesDFS(Graph G, int v,int u) {
		// TODO Auto-generated method stub
		low[v]=dfsNum[v]=++num;
		//int children=0;
		
		for(int w: G.adj(v)){
			
			if(dfsNum[w]==-1) {
				if(v==source)
				srcChildren++;
				
				parent[w]=v;
				
				cutBrigesDFS(G, w,v);
				
				if(low[w]>dfsNum[v] && parent[v]!=-1)
					System.out.println("Cut Bridge : ("+v+" "+w+")");
				
				//if(parent[v]==-1 && srcChildren>1)
					//System.out.println("Cut Bridge : ("+v+" "+w+")");
				
				low[v]=Math.min(low[v], low[w]);
			}
			else if(u!=w){
				//back edge
				low[v]=Math.min(low[v], dfsNum[w]);
			}	
		}
	}
	
	public void printParents(){
		for(int i=0; i<G.V(); i++)
			System.out.print(" " +parent[i]);
		System.out.println();
	}
	
	public void printLow() {
		for(int i=0; i<G.V(); i++)
			System.out.print(" "+low[i]);
		System.out.println();
	}
	
	public void printDFSNum() {
		for(int i=0; i<G.V(); i++)
			System.out.print(" "+dfsNum[i]);
		System.out.println();
	}
	

}
