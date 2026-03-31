class Disjoint{
    int[]size,parent,rank;
    Disjoint(int n){
        rank=new int [n+1];
        size=new int [n+1];
        parent=new int [n+1];
        for(int i=0;i<=n;i++)
        {
            parent[i]=i;
            size[i]=1;
        }
    }


    public int findUPar(int node)
    {
        if(node==parent[node]) return node;
        return parent[node]=findUPar(parent[node]);
    }

    public void UnionByRank(int u,int v)
    {
        int pu=findUPar(u),pv=findUPar(v);
        if(pu==pv) return ;
        if(rank[pu]<rank[pv])parent[pu]=pv;
        else if(rank[pv]<rank[pu]) parent[pv]=pu;
        else
        {
            parent[pv]=pu;
            rank[pu]++;
        }
    }

    public void UnionBySize(int u,int v)
    {
        int pu=findUPar(u),pv=findUPar(v);
        if(pv==pu) return;
        if(size[pu]<size[pv])
        {
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else if(size[pv]<size[pu])
        {
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Disjoint ds=new Disjoint(n);
        for(int [] ed:edges)
        {
            int u=ed[0],v=ed[1];
            if(ds.findUPar(u)==ds.findUPar(v)) return ed;
            ds.UnionByRank(u,v);
        }
        return new int[0];
    }
}
