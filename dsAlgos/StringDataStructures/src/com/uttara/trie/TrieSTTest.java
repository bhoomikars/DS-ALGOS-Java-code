package com.uttara.trie;

public class TrieSTTest {

	 /**
     * Unit tests the <tt>TrieSET</tt> data type.
     */
    public static void main(String[] args) {

        // build symbol table from standard input
        TrieST<Integer> st = new TrieST<Integer>();
        String str = new String("she sells sea shells by the sea shore");
        String[] word = str.split(" ");
        for (int i = 0; i<word.length; i++) {
            st.put(word[i], i);
        }

        // print results
        if (st.size() < 100) {
            System.out.println("keys(\"\"):");
            for (String key : st.keys()) {
            	System.out.println(key + " " + st.get(key));
            }
            System.out.println();
        }

        System.out.println("longestPrefixOf(\"shellsort\"):");
        System.out.println(st.longestPrefixOf("shellsort"));
        System.out.println();

        System.out.println("keysWithPrefix(\"shor\"):");
        for (String s : st.keysWithPrefix("shor"))
        	System.out.println(s);
        System.out.println();

        System.out.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
        	System.out.println(s);
        
        System.out.println("Deleting a Key");
        st.delete("she");
        // print results
        if (st.size() < 100) {
        	System.out.println("keys(\"\"):");
            for (String key : st.keys()) {
            	System.out.println(key + " " + st.get(key));
            }
            System.out.println();
        }
        
        
    }

}
