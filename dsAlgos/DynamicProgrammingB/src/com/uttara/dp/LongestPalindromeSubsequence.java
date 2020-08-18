package com.uttara.dp;

public class LongestPalindromeSubsequence {
	
	private int[][] lpsequence;
	private int len;

	public int  lPSubsequence(String str) {
		
		lpsequence=new int[str.length()][str.length()];
		
		for(int i=0; i<str.length(); i++)
			lpsequence[i][i]=1;
		 len = str.length();
		for(int diagonal=2; diagonal<=len; diagonal++) {
			
			for(int from=0;from<len-diagonal+1;from++) {
				
				int to=from+diagonal-1;
				if(str.charAt(from)==str.charAt(to) && diagonal==2)
					lpsequence[from][to]= 2;
				else if(str.charAt(from)==str.charAt(to))
					lpsequence[from][to]=lpsequence[from+1][to-1]+2;
				else
					lpsequence[from][to]=Math.max(lpsequence[from+1][to], lpsequence[from][to-1]);
				
			}
		}
		
		return lpsequence[0][len-1];
		
	}
	
	public void printLPSequenceTable() {
		System.out.println("Printing meta data LPSequence : ");
		for(int i=0;i<len; i++) {
			for(int j=0; j<len; j++) {
				System.out.print("   "+lpsequence[i][j]);
			}
				System.out.println();
		}
	}
	
	public String printLPSequence(String source) {
	    //Rebuilding string from LP matrix
	    StringBuffer strBuff = new StringBuffer();
	    int x = 0;
	    int y = source.length()-1;
	    while(x < y){
	        if(source.charAt(x) == source.charAt(y)){
	            strBuff.append(source.charAt(x));
	            x++;
	            y--;
	        } else if(lpsequence[x][y-1] > lpsequence[x+1][y]){
	            y--;
	        } else {
	            x++;
	        }
	    }
	    StringBuffer strBuffCopy = new StringBuffer(strBuff);
	    String str = strBuffCopy.reverse().toString();
	    if(x == y){          
	        strBuff.append(source.charAt(x)).append(str);
	    } else {
	        strBuff.append(str);
	    }
	    return strBuff.toString();	
	}
	
	//Recursive Implementation
	public String printLPSRecur(String source, int start,int end, StringBuffer strBuff) {
		if(start>=end) {
			StringBuffer strBuffCopy = new StringBuffer(strBuff);
		    String str = strBuffCopy.reverse().toString();
		    if(start == end){          
		        strBuff.append(source.charAt(start)).append(str);
		    } else {
		        strBuff.append(str);
		    }
		    return strBuff.toString();		
		}
		else if(source.charAt(start) == source.charAt(end)) {
			strBuff.append(source.charAt(start));
			return printLPSRecur(source, start+1,end-1, strBuff);
		}
		else if(lpsequence[start][end-1] > lpsequence[start+1][end]){
			return printLPSRecur(source, start,end-1, strBuff);
		}
		else {
			return printLPSRecur(source, start+1,end, strBuff);
		}
	}
	
}
