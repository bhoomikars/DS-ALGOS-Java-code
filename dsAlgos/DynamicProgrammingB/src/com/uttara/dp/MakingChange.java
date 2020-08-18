package com.uttara.dp;

public class MakingChange {
	
	private int[] minTable;
	private int[] denom={1,5,20,25};
	private int cap;
	private int[] backTrack;
	
	public  MakingChange(int n) {
		minTable=new int[n+1];
		backTrack = new int[n+1];
		cap=n;
		for(int i=0; i<=n;i++){
			minTable[i]=0;
			backTrack[i]=0;
		}
	}
	

	
	public int makingChange() {
		
		for(int p=1;p<=cap;p++){
			//initialize minimum value
			int min=Integer.MAX_VALUE;
			
			for(int j=0;j<denom.length && (p-denom[j])>=0;j++) {
				if(minTable[p-denom[j]]<min) {
					min=minTable[p-denom[j]];
					backTrack[p] =denom[j];
				}
			}
				minTable[p]=min+1;		
			}
		return minTable[cap];
	}
	
	public void printDenoms(int cap){
		if(cap==0)
			return;
		else{
			printDenoms(cap-backTrack[cap]);
			System.out.print(" "+backTrack[cap]);
		}
		
	}
	
	public void printMinTable() {
		
		for(int i=0;i<=cap;i++)
		System.out.print("  "+minTable[i]);
		System.out.println();
		
			
		System.out.println(" Printing Back Track Array : ");
		for(int i=0;i<=cap;i++)
		System.out.print("  "+backTrack[i]);
		System.out.println();
	}
	
	

}
