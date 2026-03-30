class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[]out=new int[n-k+1];
        Deque<Integer>dq=new ArrayDeque<>();
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(!dq.isEmpty() && dq.peekFirst()<=i-k) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])dq.pollLast();
            dq.offerLast(i);
            if(i>=k-1)
            {
                out[j++]=nums[dq.peekFirst()];
            }
        }
        return out;
    }
}
