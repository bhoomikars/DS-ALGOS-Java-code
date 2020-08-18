package com.uttara.dp;

public class StringRelatedDPMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringRelatedDP strDP = new StringRelatedDP();
		int[] a=new int[]{5,6,3,8,9,2,3,4,1,15,9,9};
		int max = +strDP.longestIncreasingSequence(a);
		System.out.println("Length of Longest Increasing Sequence = "+max);
		strDP.printLISTable();
		System.out.println("Print LIS : ");
		strDP.printLIS(max, a);
		System.out.println("Print LIS Recursive : ");
		strDP.printLISRecursive(max, a, a.length+1);

	}

}
