class Solution {

    public String encode(List<String> strs) {
      if(strs.isEmpty()) return "";
      StringBuilder res=new StringBuilder();
      for(String s:strs)
        res.append(s.length()+"#").append(s);
      return res.toString();
    }

    public List<String> decode(String str) {
      if(str.length()==0) return new ArrayList<>();
      List<String> result=new ArrayList<>();
      int i=0;
      while(i<str.length())
      {
        int j=i;
        while(str.charAt(j)!='#') j++;
        int len=Integer.parseInt(str.substring(i,j));
        j++;
        String word=str.substring(j,j+len);
        result.add(word);
        i=j+len;
      }
      return result;
    }
}
