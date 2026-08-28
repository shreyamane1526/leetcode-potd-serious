class Solution {
    public String convert(String s, int numRows) {
        int num=numRows*2-2;
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        if(numRows==1){
            return s;
        }
        for(int i=0;i<numRows;i++){
            boolean odd=true;
            int o=num-i*2;
            int e=i*2;
            if(e==0){
                e=o;
            }
            if(o==0){
                o=e;
            }
            for(int j=i;j<n;j++){
                sb.append(s.charAt(j));
                if(!odd){
                    odd=true;
                    j+=e;
                }
                else{
                    odd=false;
                    j+=o;
                }
                if(j>=n){
                    break;
                }
                j--;
            }
        }
        return sb.toString();
    }
}