class Solution {
    public void dijkstras(int[][] grid,int dis[][]){
        int dx[]={0,0,-1,1,1,1,-1,-1};
        int dy[]={1,-1,0,0,1,-1,-1,1};
        int n=grid.length;
        Queue<int[]> pq=new ArrayDeque<>();
        //dis,ith row,jth col 
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int cur[]=pq.poll();
            int d=cur[0],i=cur[1],j=cur[2];
            
            for(int k=0;k<8;k++){
                int nextRow=dx[k]+i;
                int nextCol=dy[k]+j;
               
                if(nextRow>=0 && nextCol>=0 && nextRow<n && nextCol<n && grid[nextRow][nextCol]==0 && (d+1<dis[nextRow][nextCol])){
                    dis[nextRow][nextCol]=d+1;
                    pq.add(new int[]{d+1,nextRow,nextCol});
                }
               
                
                }
            }
        }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int[][] dis=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        dis[0][0]=0;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0){
            return -1;
        }
        dijkstras(grid,dis);
        if(dis[n-1][n-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dis[n-1][n-1]+1;

    }
}