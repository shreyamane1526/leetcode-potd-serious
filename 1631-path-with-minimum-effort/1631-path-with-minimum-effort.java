class Solution {
    /**************** 
    x0 0 0 ->
    x1 0 1 ->x2 1 0-> x0 0 2 -> 6 1 1->3 2 2->
    x2 0 2->x2 2 1 ->



    *****************/
    public int bfs(int[][] heights){
        int max=Integer.MAX_VALUE;
        int n=heights.length;
        int m=heights[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i],Integer.MAX_VALUE);
        }
        vis[0][0]=0;
      
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,0,0});
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int curMax=cur[0],i=cur[1],j=cur[2];
            for(int k=0;k<4;k++){
                int x=dx[k]+i,y=dy[k]+j;
                if(x>=0 && y>=0 && x<n && y<m){
                    int dif=Math.abs(heights[x][y]-heights[i][j]);
                    if(Math.max(dif,curMax)<vis[x][y]){
                        vis[x][y]=Math.max(dif,curMax);
                        pq.add(new int[]{Math.max(dif,curMax),x,y});
                    }
                }
            }
        }
        return vis[n-1][m-1];
    }
    public int minimumEffortPath(int[][] heights) {
        return bfs(heights);
    }
}