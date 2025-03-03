class TrieNode{
    char data;
    boolean isTerminating;
    TrieNode[] children;
    int childCount;
    public TrieNode(char data){
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}

public class Trie {
    private TrieNode root;
    private int numWords;
    public Trie(){
        root = new TrieNode('\0');
        numWords = 0;
    }
    private boolean add(TrieNode root, String word){
        if(word.length() == 0){
            if(root.isTerminating)
                return false;
            else{
                root.isTerminating = true;
                return true;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        return add(child, word.substring(1));
    }

    public void add(String word){
        if(add(root, word))
            numWords++;
    }

    private boolean search(TrieNode root, String word){
        if(word.length() == 0){
            if(root.isTerminating)
                return true;
            else
                return false;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
            return false;
        return search(child, word.substring(1));
    }

    public boolean search(String word){
        return search(root, word);
    }

    private boolean remove(TrieNode root, String word){
        if(word.length() == 0){
            if(root.isTerminating){
                root.isTerminating = false;
                return true;
            }
            else
                return false;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
            return false;
        boolean ans = remove(child, word.substring(1));
        if(!child.isTerminating && child.childCount ==0){
            root.children[childIndex] = null;
            root.childCount--;
        }
        return ans;
//        if(!child.isTerminating){
//            int numChild = 0;
//            for(int i=0;i<26;i++){
//                if(child.children[i]!=null)
//                    numChild++;
//            }
//            if(numChild == 0){
//                root.children[childIndex] = null;
//                root.childCount--;
//            }
//        }
    }
    public void remove(String word){
        if(remove(root, word))
            numWords--;
    }
    public int countWords() {
        return this.numWords;

    }
}
