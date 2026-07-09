class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(distance(b),distance(a)));
        for(int[] point:points){
            if(maxHeap.size()<k){
                maxHeap.offer(point);
            } 
            else{
                if(distance(point)<distance(maxHeap.peek())){
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }
        int[][] ans=new int[k][2];
        int index=0;
        while(!maxHeap.isEmpty()){
            ans[index++]=maxHeap.poll();
        }
        return ans;
    }
    int distance(int[] point) {
        return point[0]*point[0]+point[1]*point[1];
    }
}