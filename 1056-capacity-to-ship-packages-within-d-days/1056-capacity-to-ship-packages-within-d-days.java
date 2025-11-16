class Solution {
    public static int canComplete(int[] arr,int days,int mid){
        int sum=0;
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(sum<mid){
                sum+=arr[i];
            }           
            if(sum>=mid){          
                c++;
            }  
            if(sum>mid){
                sum=arr[i];
            }
            else if(sum==mid){sum=0;}       
        }
        if(sum!=0){
            c++;
        }
        if(c<=days){return 1;}
        return 0;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int min=weights[0];
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(min<weights[i]){
                min=weights[i];
            }
        }
        int max=sum;
        int l=min,r=sum;int ans=sum;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canComplete(weights,days,mid)==1){
                ans=mid;
                r=mid-1;
            }
            else if(canComplete(weights,days,mid)==0){
                l=mid+1;
            }
        }
        return ans;
    }
}