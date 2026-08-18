class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        boolean[]vis=new boolean[n+1];
        for(int num:nums)
        {
            vis[num]=true;
        }
        for(int i=0;i<vis.length;i++)
            if(!vis[i])
                return i;
        return -1;
    }
}
