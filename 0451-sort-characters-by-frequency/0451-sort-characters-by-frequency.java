class Pair{
    char ch;
    int freq;
    Pair(char ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        Pair freq[]=new Pair[128];
        for(int i=0;i<128;i++){
            freq[i]=new Pair((char)i,0);
        }
        for(int i=0;i<n;i++){
            freq[s.charAt(i)].freq++;
        }
        Arrays.sort(freq,(p1,p2)->Integer.compare(p2.freq,p1.freq));
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<freq.length;i++){
            while(freq[i].freq>0){            
             sb.append(Character.toString(freq[i].ch));
             freq[i].freq--;
            }
        }
        return sb.toString();
    }
}