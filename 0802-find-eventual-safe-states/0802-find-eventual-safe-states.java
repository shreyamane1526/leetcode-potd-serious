class Solution {
    public boolean dfs(int[][] graph,boolean vis[],boolean pathVis[],int start){
        pathVis[start]=true;
        vis[start]=true;
        for(int i=0;i<graph[start].length;i++){
            if(!vis[graph[start][i]]){
                if(dfs(graph,vis,pathVis,graph[start][i])){
                    return true;
                }
            }
            else if(pathVis[graph[start][i]]){
                return true;
            }
        }
        pathVis[start]=false;
        return false;
    }
    /****************************
    Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
    0-
    vis[0v,1v,2v,3v,4,5v]
    pathVis[0pv,1pv,3pv,pv,pv,,pv,]
Output: 
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
    
    *******************/
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean vis[]=new boolean[n];
        boolean pathVis[]=new boolean[n];
        Arrays.fill(vis,false);
        Arrays.fill(pathVis,false);
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(graph,vis,pathVis,i);
            }
        }
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!pathVis[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}