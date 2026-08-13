/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n=intervals.size();
        if(n<=1) return true;
        int[]start=new int[n];
        int[]end=new int[n];
        int i=0;
        for(Interval inter:intervals)
        {
            start[i]=inter.start;
            end[i]=inter.end;
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int last=end[0];
        for(int j=1;j<n;j++)
        {
            if(start[j]<last)
            {
                return false;
            }else
            {
                last=end[j];
            }
        }
        return true;
    }
}
