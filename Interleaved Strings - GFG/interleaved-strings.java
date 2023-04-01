//{ Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}


// } Driver Code Ends
class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
	    Boolean[][]dp = new Boolean[a.length() + 1][b.length() + 1];
            return solve(a, b, c, 0, 0, dp);
	}
	
	boolean solve(String a, String b, String c, int i, int j, Boolean[][]dp) {
	    if(i == a.length() && j == b.length()) return true;
	    
	    if(dp[i][j] != null) return dp[i][j];
	    
	    if(i < a.length() && j < b.length()) {
	        if(a.charAt(i) == b.charAt(j) && a.charAt(i) == c.charAt(i + j)) {
	            return dp[i][j] =  solve(a, b, c, i + 1, j, dp) || solve(a, b, c, i,j + 1,  dp);
	        }
	    }
	    
	    if(i < a.length() && c.charAt(i + j) == a.charAt(i)) return dp[i][j] = solve(a, b, c, i + 1, j, dp);
	    else if(j < b.length() && c.charAt(i + j) == b.charAt(j)) return dp[i][j] = solve(a, b, c, i,j + 1,dp);
	    else return dp[i][j] = false;
	}
}

