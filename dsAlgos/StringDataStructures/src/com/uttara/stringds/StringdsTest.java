package com.uttara.stringds;

import java.util.ArrayList;

public class StringdsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testString = "mississippi";
        String[] stringList = {"is", "sip", "hi", "sis"};
        SuffixTree tree = new SuffixTree(testString);
		for (String s : stringList) {
        	ArrayList<Integer> list = tree.search(s);
        	if (list != null) {
        		System.out.println(s + ": " + list.toString());
        	}
		}
		
	}

}
