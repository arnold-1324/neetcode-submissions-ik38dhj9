class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int c1=roblinearhouse(nums,0,n-2);
        int c2=roblinearhouse(nums,1,n-1);
        return Math.max(c1,c2);
    }

    int roblinearhouse(int[] nums,int start,int end)
    {
        int house1=0,house2=0;
        for(int i=start;i<=end;i++)
        {
            int currHouse=Math.max(house2,house1+nums[i]);
           house1=house2;
           house2=currHouse;
        }
        return house2;
    }
}
