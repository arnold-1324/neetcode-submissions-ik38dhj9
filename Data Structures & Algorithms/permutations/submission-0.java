class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        backtrack(0,nums,res);
        return res;
    }
    private void backtrack(int idx,int[] nums,List<List<Integer>> res)
    {
        if(idx==nums.length)
        {
           List<Integer>temp=new ArrayList<>();
           for(int n:nums)temp.add(n);
           res.add(temp);
        }
       
        for(int i=idx;i<nums.length;i++)
        {
            swap(nums,idx,i);
            backtrack(idx+1,nums,res);
            swap(nums,i,idx);
        }
    }
    private void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
