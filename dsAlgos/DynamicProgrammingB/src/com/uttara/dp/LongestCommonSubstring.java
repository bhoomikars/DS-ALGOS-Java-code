package com.uttara.dp;

public class LongestCommonSubstring {
	
	private boolean[][] lpSubstring;
	private int start;
	
	public String longPalinSubstring(String str) {
		lpSubstring=new boolean[str.length()][str.length()];
		int maxLength=1;
		for(int i=0; i<str.length()-1; i++) {
			lpSubstring[i][i]=true;
			if(str.charAt(i)==str.charAt(i+1)) {
				lpSubstring[i][i+1]=true;
				maxLength=2;
				start=i;
			}
				
		}
		 int len = str.length();
		 
		for(int diagonal=3; diagonal<=len; diagonal++) {
			
			for(int from=0;from<len-diagonal+1;from++) {
				
				int to=from+diagonal-1;
				if(str.charAt(from)==str.charAt(to) && lpSubstring[from+1][to-1]==true){
					start=from;
					maxLength = diagonal;
					lpSubstring[from][to]=true;
				}
			}
		}
		System.out.println(" "+start+" "+maxLength);
		return str.substring(start, start+maxLength);	
	}
	

}
