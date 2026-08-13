class Solution {
    static class Disjoint{
        int[]parent,rank;
        Disjoint(int n)
        {
            parent=new int[n+1];
            rank=new int[n+1];
            for(int i=0;i<n;i++)
               parent[i]=i;
        }
        private int findUPar(int node)
        {
            if(parent[node]==node)return node;
            return parent[node]=findUPar(parent[node]);
        }
        private boolean Union(int u,int v)
        {
            int pu=findUPar(u),pv=findUPar(v);
            if(pu==pv) return false;
            if(rank[pu]<rank[pv])
            {
                parent[pu]=pv;
            }else if(rank[pv]<rank[pu])
            {
                parent[pv]=pu;
            }else
            {
                parent[pv]=pu;
                rank[pu]++;
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        Disjoint ds=new Disjoint(n);
        List<int[]>edg=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
               int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edg.add(new int[]{dist,i,j});
            }
        }
        edg.sort((a,b)->Integer.compare(a[0],b[0]));
        int res=0;
        for(int[] ed:edg)
        {
            if(ds.Union(ed[1],ed[2]))
            {
                res+=ed[0];
            }
        }
        return res;
    }
}
