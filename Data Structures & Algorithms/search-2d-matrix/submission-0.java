class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int r=matrix.length;
        int c=matrix[0].length;
        int l=0,h=r*c-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            int row=m/c,col=m%c;
            if(target>matrix[row][col]) l=m+1;
            else if(target<matrix[row][col]) h=m-1;
            else return true;
        }
        return false;
    }
}
