class Solution {
    List<String> ans=new ArrayList<>();
    void backtrack(String num,int target,int idx,long value,long prev,StringBuilder sb){
        if(idx==num.length()){
            if(value==target){
                ans.add(sb.toString());
            }
            return;
        }
        long curr=0;
        int len=sb.length();
        for(int i=idx;i<num.length();i++){
            if(i>idx && num.charAt(idx)=='0'){
                break;
            }
            curr=curr*10+(num.charAt(i)-'0');
            if(idx==0){
                sb.append(curr);
                backtrack(num,target,i+1,curr,curr,sb);
                sb.setLength(len);
            }else{
                sb.append("+").append(curr);
                backtrack(num,target,i+1,value+curr,curr,sb);
                sb.setLength(len);
                sb.append("-").append(curr);
                backtrack(num,target,i+1,value-curr,-curr,sb);
                sb.setLength(len);
                sb.append("*").append(curr);
                backtrack(num,target,i+1,value-prev+prev*curr,prev*curr,sb);
                sb.setLength(len);
            }
        }
    }
    public List<String> addOperators(String num,int target){
        backtrack(num,target,0,0,0,new StringBuilder());
        return ans;
    }
}