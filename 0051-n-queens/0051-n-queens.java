class Solution {
    boolean isPresentCol(int row,int col,List<String> temp){
        int len=temp.size();
        for(int i=0;i<len;i++){
            if(temp.get(i).charAt(col)=='Q'){
                return true;
            }
        }
        return false;
    } 
    boolean isPresentDiag(int row,int col,List<String> temp,int n){
        int tempR=temp.size()-1,tempC=col+1;
        while(tempR>=0 && tempC<n){
            if(temp.get(tempR).charAt(tempC)=='Q'){
                return true;
            }
            tempR--;
            tempC++;
        }      
        tempR=temp.size()-1;tempC=col-1;
        while(tempR>=0 && tempC>=0){
            if(temp.get(tempR).charAt(tempC)=='Q'){
                return true;
            }
            tempR--;
            tempC--;
        }
        return false;
    }
    void backtrack(List<List<String>> ans,List<String> temp,StringBuilder sb,int row,int n){
        if(row==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(row!=0 && (isPresentCol(row,i,temp) || isPresentDiag(row,i,temp,n))){
                continue;
            }
            sb.setCharAt(i,'Q');
            temp.add(sb.toString());
            sb.setCharAt(i,'.');
            backtrack(ans,temp,sb,row+1,n);
            temp.remove(temp.size()-1);
            
        }

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append('.');
        }
        backtrack(ans,temp,sb,0,n);
        return ans;
    }
}