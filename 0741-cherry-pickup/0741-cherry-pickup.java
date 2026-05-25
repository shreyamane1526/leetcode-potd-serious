class Solution {
    int recur(int[][] grid,int i,int j,int n){
        if(i==n-1 && j==n-1){
            int cur=grid[i][j];  
            grid[i][j]=0;     
            int temp=recurRev(grid,n-1,n-1,n);  
            grid[i][j]=cur;
            return cur+temp;
        }
        int r=Integer.MIN_VALUE,d=Integer.MIN_VALUE;
        if(j+1<n && grid[i][j+1]!=-1){
            int cur=grid[i][j];
            grid[i][j]=0;
            r=cur+recur(grid,i,j+1,n);
            grid[i][j]=cur;
        }
        if(i+1<n && grid[i+1][j]!=-1){
            int cur=grid[i][j];
            grid[i][j]=0;
            d=cur+recur(grid,i+1,j,n);
            grid[i][j]=cur;
        }
        return Math.max(r,d);
    }
    int recurRev(int[][] grid,int i,int j,int n){
        if(i==0 && j==0){
            int cur=grid[i][j];  
           // grid[i][j]=0;      
            return cur;
        }
        int r=Integer.MIN_VALUE,d=Integer.MIN_VALUE;
        if(j-1>=0 && grid[i][j-1]!=-1){
            int cur=grid[i][j];
            grid[i][j]=0;
            r=cur+recurRev(grid,i,j-1,n);
            grid[i][j]=cur;
        }
        if(i-1>=0 && grid[i-1][j]!=-1){
            int cur=grid[i][j];
            grid[i][j]=0;
            d=cur+recurRev(grid,i-1,j,n);
            grid[i][j]=cur;
        }
        return Math.max(r,d);
    }
    int twoAgents(int[][] grid,int r1,int c1,int r2,int c2,int n){
        if(r1==n-1 && c1==n-1){
            return grid[r1][c1];
        }
        int dd=Integer.MIN_VALUE,dr=dd,rr=dd,rd=dd;
        if(r1+1<n && r2+1<n && grid[r1+1][c1]!=-1 && grid[r2+1][c2]!=-1){
            dd=twoAgents(grid,r1+1,c1,r2+1,c2,n)+grid[r1][c1];
            if(r1!=r2 && c1!=c2){
                dd+=grid[r2][c2];
            }
        }
        if(r1+1<n && c2+1<n && grid[r1+1][c1]!=-1 && grid[r2][c2+1]!=-1){
            dr=twoAgents(grid,r1+1,c1,r2,c2+1,n)+grid[r1][c1];
            if(r1!=r2 && c1!=c2){
                dr+=grid[r2][c2];
            }
        }
        if(c1+1<n && c2+1<n && grid[r1][c1+1]!=-1 && grid[r2][c2+1]!=-1){
            rr=twoAgents(grid,r1,c1+1,r2,c2+1,n)+grid[r1][c1];
            if(r1!=r2 && c1!=c2){
                rr+=grid[r2][c2];
            }
        }
        if(c1+1<n && r2+1<n && grid[r1][c1+1]!=-1 && grid[r2+1][c2]!=-1){
            rd=twoAgents(grid,r1,c1+1,r2+1,c2,n)+grid[r1][c1];
            if(r1!=r2 && c1!=c2){
                rd+=grid[r2][c2];
            }
        }
        return Math.max(Math.max(dd,dr),Math.max(rd,rr));
    }
    //now 4 variables r1,r2,c1,c2 so dp[][][][]could be needed if u want to store the results,,,,but in this case as r1+c1=c2+r2 so only 3 variables can be used........
    int memoi(int[][] grid,int r1,int c1,int r2,int c2,int n,int dp[][][]){
        if(r1==n-1 && c1==n-1){
            return grid[r1][c1];
        }
        if(dp[r1][c1][c2]!=Integer.MAX_VALUE){
            return dp[r1][c1][c2];
        }
        int dd=Integer.MIN_VALUE,dr=dd,rr=dd,rd=dd;
        if(r1+1<n && r2+1<n && grid[r1+1][c1]!=-1 && grid[r2+1][c2]!=-1){
            dd=memoi(grid,r1+1,c1,r2+1,c2,n,dp)+grid[r1][c1];
            if(r1!=r2 && c1!=c2){
                dd+=grid[r2][c2];
            }
        }
        if(r1+1<n && c2+1<n && grid[r1+1][c1]!=-1 && grid[r2][c2+1]!=-1){
            dr=memoi(grid,r1+1,c1,r2,c2+1,n,dp)+grid[r1][c1];
            if(r1!=r2 && c1!=c2){
                dr+=grid[r2][c2];
            }
        }
        if(c1+1<n && c2+1<n && grid[r1][c1+1]!=-1 && grid[r2][c2+1]!=-1){
            rr=memoi(grid,r1,c1+1,r2,c2+1,n,dp)+grid[r1][c1];
            if(r1!=r2 && c1!=c2){
                rr+=grid[r2][c2];
            }
        }
        if(c1+1<n && r2+1<n && grid[r1][c1+1]!=-1 && grid[r2+1][c2]!=-1){
            rd=memoi(grid,r1,c1+1,r2+1,c2,n,dp)+grid[r1][c1];
            if(r1!=r2 && c1!=c2){
                rd+=grid[r2][c2];
            }
        }
        return dp[r1][c1][c2]=Math.max(Math.max(dd,dr),Math.max(rd,rr));
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        if(grid[n-1][n-1]==-1 || grid[0][0]==-1){
            return 0;
        }
        /*
        //recur backtracking
        int ans=recur(grid,0,0,n);
        if(ans<=0){
            return 0;
        }
        return ans;
        */


        /*
        // two agents recur
        int ans=twoAgents(grid,0,0,0,0,n);
        if(ans<=0){
            return 0;
        }
        return ans;
        */

        
        //tow agetns memoi
        int dp[][][]=new int[n][n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }
        int ans=memoi(grid,0,0,0,0,n,dp);
        if(ans<=0){
            return 0;
        }
        return ans;
    }
}