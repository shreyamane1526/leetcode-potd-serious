class Pair{
    String curWord;
    int num;
    Pair(String curWord,int num){
        this.curWord=curWord;
        this.num=num;
    }
}
class Solution {
    public static int bfs(String beginWord,String endWord,List<String> wordList){
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(beginWord,1));
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int curNum=temp.num;
            StringBuilder sb=new StringBuilder(temp.curWord);
            if(temp.curWord.equals(endWord)){
                return curNum;
            }
            for(int k=0;k<sb.length();k++){
                char c=sb.charAt(k);
                for(int i=0;i<26;i++){
                    sb.setCharAt(k,(char)('a'+i));
                    if(c=='a'+i){
                        continue;
                    }
                    if(set.contains(sb.toString())){
                        String s=sb.toString();
                        q.add(new Pair(s,curNum+1));
                        set.remove(s);
                       
                    }
                }
                sb.setCharAt(k,c);
            }
        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        return bfs(beginWord,endWord,wordList);
    }
}