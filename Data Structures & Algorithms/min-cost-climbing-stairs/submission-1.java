class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int one=cost[0],two=cost[1];

        for(int i=2;i<n;i++){
            int curr=cost[i]+Math.min(one,two);
            one=two;
            two=curr;
        }
        return Math.min(one,two);
    }
}
