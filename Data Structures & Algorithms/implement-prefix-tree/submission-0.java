

public class TrieNode{
    TrieNode[] child=new TrieNode[26];
    boolean endofWord=false;
}
class PrefixTree {
     private TrieNode root;
    public PrefixTree() {
        root=new TrieNode();
    }

    public void insert(String word) {
          TrieNode node=root;
          for(char ch:word.toCharArray())
          {
            int idx=ch-'a';
            if(node.child[idx]==null) node.child[idx]=new TrieNode();
            node=node.child[idx];
          }
          node.endofWord=true;
    }

    public boolean search(String word) {
       TrieNode node=root;
       for(char ch:word.toCharArray())
       {
        int idx=ch-'a';
        if(node.child[idx]==null) return false;
        node=node.child[idx];
       }
       return node.endofWord;
    }

    public boolean startsWith(String prefix) {
       TrieNode node=root;
       for(char ch:prefix.toCharArray())
       {
         int idx=ch-'a';
         if(node.child[idx]==null) return false;
         node=node.child[idx];
       }
       return true;
    }
}
