class Solution {
    private static final int[][]dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int time=0,fresh=0;
        Queue<Integer>q=new ArrayDeque<>();
        for(int r=0;r<row;r++)
          for(int c=0;c<col;c++)
             if(grid[r][c]==2)q.offer(r*col+c);
             else if(grid[r][c]==1)fresh++;


      if(fresh==0) return 0;
      while(!q.isEmpty())
      {
        int size=q.size();
        boolean rottonAtThattime=false;
        while(size-->0)
        {
            int curr=q.poll();
            int r=curr/col,c=curr%col;
            for(int []d:dir)
            {
                int nr=r+d[0],nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<row && nc<col && grid[nr][nc]==1)
                {
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(nr*col+nc);
                    rottonAtThattime=true;
                }
            }
        }
        if(rottonAtThattime)time++;
      }
      return (fresh==0)?time:-1;
    }
}
