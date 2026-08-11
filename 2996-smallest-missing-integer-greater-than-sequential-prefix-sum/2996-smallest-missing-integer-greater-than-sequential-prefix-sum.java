class Solution {
    public int missingInteger(int[] a) {
        int i=0;
        while(i+1<a.length && a[i+1]==a[i]+1){  i++;}
        int s=0;
        for(int j=0;j<=i;j++){ s+=a[j];}
        Set<Integer> st=new HashSet<>();
        for(int x:a){ st.add(x);}
        while(st.contains(s)){ s++;}
        return s;
    }
} 