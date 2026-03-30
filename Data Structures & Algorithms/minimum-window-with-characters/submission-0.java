class Solution {
    public String minWindow(String s, String t) {
        int[] hash=new int[256];
        int startidx=-1,l=0,cnt=0,r=0,min=Integer.MAX_VALUE;
        for(char c:t.toCharArray())hash[c]++;
        while(r<s.length())
        {
            char c=s.charAt(r);
            if(hash[c]>0) cnt++;
            hash[c]--;
            while(cnt==t.length())
            {
                int len=r-l+1;
                if(len<min)
                { 
                    min=len; startidx=l;
                }
                char lchar=s.charAt(l);
                hash[lchar]++;
                if(hash[lchar]>0) cnt--;
                l++;
            }
            r++;
        }
        return startidx==-1?"":s.substring(startidx,startidx+min);
    }
}
