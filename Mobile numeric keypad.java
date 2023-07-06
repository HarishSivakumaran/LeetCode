//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.getCount(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution{
    int[][] grid = null;
    int[][] dir = {{0,0}, {0,1}, {1,0}, {0,-1}, {-1,0}};
    Long[][][] cache = null;
    
	public long getCount(int N){
		// Your code goes here
		grid = new int[][]{
		  {1, 2, 3},
		  {4, 5, 6},
		  {7, 8, 9},
		  {-1, 0, -1}
		};
		
		long ways = 0;
		
		cache = new Long[N+1][grid.length][grid[0].length];
		
		for(int r = 0; r < grid.length; r++){
		    for(int c = 0; c < grid[0].length; c++){
		        ways += getWays(N, r, c);
		    }
		}
		
		return ways;
		
	}
	
	private long getWays(int n, int r, int c){
	    if( r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1 ){ return 0;}
	    if(n == 1) return 1;
	    if(cache[n][r][c] != null) return cache[n][r][c];
	    
	    long ways = 0;
	    
	    for(int[] d : dir){
	        ways += getWays(n-1, r+d[0], c+d[1]);
	    }
	    
	    return cache[n][r][c] = ways;
	}
}
