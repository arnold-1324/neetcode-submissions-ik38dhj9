class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>>adj=new HashMap<>();
        for(List<String>ticket:tickets)
        {
            adj.computeIfAbsent(ticket.get(0),k->new PriorityQueue<>()).add(ticket.get(1));
        }
        LinkedList<String>res=new LinkedList<>();
        Stack<String>st=new Stack<>();
        st.push("JFK");
        while(!st.isEmpty())
        {
            String curr=st.peek();
            if(!adj.containsKey(curr) || adj.get(curr).isEmpty())
            {
                res.addFirst(st.pop());
            }else{
                st.push(adj.get(curr).poll());
            }
        }
        return res;
    }
}
