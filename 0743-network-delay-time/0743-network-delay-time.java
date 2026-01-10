class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       // ArrayList<int[]> adj[]=new ArrayList<>();
        int dist[]=new int[n+1];
        ArrayList<int[]> adj[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj[u].add(new int[]{v,w});
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparing(a->a[0]));
        pq.add(new int[]{0,k});
        dist[k]=0;
        while(!pq.isEmpty()){
            int[] x=pq.poll();
            int d=x[0],node=x[1];
            if(d>dist[node]){continue;}
            for(int p[]:adj[node]){
                int tot=d+p[1];
                if(tot<dist[p[0]]){
                    dist[p[0]]=tot;
                    pq.add(new int[]{tot,p[0]});
                }
            }
        }
        int max=-1,c=0;
        for(int i=1;i<=n;i++){
            if(dist[i]<Integer.MAX_VALUE){
                c++;
            }
            if(max<dist[i]){
                max=dist[i];
            }
        }
        for(int i=0;i<=n;i++){
            System.out.print(dist[i]+" ");
        }
        if(c==n){
            return max;
        }
        return -1;
    }
}