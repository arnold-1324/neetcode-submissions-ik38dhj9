class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int n:nums)set.add(n);
        int len=0;
        for(int n:set)
        {
            if(!set.contains(n-1))
            {
                int curr=n;
                int Currlen=1;
                while(set.contains(curr+1))
                {
                    curr+=1;
                    Currlen++;
                }
                len=Math.max(Currlen,len);
            }
        }
        return len;
    }
}
