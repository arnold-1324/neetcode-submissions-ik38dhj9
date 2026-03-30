class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        backtrack(0,nums,res,new ArrayList<>());
        return res;
    }
   
     private void backtrack(int idx,int[] nums,List<List<Integer>>res,List<Integer>curr)
     {
        if(idx==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        backtrack(idx+1,nums,res,curr);
        curr.remove(curr.size()-1);
        for(int i=idx+1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
              backtrack(i,nums,res,curr);
              return;
        }
        backtrack(nums.length,nums,res,curr);
     }

}
