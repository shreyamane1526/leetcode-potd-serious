class Solution {
    public static void BFS(int[][] isConnected,int n,int vis[],int i){
        Queue<Integer> q=new ArrayDeque<>();
        q.add(i);
        while(!q.isEmpty()){
            int p=q.poll();
            for(int j=0;j<n;j++){
                if(j!=p && isConnected[j][p]==1 && vis[j]==0){
                    vis[j]=1;
                    q.add(j);
                }
                else if(j!=p && isConnected[p][j]==1 && vis[j]==0){
                    vis[j]=1;
                    q.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int vis[]=new int[n];
        Arrays.fill(vis,0);
        int c=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                vis[i]=1;
                c++;
                BFS(isConnected,n,vis,i);
            }
        }
        return c;
    }
}