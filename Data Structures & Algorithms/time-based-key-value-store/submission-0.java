class TimeMap {
    private Map<String,List<Pair<Integer,String>>>keyStore;
    public TimeMap() {
        keyStore=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>>val=keyStore.getOrDefault(key,new ArrayList<>());
        int l=0,h=val.size()-1;
        String res="";
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(val.get(m).getKey()<=timestamp)
            {
                res=val.get(m).getValue();
                l=m+1;
            }else
            {
                h=m-1;
            }

        }
        return res;
    }


    private static class Pair<K,V>
    {
        private final K key;
        private final V value;
        Pair(K key, V value)
        {
            this.key=key;
            this.value=value;
        }

        public  K getKey() { return key;}
        public  V getValue() {return value;}
    }
}
