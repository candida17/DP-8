// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//We start off with top of triangle and recurse all the way down
//At next row we check the minimum beteween the current column and next column and add it up with the current row and column value

class Solution {
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        this.memo = new int[n][n];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j < n;j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return helper(triangle, 0, 0);
    }

    private int helper(List<List<Integer>> triangle, int row, int col) {
        //base
        if(row == triangle.size()) return 0;
        if(memo[row][col] != Integer.MIN_VALUE) return memo[row][col];
        //logic
        int c1 = helper(triangle, row+1, col);
        int c2 = helper(triangle, row+1, col+1);
        int res = triangle.get(row).get(col) + Math.min(c1, c2);
        memo[row][col] = res;
        return res;
    }
}
