class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][10];
boolean[][] col=new boolean[9][10];
boolean[][] box=new boolean[9][10];
       for(int r=0;r<9;r++)
       {
        for(int c=0;c<9;c++)
        {
            if(board[r][c]!='.')
            {
                int n=board[r][c]-'0';
                int boxIdx=(r/3)*3+(c/3);
                if(row[r][n] || col[c][n] || box[boxIdx][n]) return false;
                row[r][n]=col[c][n]=box[boxIdx][n]=true;
            }
        }
       }
       return true;
    }
}
