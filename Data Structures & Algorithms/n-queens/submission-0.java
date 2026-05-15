class Solution {
      List<List<String>>res=new ArrayList<>();
      private boolean[] col,pos,neg;
    public List<List<String>> solveNQueens(int n) {
        col=new boolean[n];
        pos = new boolean[2*n-1];
        neg = new boolean[2*n-1];
        char[][] board=new char[n][n];
        for(char[] row:board) Arrays.fill(row,'.');
      backtrack(0,n,board);
      return res;  
    }

    private void backtrack(int idx,int n,char[][]board)
    {
        if(idx==n)
        {
            List<String>copy=new ArrayList<>();
            for(char[] row:board) copy.add(new String(row));
            res.add(copy);
            return;
        }

        for(int i=0;i<n;i++)
        {
            int pd=idx+i,nd=idx-i+n-1;
            if(col[i] || pos[pd] || neg[nd]) continue;
            col[i] = pos[pd] = neg[nd]=true;
            board[idx][i]='Q';
            backtrack(idx+1,n,board);
            board[idx][i]='.';
            col[i] = pos[pd] = neg[nd]=false;
        }
    }
}
