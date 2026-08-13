class Solution {
    private static final int[][]DIR={{1,0},{0,1},{-1,0},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<Integer>q=new LinkedList<>();
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    q.add(i*n+j);
                }
            }
        }
        if(q.size()==0) return;
       while(!q.isEmpty())
       {
         int node=q.poll();
         int r=node/n,c=node%n;
         for(int[]d:DIR)
         {
            int nr=r+d[0],nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==Integer.MAX_VALUE)
            {
                q.add(nr*n+nc);
                grid[nr][nc]=grid[r][c]+1;
            }
         }
       }
    }
}
