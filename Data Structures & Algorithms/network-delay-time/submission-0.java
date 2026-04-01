class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       List<int[]>[] adj=new ArrayList[n];
       for(int i=0;i<n;i++)adj[i]=new ArrayList<>();
       for(int[] t:times)
       {
        adj[t[0]-1].add(new int[]{t[1]-1,t[2]});
       }
       int[] dist=new int[n];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[k-1]=0;
       PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
       pq.offer(new int[]{k-1,0});
       while(!pq.isEmpty())
       {
        int [] curr=pq.poll();
        int node=curr[0],nodeWt=curr[1];
         for(int[] nei:adj[node])
         {
            int neiNode=nei[0],neiWt=nei[1];
            int candidate=nodeWt+neiWt;
            if(candidate<dist[neiNode])
            {
                dist[neiNode]=candidate;
                pq.offer(new int[]{neiNode,candidate});
            }
         }
       }
       int res=0;
       for(int d:dist)
       {
        if(d==Integer.MAX_VALUE) return -1;
        res=Math.max(res,d);
       }
       return res;
    }
}
