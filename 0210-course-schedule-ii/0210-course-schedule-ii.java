class Solution 
{
    public void topoSort(ArrayList<ArrayList<Integer>> graph,int inDegree[],ArrayList<Integer> li){
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){ 
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            li.add(cur);
            for(int adj:graph.get(cur)){
                inDegree[adj]--;
                if(inDegree[adj]==0){
                    q.add(adj);
                }
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0],v=prerequisites[i][1];
            graph.get(v).add(u);
        }
        ArrayList<Integer> li=new ArrayList<>();
        int inDegree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]++;
        }
        topoSort(graph,inDegree,li);
        System.out.println(li.size());
        if(li.size()==numCourses){ 
        int courseOrder[]=new int[li.size()];
        for(int i=0;i<li.size();i++){
            courseOrder[i]=li.get(i);
        }
        return courseOrder;
        }
        return new int[]{};
    }
}