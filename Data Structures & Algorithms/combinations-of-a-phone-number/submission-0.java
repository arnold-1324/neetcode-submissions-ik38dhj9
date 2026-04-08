class Solution {
    private static final String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String>res=new ArrayList<>();
         if (digits == null || digits.length() == 0) return res;
        backtrack(0,digits,res,"");
        return res;
    }


    private void backtrack(int idx,String digits,List<String>res,String curr)
    {
        if(idx==digits.length())
        {
            res.add(curr);
            return;
        }
        String s=map[digits.charAt(idx)-'0'];
        for(int i=0;i<s.length();i++)
           backtrack(idx+1,digits,res,curr+s.charAt(i));
    }
}
