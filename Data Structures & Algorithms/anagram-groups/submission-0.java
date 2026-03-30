class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String word:strs)
        {
            int []count=new int[26];
            for(int i=0;i<word.length();i++)
            {
                count[word.charAt(i)-'a']++;
            }
            byte[] key=new byte[2*26];
            for(int i=0;i<26;i++)
            {
                key[i*2]=(byte)(count[i]>>8);
                key[i*2+1]=(byte)(count[i]);
            }
            String hashKey=new String(key,java.nio.charset.StandardCharsets.ISO_8859_1);
            map.computeIfAbsent(hashKey,k->new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
