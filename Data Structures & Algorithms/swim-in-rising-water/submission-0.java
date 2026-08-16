class Solution {
    private static final int[][]DIR={{1,0},{0,1},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        // this is the dijkstra algorithm;
        if(grid==null || grid.length==0 || grid[0].length==0)return -1;
        int n=grid.length;
        int[][]dist=new int[n][n];
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int[]r:dist)
         Arrays.fill(r,Integer.MAX_VALUE);
        dist[0][0]=grid[0][0];
        pq.offer(new int[]{grid[0][0],0});
        while(!pq.isEmpty())
        {
            int[] cord=pq.poll();
            int wt=cord[0],r=cord[1]/n,c=cord[1]%n;
            if(r==n-1 && c==n-1)return wt;
            if(wt>dist[r][c]) continue;
            for(int[]d:DIR)
            {
                int nr=r+d[0],nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<n)
                {
                  //  int candidate=wt+grid[nr][nc]; this is for normal but here we need to find best possible way so
                  int candidate=Math.max(wt,grid[nr][nc]);
                    if(candidate<dist[nr][nc])
                    {
                        dist[nr][nc]=candidate;
                        pq.offer(new int[]{candidate,nr*n+nc});
                    }
                }
            }
        }
        return -1;
    }
}
