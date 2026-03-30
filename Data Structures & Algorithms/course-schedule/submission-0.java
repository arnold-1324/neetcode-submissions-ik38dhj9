class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        int[] indegree=new int[numCourses];
        for(int[] ed:prerequisites)
        {
          adj.get(ed[0]).add(ed[1]);
          indegree[ed[1]]++;
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)
          if(indegree[i]==0) q.offer(i);
        
        int cnt=0;
        while(!q.isEmpty())
        {
            int node=q.poll();
            cnt++;
            for(int nei:adj.get(node))
            {
                if(--indegree[nei]==0)q.offer(nei);
            }
        }
        return (cnt==numCourses);
    }
}
