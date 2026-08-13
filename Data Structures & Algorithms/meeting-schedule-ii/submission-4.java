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
    public int minMeetingRooms(List<Interval> intervals) {
     int n=intervals.size();
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
     int room=0,maxroom=0,endidx=0;
     for(int j=0;j<n;j++)
     {
        if(start[j]<end[endidx])
        {
            room++;
            maxroom=Math.max(maxroom,room);
        }else
        {
            endidx++;
        }
     }
     return maxroom;
    }
}
