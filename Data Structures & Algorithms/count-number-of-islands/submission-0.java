class Solution {
    private static final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int cnt=0;
        for(int r=0;r<row;r++)
          for(int c=0;c<col;c++)
              if(grid[r][c]!='0') {
                   cnt++;
                  dfs(grid,r,c,row,col);
              }
        

        return cnt;
    }


    private void dfs(char[][]grid,int r,int c,int row,int col)
    {
        if(r<0 || c<0 || r>=row || c>=col) return;
        if(grid[r][c]!='1') return;
        grid[r][c]='0';
        for(int[]d:dir)
          dfs(grid,r+d[0],c+d[1],row,col);
    }
}
