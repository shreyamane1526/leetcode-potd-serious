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
            size[parX]+=size[parY];
            par[parY]=parX;
        }
        else{
            size[parY]+=size[parX];
            par[parX]=parY; 
        }
    }
}
class Solution { 
    public int makeConnected(int n, int[][] connections) {
        int edges=connections.length;
        if(edges<(n-1)){
            return -1;
        }
        DSU dsu=new DSU(n);
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0],v=connections[i][1];
            if(dsu.find(u)!=dsu.find(v)){
                dsu.unionBySize(u,v);
            }
        }
        int components=0;
        for(int i=0;i<n;i++){
            if(dsu.par[i]==i){
                components++;
            }
        }
        return components-1;
    }
}