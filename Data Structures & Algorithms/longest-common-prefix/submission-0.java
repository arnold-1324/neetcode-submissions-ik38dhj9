class TrieNode{
    Map<Character,TrieNode> child=new HashMap<>();
}

class Trie{
    TrieNode root=new TrieNode();
    void insert(String s)
    {
        TrieNode node=root;
        for(char c:s.toCharArray())
        {
            node.child.putIfAbsent(c,new TrieNode());
            node=node.child.get(c);
        }
    }
        int lcp(String word,int prefixlen)
        {
            TrieNode node=root;
            int i=0;
            while(i<Math.min(word.length(),prefixlen)){
                if(!node.child.containsKey(word.charAt(i))) return i;
                node=node.child.get(word.charAt(i));
                i++;
            }
            return Math.min(i,prefixlen);
        }
    
}



class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min=0;
        for(int i=1;i<strs.length;i++)
        {
            if(strs[min].length()>strs[i].length())min=i;
        }
        Trie trie=new Trie();
        trie.insert(strs[min]);
        int prefixlen=strs[min].length();
        for(int i=0;i<strs.length;i++)
        {
            prefixlen=trie.lcp(strs[i],prefixlen);
        }
        return strs[min].substring(0,prefixlen);
    }
}