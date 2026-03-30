class Solution {
    private static final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length,col=heights[0].length;
        boolean[][] pac=new boolean[row][col];
        boolean[][] atl=new boolean[row][col];

        for(int c=0;c<col;c++)
        {
            dfs(0,c,pac,heights);
            dfs(row-1,c,atl,heights);
        }
        for(int r=0;r<row;r++)
        {
            dfs(r,0,pac,heights);
            dfs(r,col-1,atl,heights);
        }

        List<List<Integer>>res=new ArrayList<>();
        for(int r=0;r<row;r++)
          for(int c=0;c<col;c++)
             if(pac[r][c] && atl[r][c]){
                 res.add(Arrays.asList(r,c));
             }
    

    return res;
    }

    private void dfs(int r,int c,boolean[][]Ocean,int[][]heights)
    {
        Ocean[r][c]=true;
        for(int[]d:dir)
        {
           int nr=r+d[0],nc=c+d[1];
           if(nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && !Ocean[nr][nc] && heights[nr][nc]>=heights[r][c])
            {
                dfs(nr,nc,Ocean,heights);
            }
        }
    }


}
