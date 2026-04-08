class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        backtrack(0,s,res,new ArrayList<>());
        return res;
    }

    private void backtrack(int idx,String s,List<List<String>> res,List<String>curr)
    {
        if(idx==s.length())
          {
            res.add(new ArrayList<>(curr));
            return ;
          }

           for(int i=idx;i<s.length();i++)
          {
             if(isPalindrom(idx,i,s))
             {
                curr.add(s.substring(idx,i+1));
                backtrack(i+1,s,res,curr);
                curr.remove(curr.size()-1);
             }
          }
    }

    private boolean isPalindrom(int start,int end ,String s)
    {
        while(start<=end)
        {
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}
