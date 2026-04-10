class Solution {
    public boolean topoSort(ArrayList<ArrayList<Integer>> graph,int inDegree[]){
        ArrayList<Integer> topoList=new ArrayList<>();

        Queue<Integer> q=new ArrayDeque<>();       
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur=q.poll();
            topoList.add(cur);
            for(int adj:graph.get(cur)){
                inDegree[adj]--;
                if(inDegree[adj]==0){
                    q.add(adj);
                }
            }
        }

        if(graph.size()==topoList.size()){
            return true;
        }
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0],v=prerequisites[i][1];
            graph.get(u).add(v);
        }
        int inDegree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][1]]++;
        }
        return topoSort(graph,inDegree);
    }
}