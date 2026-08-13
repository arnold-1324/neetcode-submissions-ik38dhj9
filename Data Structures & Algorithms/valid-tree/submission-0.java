class Solution {
    static class Disjoint{
        int[]parent,rank;
        int comps;
        Disjoint(int n)
        {
            parent=new int[n+1];
            rank=new int[n+1];
            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
             this.comps=n;
        }
        private int findUPar(int node)
        {
            if(parent[node]==node)return node;
            return parent[node]=findUPar(parent[node]);
        }
        private int component()
        {
            return comps;
        }
        private boolean Union(int u,int v)
        {
            int pu=findUPar(u),pv=findUPar(v);
            if(pu==pv)return false;
            if(rank[pu]<rank[pv])
            {
                parent[pu]=pv;
            }else if(rank[pv]<rank[pu])
            {
                parent[pv]=pu;
            }else{
                parent[pv]=pu;
                rank[pu]++;
            }
            comps--;
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
       if(edges.length>n-1)
            return false;
        Disjoint ds=new Disjoint(n);
        for(int[]ed:edges)
        {
            if(!ds.Union(ed[0],ed[1]))
                 return false;
        }
        return ds.component()==1;
    }
}
