class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum=0,K=0,n=nums.length;
        for(int i:nums)totalsum+=i;
        if(totalsum%2==1) return false;
            K=totalsum/2;
            boolean[][] dp=new boolean[n][K+1];
            for(int i=0;i<n;i++)dp[i][0]=true;
            if(nums[0]<=K)dp[0][nums[0]]=true;

            for(int idx=1;idx<n;idx++)
            {
                for(int val=1;val<=K;val++)
                {
                    boolean notTaken=dp[idx-1][val];
                    boolean Taken=false;
                    if(nums[idx]<=val)Taken=dp[idx-1][val-nums[idx]];
                    dp[idx][val]=notTaken || Taken;
                }
            }
        
        return dp[n-1][K];
    }
}
