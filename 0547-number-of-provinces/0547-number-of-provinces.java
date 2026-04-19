class DSU{
    int par[],size[];
    DSU(int V){
        par=new int[V];
        size=new int[V];
        for(int i=0;i<V;i++){
            par[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        int cur=x;
        while(par[cur]!=cur){
            cur=par[cur];
        }
        return cur;
    }
    void unionBySize(int x,int y){
        int parX=find(x);
        int parY=find(y);
        if(parX==parY){
            return;
        }
        if(size[parX]>=size[parY]){
            par[parY]=parX;
            size[parX]+=size[parY];
        }
        else{
            par[parX]=parY;
            size[parY]+=size[parX];
        }
    }
}
class Solution {
    /**********====USING BFS=====******* 
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
    ********************/
    //using dsu
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int n=isConnected.length;
        DSU dsu=new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    dsu.unionBySize(i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dsu.par[i]==i){
                count++;
            }
        }
        return count;
    }
}