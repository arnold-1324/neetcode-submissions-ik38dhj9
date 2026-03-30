class Solution {
    private static final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int row=board.length,col=board[0].length;
        boolean[][]vis=new boolean[row][col];

        for(int r=0;r<row;r++)
        {
            if(board[r][0]=='O') dfs(r,0,vis,board,row,col);
            if(board[r][col-1]=='O') dfs(r,col-1,vis,board,row,col);
        }


        for(int c=0;c<col;c++)
        {
            if(board[0][c]=='O') dfs(0,c,vis,board,row,col);
            if(board[row-1][c]=='O') dfs(row-1,c,vis,board,row,col);
        }

        for(int r=0;r<row;r++)
           for(int c=0;c<col;c++)
             if(!vis[r][c] && board[r][c]=='O')
             {
                vis[r][c]=true;
                board[r][c]='X';
             }
    }


    private void dfs(int r,int c,boolean[][] vis,char[][]board,int row,int col)
    {
        vis[r][c]=true;
        for(int []d:dir)
        {
            int nr=r+d[0],nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<row && nc<col && !vis[nr][nc] && board[nr][nc]=='O')
            {
                dfs(nr,nc,vis,board,row,col);
            }
        }
    }
}
