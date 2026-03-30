class MedianFinder {
    PriorityQueue<Integer>cutAMax;
    PriorityQueue<Integer>cutBMin;

    public MedianFinder() {
        cutAMax=new PriorityQueue<>((a,b)-> b-a);
        cutBMin=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        cutAMax.offer(num);
        cutBMin.offer(cutAMax.poll());
        if(cutBMin.size()>cutAMax.size())cutAMax.offer(cutBMin.poll());
    }
    
    public double findMedian() {
        if(cutAMax.size()>cutBMin.size()) return (double) cutAMax.peek();
        return (cutAMax.peek()+cutBMin.peek())/2.0;
    }
}
