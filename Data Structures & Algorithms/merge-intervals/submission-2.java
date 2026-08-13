class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]>output=new ArrayList<>();
        output.add(intervals[0]);
        int n=intervals.length;
        for(int i=0;i<n;i++)
        {
            int end=intervals[i][1];
            int lastend=output.get(output.size()-1)[1];
            if(intervals[i][0]<=lastend){
                output.get(output.size()-1)[1]=Math.max(lastend,end);
            }else{
                output.add(intervals[i]);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
