class Solution {
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void moveZeroes(int[] arr) {
        int j=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                swap(arr,i,j);
                j++;
            }
        }
    }
}