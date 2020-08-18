package com.uttara.tst;

public class TSTTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TernarySearchTree tst = new TernarySearchTree();
		 tst.insert("apple");
		 tst.insert("pineapple");
		 tst.insert("mango");
		 tst.insert("pin");
		 tst.insert("pine");
		 System.out.println(tst.toString());
		 tst.insert("pi");
		 System.out.println(tst.toString());
		 System.out.println(tst.search("mango"));
		 System.out.println(tst.search("man"));
		 tst.delete("pineapple");
		 System.out.println(tst.toString());
	}

}
