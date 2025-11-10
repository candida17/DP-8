// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//As we see recurring subproblems of recalculating the difference for each subseqence we can go with dynamic programming
//for the 3rd element in the sequence if the difference with previous two is same then its value is previous dp value plus 1 else if no matching diff value of that element is 0
//return the sum of all values calculated

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res= 0;
        for(int i = 2; i < n; i++) {
            //check the diff
            if((nums[i-1] - nums[i]) == (nums[i-2]-nums[i-1])) {
                dp[i] = dp[i-1]+1;
                res += dp[i];
            } else {
                dp[i] = 0;
            }
        }
        return res;
        
    }
}
