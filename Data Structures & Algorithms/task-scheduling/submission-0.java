class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>freq=new HashMap<>();
        for(char c:tasks)freq.put(c,freq.getOrDefault(c,0)+1);
        int maxfreq=Integer.MIN_VALUE;
        for(int x:freq.values())
           maxfreq=Math.max(maxfreq,x);
        int cntMax=0;
        for(int x:freq.values())
        {
            if(maxfreq==x)cntMax++;
        }
        int res=(maxfreq-1)*(n+1)+cntMax;
        return Math.max(tasks.length,res);
    }
}
