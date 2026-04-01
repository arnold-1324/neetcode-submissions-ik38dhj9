class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       if(src==dst) return 0;
       List<int[]>[] adj=new ArrayList[n];
       for(int i=0;i<n;i++)adj[i]=new ArrayList<>();
       for(int[] f:flights)
       {
        adj[f[0]].add(new int[]{f[1],f[2]});
       }
       int[] dist=new int[n];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[src]=0;
       Queue<int[]>q=new ArrayDeque<>();
       q.offer(new int[]{src,0,0});  //srcnode , weight, step
       while(!q.isEmpty())
       {
          int[] curr=q.poll();
          int node=curr[0],nodeWt=curr[1],step=curr[2];
          if(step>k) continue;
          for(int [] nei:adj[node])
          {
             int neiNode=nei[0],neiWt=nei[1];
             int candidate=nodeWt+neiWt;
             if(candidate<dist[neiNode])
             {
                dist[neiNode]=candidate;
                q.offer(new int[]{neiNode,candidate,step+1});
             }
          }
       }
       if(dist[dst]==Integer.MAX_VALUE) return -1;
       return dist[dst];
    }
}
