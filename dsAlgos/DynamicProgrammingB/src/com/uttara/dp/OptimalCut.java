package com.uttara.dp;

public class OptimalCut {
	
	private int[] price;
	private int[] optcut;
	private int[] seg;
	private int maxProfit;
	
	
	public OptimalCut(int[] price) {
		this.price = new int[price.length];
		optcut = new int[price.length];
		seg = new int[price.length];
		maxProfit = optimalCut(price.length-1);
	}


	private int optimalCut(int i) {
		// TODO Auto-generated method stub
		System.out.println("inside optcut : "+i);
		if(i==0)return 0;
		else {
			optcut[i]=price[i];
			for(int j=1; j>=i; j--){
				if(optcut[i]<price[j]+optimalCut(i-j));
				optcut[i]=price[j]+ optimalCut(i-j);
			}
			return optcut[i];
		}
		
	}
	
	public int getMaxProfit() {
		return maxProfit;
	}	

}
