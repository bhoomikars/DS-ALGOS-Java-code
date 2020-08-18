package com.uttara.dp;

public class MatrixMultiplication {
	
	private int[][] mul;
	private int[][] brp;
	private int len;
	
	public int multiplyOrder(int[] arr){
		len = arr.length;
		mul=new int[len][len];
		brp=new int[len][len];
		for(int i=0;i<len;i++)
			mul[i][i]=0;
		for(int diagonal=2;diagonal<=len;diagonal++) {
			
		
			for(int from=1;from<len-diagonal+1;from++) {
				
				int to=from+diagonal-1;
				mul[from][to] = Integer.MAX_VALUE;
				for(int k=from; k<=to-1;k++){
					int cost=mul[from][k]+mul[k+1][to]+ arr[from-1]*arr[k]*arr[to];
					if(cost<mul[from][to]) {
						mul[from][to] = cost;
						brp[from][to] = k;
					}
				}
				
			}
		}
		
			return mul[1][len-1];
		}


	
	public void printMulData() {
		for(int i=0; i<len;i++){
			for(int j=0;j<len;j++){
				System.out.print("    "+mul[i][j]);
			}
			System.out.println();
		}
	}
	
	public void breakpointMatrix() {
		
		for(int i=0; i<len;i++){
			for(int j=0;j<len;j++){
				System.out.print("    "+brp[i][j]);
			}
			System.out.println();
		}
	}
	
	public void printMulOrder(int i, int j) {
		if(i==j)
			System.out.print("M"+i);
		else {
			int split = brp[i][j];
			System.out.print("(");
			printMulOrder(i, split);
			printMulOrder(split+1, j);
			System.out.print(")");
		}
	}
	
}
