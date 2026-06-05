
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> li=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            li.add(new ArrayList<>());
        }
        if(numRows>=1){
            li.get(0).add(1);
        }
        
        for(int i=1;i<numRows;i++){
            li.get(i).add(1);
            for(int k=1;k<i;k++){
                li.get(i).add(li.get(i-1).get(k)+li.get(i-1).get(k-1));
            }
            li.get(i).add(1);
        }
        return li;
    }
}