class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int n:nums)
          if(!set.add(n)) 
            return true;
        
     return false;
    }
}