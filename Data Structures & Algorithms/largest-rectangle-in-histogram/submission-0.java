class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] stack=new int[n];
        int[] prev=new int[n];
        int[] next=new int[n];
        int top=-1,maxarea=0;
        for(int i=0;i<n;++i)
        {
            while(top>=0 && heights[stack[top]]>=heights[i]) top--;
            prev[i]=(top==-1)?-1:stack[top];
            stack[++top]=i;
        }
        top=-1;
        for(int i=n-1;i>=0;--i)
        {
            while(top>=0 && heights[stack[top]]>heights[i]) top--;
            next[i]=(top==-1) ?n:stack[top];
            stack[++top]=i;
        }
        for(int i=0;i<n;i++)
        {
            int w=next[i]-prev[i]-1;
            int area=heights[i]*w;
            maxarea=Math.max(maxarea,area);
        }
        return maxarea;
    }
}
