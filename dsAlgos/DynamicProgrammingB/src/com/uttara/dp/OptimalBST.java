package com.uttara.dp;

public class OptimalBST {
	private double[][] opt;
	private int[][] brp;
	private int len;
	
	public double optimalOrder(double[] arr){
		len = arr.length;
		opt=new double[len+1][len];
		brp=new int[len+1][len];
		for(int i=0;i<len;i++){
			opt[i][i]=arr[i];
			brp[i][i]=i;
		}
		for(int diagonal=2;diagonal<=len;diagonal++) {
			for(int from=1;from<len-diagonal+1;from++) {
				
				int to=from+diagonal-1;
				opt[from][to] = Integer.MAX_VALUE;
				double prob=0.0;
				for(int i=from;i<=to;i++)
					prob+=arr[i];
				
				for(int k=from; k<=to;k++){
					double cost=opt[from][k-1]+opt[k+1][to]+prob;
					if(cost<opt[from][to]) {
						opt[from][to] = cost;
						brp[from][to] = k;
					}
				}
				
			}
		}
		
			return opt[1][len-1];
		}


	
	public void printOptData() {
		for(int i=0; i<len;i++){
			for(int j=0;j<len;j++){
				System.out.print("    "+opt[i][j]);
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

}
