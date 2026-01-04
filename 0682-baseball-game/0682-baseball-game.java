class Solution {
    public int calPoints(String[] operations) {
        int sum=0;
        int a=0,b=0;
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<operations.length;i++){
            if(operations[i].charAt(0)=='+'){
                li.add(li.get(li.size()-1)+li.get(li.size()-2));
            }
            else if(operations[i].charAt(0)=='D'){
                li.add(li.get(li.size()-1)*2);
            }
            else if(operations[i].charAt(0)=='C'){
                li.remove(li.get(li.size()-1));
            }
            else{
                int x=Integer.parseInt(operations[i]);
                li.add(x);
            }
        }
        for(int i=0;i<li.size();i++){
            sum+=li.get(i);
        }
        return sum;
    }
}