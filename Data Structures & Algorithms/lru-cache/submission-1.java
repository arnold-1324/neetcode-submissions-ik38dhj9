class Node{
    public int key,val;
    public Node prev,next;
    Node(int key,int val)
    {
        this.key=key;
        this.val=val;
        this.prev=next=null;
    }
}


class LRUCache {
    private Map<Integer,Node>cache;
    private int cap;
    private Node left,right;
    public LRUCache(int capacity) {
        this.cap=capacity;
        this.cache=new HashMap<>();
        this.left=this.right=new Node(0,0);
        this.left.next=this.right;
        this.right.prev=this.left;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key))
        {
            Node node=cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key))
        {
           remove(cache.get(key));
        }
        Node node =new Node(key,value);
        cache.put(key,node);
        insert(node);
        if(cache.size()>cap)
        {
            Node lru=this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }

    }
 
    private void remove(Node node)
    {
        Node prev=node.prev,next=node.next;
        prev.next=next;
        next.prev=prev;
    }

    private void insert(Node node)
    {
        Node prev=this.right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=this.right;
        this.right.prev=node;
    }
}
