class Solution {
    public int countComponents(int n, int[][] edges) {
       List<Integer>[]adj=new ArrayList[n];
       boolean[] vis=new boolean[n];
       for(int i=0;i<n;i++)adj[i]=new ArrayList<>();
       for(int []edg:edges)
       {
         adj[edg[0]].add(edg[1]);
         adj[edg[1]].add(edg[0]);
       }
       int res=0;
       for(int node=0;node<n;node++)
       {
          if(!vis[node])
            {
                dfs(adj,vis,node);
                res++;
            }
       }
       return res;
    }
    private void dfs(List<Integer>[] adj,boolean[] vis,int node)
    {
        vis[node]=true;
        for(int nei:adj[node])
        {
            if(!vis[nei]) dfs(adj,vis,nei);
        }
    }
}
