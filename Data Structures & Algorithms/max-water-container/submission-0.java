class Solution {
    public int maxArea(int[] heights) {
     int maxlen=0;
     int l=0,r=heights.length-1;
     while(l<r)
     {
        maxlen=Math.max(maxlen,(r-l)*Math.min(heights[r],heights[l]));
        if(heights[l]<heights[r])
        {
            l++;
        }else
        {
            r--;
        }
     }   
     return maxlen;
    }
}
