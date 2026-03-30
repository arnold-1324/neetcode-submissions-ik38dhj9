class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int n:nums)
          freq.put(n,freq.getOrDefault(n,0)+1);
        
        List<List<Integer>>bucket=new ArrayList<>();
        for(int i=0;i<nums.length+1;i++)
          bucket.add(new ArrayList<>());
        
        for(var e:freq.entrySet())
           bucket.get(e.getValue()).add(e.getKey());
        int[] res=new int[k];
        int idx=0;
        for(int i=bucket.size()-1;i>=0 && k>0;i--)
        {
           if(!bucket.get(i).isEmpty())
           {
            for(var val:bucket.get(i)){
                res[idx++]=val;
                k--;
                if(k==0)break;
            }
           }
        }
        return res;
           
    }
}
