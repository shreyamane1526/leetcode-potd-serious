class Solution {
    public int earliestFinishTime(int[] landStartTime,int[] landDuration,int[] waterStartTime,int[] waterDuration){
        return (int)Math.min(
            solve(landStartTime,landDuration,waterStartTime,waterDuration),
            solve(waterStartTime,waterDuration,landStartTime,landDuration)
        );
    }
    private long solve(int[] s1,int[] d1,int[] s2,int[] d2) {
        int n=s2.length;
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++) {
            a[i][0]=s2[i];
            a[i][1]=d2[i];
        }
        Arrays.sort(a,(x,y)->x[0]-y[0]);
        int[] start=new int[n];
        long[] pre=new long[n];
        long[] suf=new long[n];
        for(int i=0;i<n;i++) {
            start[i]=a[i][0];
            pre[i]=(i==0)?a[i][1]:Math.min(pre[i-1],a[i][1]);
        }
        for(int i=n-1;i>=0;i--) {
            long v=(long)a[i][0]+a[i][1];
            suf[i]=(i==n-1)?v:Math.min(suf[i+1],v);
        }
        long ans=Long.MAX_VALUE;
        for(int i=0;i<s1.length;i++) {
            long t=(long)s1[i]+d1[i];
            int idx=upperBound(start,(int)t);

            if(idx>0) ans=Math.min(ans,t+pre[idx-1]);
            if(idx<n) ans=Math.min(ans,suf[idx]);
        }

        return ans;
    }
    private int upperBound(int[] a,int x) {
        int l=0,r=a.length;

        while(l<r) {
            int m=(l+r)>>>1;

            if(a[m]<=x) l=m+1;
            else r=m;
        }

        return l;
    }
}