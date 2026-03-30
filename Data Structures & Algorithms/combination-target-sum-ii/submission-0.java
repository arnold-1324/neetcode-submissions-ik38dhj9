class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,res,new ArrayList<>());
        return res;
    }

    private void backtrack(int idx,int[] nums,int target,List<List<Integer>> res,List<Integer>curr)
    {
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;
            curr.add(nums[i]);
            backtrack(i+1,nums,target-nums[i],res,curr);
            curr.remove(curr.size()-1);
        }
    }
}
