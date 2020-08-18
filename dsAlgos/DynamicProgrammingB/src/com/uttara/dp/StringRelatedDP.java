package com.uttara.dp;

public class StringRelatedDP {
	private int[] longestTable;
	
	public int longestIncreasingSequence(int[] arr) {
		
		//Array to store meta-data longest till the index
		 longestTable = new int[arr.length+1];
		//initialize all the locations to 1 (default)
		for(int i=0; i<longestTable.length; i++)
			longestTable[i]=1;
	
		for(int i=1; i<arr.length;i++){
			for(int j=0;j<=i; j++){
				if(arr[i]>arr[j] && longestTable[i]<longestTable[j]+1)
					longestTable[i]=longestTable[j]+1;
				}
			}
		//find the length of the longest sequence
		int max=0;
		for(int i=0; i<longestTable.length; i++)
			if(max<longestTable[i])
				max=longestTable[i];
		
		return max;
	}
	
	public void printLISTable() {
		for(int i=0; i<longestTable.length; i++)
			System.out.print(" "+longestTable[i]);	
		System.out.println();
	}
	
	public void printLIS(int max, int[] a) {
		for(int i=longestTable.length-1; i>=0;i--){
			if(max==longestTable[i] && longestTable[i+1]!=max) {
				System.out.print(" "+a[i]);
				max--;
			}
		}
		System.out.println();
	}
	
	public void printLISRecursive(int max, int[] a, int index) {
			index--;
		if(index<0)
			return;
		else {
			if(max==longestTable[index] && longestTable[index+1]!=max) {
				printLISRecursive(--max,a,index);
				System.out.print("  "+a[index]);
			}
			else {
				printLISRecursive(max,a,index);
			}
		}	
	}
	

}
