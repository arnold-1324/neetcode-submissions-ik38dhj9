class Solution {
    private int row,col;
    private Set<String> path;
    public boolean exist(char[][] board, String word) {
       row=board.length;
       col=board[0].length;
       path=new HashSet<>();
       HashMap<Character,Integer>cnt=new HashMap<>();
       for(int i=0;i<word.length();i++)
         cnt.put(word.charAt(i),cnt.getOrDefault(word.charAt(i),0)+1);
        
        if(cnt.getOrDefault(word.charAt(0),0)>cnt.getOrDefault(word.charAt(word.length()-1),0))
           word=new StringBuilder(word).reverse().toString();
        
        for(int r=0;r<row;r++)
           for(int c=0;c<col;c++)
              if(dfs(r,c,board,0,word)) return true;
    
      return false;
    }
    private boolean dfs(int r,int c,char[][] board,int k,String word)
    {
        if(k==word.length()) return true;
        if(r<0 || c<0 || r>=row || c>=col || path.contains(r+","+c) || board[r][c]!=word.charAt(k))
           return false;
        path.add(r+","+c);
        boolean res=dfs(r+1,c,board,k+1,word)||
                    dfs(r-1,c,board,k+1,word)||
                    dfs(r,c+1,board,k+1,word)||
                    dfs(r,c-1,board,k+1,word);
        path.remove(r+","+c);
        return res;
    }

    
}
