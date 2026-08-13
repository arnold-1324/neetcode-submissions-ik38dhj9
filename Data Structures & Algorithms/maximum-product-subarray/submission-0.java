class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0],min=nums[0],res=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int n=nums[i];
            if(n<0)
            {
                int temp=max;
                max=min;
                min=temp;
            }
            max=Math.max(n,n*max);
            min=Math.min(n,n*min);
            res=Math.max(res,max);
        }
        return res;
    }
}
