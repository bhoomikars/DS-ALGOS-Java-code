package com.uttara.dp;

public class LCS {
	
	private int[][] lcs;
	private int mlength;		
	private int nlength;
		
	public LCS(int m, int n) {
			super();
		this.mlength = m;
		this.nlength = n;
		this.lcs = new int[m+1][n+1];
	}

	public int longestCommonSubsequence(String S, String T) {
			for (int i = 0; i <= mlength; i++) {
				lcs[i][nlength] = 0;
			}
			for (int j = 0; j <= nlength; j++) {
				lcs[mlength][j] = 0;
			}
			
			for (int i = mlength-1; i >= 0; i--) {
				for(int j = nlength-1; j>=0; j--) {
					lcs[i][j] = lcs[i+1][j+1];
					
					if(S.charAt(i)== T.charAt(j))
						lcs[i][j]++;
					
					if(lcs[i][j+1] > lcs[i][j])
						lcs[i][j] = lcs[i][j+1];
					
					if(lcs[i+1][j] > lcs[i][j]) 
						lcs[i][j] = lcs[i+1][j];
				}
				
			}
					
			return lcs[0][0];	
		}
	
	
	
	public String printLCS(int len,String one, String two) {
	// Start from the left top and
	   // one by one store characters in lcs[]
		char[] Lcs = new char[len];
		System.out.println("Length is : "+len);
		//Lcs[len]='\0';
		int index=0;
	   int i = 0, j = 0;
	   while (i < mlength && j < nlength)
	   {
	      // If current character in X[] and Y are same, then
	      // current character is part of LCS
	      if (one.charAt(i) == two.charAt(j))
	      {
	    	  System.out.println("Index is : "+index + two.charAt(j));
	          Lcs[index] = one.charAt(i); // Put current character in result
	          i++; j++; index++;     // reduce values of i, j and index
	      }
	 
	      // If not same, then find the larger of two and
	      // go in the direction of larger value
	      else if (lcs[i+1][j] > lcs[i][j+1])
	         i++;
	      else
	         j++;
	   }
	   String str = new String(Lcs);
	  return str; 
	  
	}
		
		public void printLCSMatrix() {
			for (int i = 0; i <= mlength; i++) {
				System.out.println();
				for (int j = 0; j <= nlength; j++) {
					System.out.print(" " +lcs[i][j]);
				}
				
			}
			System.out.println();
		}
		

}
