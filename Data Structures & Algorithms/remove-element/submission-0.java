class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
           if(i<nums.length && nums[i]==val)continue;
           else {
            nums[k]=nums[i];
            k++;
           }
        }
        return k;
    }
}