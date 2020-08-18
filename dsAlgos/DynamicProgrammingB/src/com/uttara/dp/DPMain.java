package com.uttara.dp;

public class DPMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Rod Cut Started : ");
		DPProblems dp = new DPProblems();
		int[] price = new int[]{0,1,5,8,9,10,17,17,20};
		int[] optCut = new int[price.length];
		dp.optimalRodCut(price, optCut);
		for(int i=0; i<optCut.length;i++)
			System.out.print(" "+optCut[i]);
		System.out.println();
		System.out.println("Rod Cut Ended");
		System.out.println("Fibonacci with DP = " +dp.fib(20));
		System.out.println("Fibonacci wihout DP : "+dp.fibonacciRec(20));
		System.out.println("Catalan Number with DP : "+dp.catalanNumber(10));
		System.out.println("Catalan Number witout DP : " +dp.recCatalanRec(10));
		System.out.println("Binomial Co-efficients without DP: "+dp.binomialCoRecursive(1, 1));
		System.out.println("Binomial Co-efficients with DP: "+dp.binomialWithDP(10, 2));
		System.out.println();
		int [] arr = {-10,-2,11,-4,13,-5,2};
        System.out.println("Max Contigous Sum = " +dp.maxContigousSum(arr, arr.length));
        
        LCS lcs = new LCS(8, 8);
		
        int res = lcs.longestCommonSubsequence("sedwhfwo", "eakwfkeb");
		System.out.println(" " +res );
		lcs.printLCSMatrix();
		
		//String str = lcs.printLCS(res, "sedwhfwo", "eakwfkeb");
		System.out.println("LCS is : "+lcs.printLCS(res, "sedwhfwo", "eakwfkeb"));
		
		System.out.println();
		
		String strThree = "ramacharitha manasa";
		String strFour =  "sri ramayana darshanam";
		
		LCS lcsTwo = new LCS(strThree.length(), strFour.length());
		
		int twores = lcsTwo.longestCommonSubsequence(strThree, strFour);
		lcsTwo.printLCSMatrix();
		System.out.println("LCS two is: "+lcsTwo.printLCS(twores, strThree, strFour));
		System.out.println();
		
		//Integer Knapsack Problem
		
		  int[] weight = {0,2,1,3,2};
        int[] profits = {0,12,10,20,15};
        IntegerKnapsack dymPro = new IntegerKnapsack(weight, profits, 5);
        System.out.println("Knapsack = " +dymPro.intKnapsack(4, 5));
        System.out.print("Solution Matrix :");
        dymPro.printSolMatrix();
        System.out.print("Solution Recursive Vector :");
        dymPro.recPrintVector(4, 5);
        System.out.print("Solution Normal Vector :");
        dymPro.printSolVector();
		

	}

}
