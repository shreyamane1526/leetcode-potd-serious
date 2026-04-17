class Solution {   
    public int countPaths(int n, int[][] roads) {
       int start=0,end=n-1;
       long dis[]=new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        int ways[]=new int[n];
        Arrays.fill(ways,0);
        ways[start]=1;
        dis[start]=0;
        ArrayList<ArrayList<int[]>> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0],v=roads[i][1],w=roads[i][2];
            li.get(u).add(new int[]{v,w});
            li.get(v).add(new int[]{u,w});
        }

       PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
      pq.add(new long[]{0,start});

      while(!pq.isEmpty()){
        long cur[]=pq.poll();
        int node=(int)cur[1];long d=cur[0];
        if(d>dis[node]){
            continue;
        }
        for(int adj[]:li.get(node)){
            if(d+adj[1]<dis[adj[0]]){
                dis[adj[0]]=d+adj[1];
                ways[adj[0]]=ways[node];
                pq.add(new long[]{dis[adj[0]],adj[0]});
            }
            else if(d+adj[1]==dis[adj[0]]){               
            ways[adj[0]]=(ways[adj[0]]+ways[node])%1000000007;
            }
        }
      }
      return ways[n-1]%1000000007;
    }
}