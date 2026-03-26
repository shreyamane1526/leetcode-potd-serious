class Solution {
    public void bfs(int isConnected[][],boolean vis[],int j){
        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.offer(j);
        vis[j]=true;
        while(!q.isEmpty()){
            int x=q.poll();
            for(int i=0;i<isConnected.length;i++){
                if(!vis[i] && isConnected[i][x]==1){
                    q.offer(i);
                    vis[i]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int n=isConnected.length;
        boolean vis[]=new boolean[n];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(isConnected,vis,i);
                count++;
            }
        }
        return count;
    }
}