class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)adj[i]=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int[] ed:prerequisites)
        {
            adj[ed[1]].add(ed[0]);
            indegree[ed[0]]++;  // incomming edges
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) 
           if(indegree[i]==0)q.offer(i);
        
        int[] res=new int[numCourses];
        int cnt=0;
        while(!q.isEmpty())
        {
            int node =q.poll();
            res[cnt++]=node;
            for(int nei:adj[node])
            {
                if(--indegree[nei]==0)q.offer(nei);
            }
        }
        if(numCourses!=cnt) return new int[0];
        
        return res;
    }
}
