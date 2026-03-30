class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int s:stones)
        {
            pq.offer(-s);
        }
        while(pq.size()>1)
        {
            int first=pq.poll();
            int sec=pq.poll();
            if(sec>first) pq.offer(first-sec);
        }
        pq.offer(0);
        return Math.abs(pq.peek());
    }
}
