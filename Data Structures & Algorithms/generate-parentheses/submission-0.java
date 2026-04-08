class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        backtrack(0,0,n,res,"");
        return res;
    }

    private void backtrack(int open,int close,int n,List<String>res,String curr)
    {
        if(open==close && open+close==2*n)
        {
            res.add(curr);
            return;
        }
        if(open<n)backtrack(open+1,close,n,res,curr+'(');
        if(close<open)backtrack(open,close+1,n,res,curr+')');
    }
}
