class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>res=new ArrayList<>();
        backtrack(0,nums,target,res,new ArrayList<>());
        return res;
    }


    private void backtrack(int idx,int[] nums,int target,List<List<Integer>> res,List<Integer>curr)
    {
        
            if(target==0) {
                res.add(new ArrayList<>(curr));
            return;
            }
        
        if(target<0 || idx>=nums.length) return;

        backtrack(idx+1,nums,target,res,curr);
        if(nums[idx]<=target){
            curr.add(nums[idx]);
            backtrack(idx,nums,target-nums[idx],res,curr);
            curr.remove(curr.size()-1);
        }
    }
}
