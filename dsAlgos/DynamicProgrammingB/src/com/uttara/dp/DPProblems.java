package com.uttara.dp;

public class DPProblems {
	
	public void optimalRodCut(int[] price, int[] optCut) {
		int[] backTrack = new int[price.length]; 
		for(int i=1;i<price.length; i++) {
			optCut[i]=0;
			for(int k=1; k<=i;k++){
				//int tempVal=price[k]+optCut[i-k];
				if((price[k]+optCut[i-k])>optCut[i]) {
					optCut[i]=price[k]+optCut[i-k];
					backTrack[i]=k;
				}
			}	
		}
		System.out.println("back track array : ");
		for(int i=0; i<backTrack.length; i++)
			System.out.print(" "+backTrack[i]);
		System.out.println();
		
	}
	
	//Fibonacci Series of Numbers with DP
    public   int fib(int n) {
        int[] fib = new int[n+1];
        for (int i = 0; i <= n; i++) {
            fib[i] = -1;
        }
       // System.out.println();
        int fibSeries = fibonacci(n, fib);
        for (int i = 0; i <=n; i++) {
          System.out.print(" "+fib[i]);  
        }
        System.out.println();
        return fibSeries;
        
    }
   private  int fibonacci(int n,int[] fib) {
       fib[0] = 0;
       fib[1] = 1;
       if( 0 == n)
           return 0;
       else if(1 == n) {
          return 1;
       }
       else if(fib[n] != -1) {
           return fib[n];
       }
       else {
           return  fib[n] = fibonacci((n-1), fib) + fibonacci((n-2),fib);
       }  
   }
   
   //fibonacci numbers without DP
   int fibonacciRec(int n) {
      
       if( 0 == n)
           return 0;
       else if(1 == n) {
          return 1;
       }
       else {
    	   int temp = fibonacciRec(n-1) + fibonacciRec(n-2);
           return  temp;
       }  
   }
   
   // Maximum Contiguous Sum of a series
   public  int maxContigousSum(int A[], int n) {
       int[] M = new int[n];
       int[] strIndex = new int[n];
       int maxSum = 0;
       
       if(A[0] > 0)
           M[0] = A[0];
       else
           M[0]= 0;
       for(int i = 1; i < n; i++) {
           if(M[i-1] + A[i] > 0) {
               M[i] = M[i-1] + A[i];
               strIndex[i]=strIndex[i-1];
           }
           else if(A[i] > 0) {
               M[i] = A[i];
               strIndex[i] = i;
           }
           else {
               M[i] = 0;
               strIndex[i]=i;
           }
       }
       
       for(int i = 0; i < n; i++){
           System.out.print("M["+i+"]" + " = "+M[i] +"  " );
           System.out.print("strIndex["+i+"]" + " = "+strIndex[i] +"  " );
           if(M[i] > maxSum)
               maxSum = M[i];
       }
       System.out.println();
      return maxSum;
       
   }
   
   //Catalan Numbers with DP
   public  int catalanNumber(int n) {
       int[] table = new int[100];
       for(int i=0;i<n;i++)
           table[i] = 0;
       return recCatalan(n,table);
       
   }
   
    private  int recCatalan(int n, int[] table) {
        if(n == 0) return 1;
        if(table[n] != 0) 
            return  table[n];
       // table[n] = 0;
        for(int i=1; i<=n; i++)
            table[n] += recCatalan(i-1, table)*recCatalan(n-i, table);
        
       return table[n];
    }
    
    //Catalan numbers without DP
    public int recCatalanRec(int n) {
        if(n == 0) return 1;
        else{
        	int res=0;
        for(int i=1; i<=n; i++){
        		res+= recCatalanRec(i-1)*recCatalanRec(n-i);	
             }
        return res;
        }
    }
    
    public int binomialCoRecursive(int n, int k) {
    	if(n<k)
    		return -1;
    	if(k==0 || n==k)
    		return 1;
    	else
    		return binomialCoRecursive(n-1, k-1)+
    				binomialCoRecursive(n-1, k);
    }
    
    public int binomialWithDP(int n, int k){
    	if(n<k)
    		return -1;
    	int[][] bi_co_ef=new int[n+1][k+1];
    	//int i,j;
    	
    	for(int i=0; i<=n; i++) {
    		for(int j=0; j<=Math.min(i, k); j++){
    			if(j==0 || j==i)
    				bi_co_ef[i][j]=1;
    			else
    				bi_co_ef[i][j] = bi_co_ef[i-1][j]+bi_co_ef[i-1][j-1];
    		}
    	}
    	return bi_co_ef[n][k];
    }
    
   
}
