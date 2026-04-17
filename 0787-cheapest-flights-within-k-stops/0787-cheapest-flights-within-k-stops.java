class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0],v=flights[i][1],w=flights[i][2];
            li.get(u).add(new int[]{v,w});
        }
        Queue<int[]> pq=new ArrayDeque<>();
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        pq.add(new int[]{src,0,0});
        while(!pq.isEmpty()){
            int cur[]=pq.poll();
            int node=cur[0],w=cur[1],step=cur[2];
            if(step>k){
                continue;
            } 
            for(int adj[]:li.get(node)){
                if(w+adj[1]<dis[adj[0]]){
                    dis[adj[0]]=w+adj[1];
                    pq.add(new int[]{adj[0],w+adj[1],step+1});
                }
            }
        }
        if(dis[dst]!=Integer.MAX_VALUE){
            return dis[dst];
        }
        return -1;
    }
}