package com.uttara.undirectedgraph;

public class CutMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph(7);
        G.addEdge(0,1);
        G.addEdge(0,3);
        G.addEdge(2,3);
        G.addEdge(3,4);
        G.addEdge(4,5);
        G.addEdge(5,3);
        G.addEdge(2,6);
        G.addEdge(1,2);
		CutVertices cutV= new CutVertices(G);
		

	}

}
