class Solution {
    private static final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
         int area=0;
          for(int r=0;r<row;r++)
              for(int c=0;c<col;c++)
                 if(grid[r][c]!=0)
                  {
                    area=Math.max(dfs(grid,r,c,row,col),area);
                  }
        
       return area;
    }

    private int dfs(int[][]grid,int r,int c,int row ,int col)
    {
        if(r<0 || c<0 || r>=row || c>=col || grid[r][c]==0) return 0;
        int res=1;
        grid[r][c]=0;
        for(int[] d:dir)
           res+=dfs(grid,r+d[0],c+d[1],row,col);
        
        return res;
    }
}
