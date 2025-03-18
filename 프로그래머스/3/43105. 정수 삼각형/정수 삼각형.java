import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            dp[i][0] = triangle[i][0] + dp[i -1][0];
            for(int k = 1; k < i + 1; k++) {
                dp[i][k] = Math.max(dp[i -1][k], dp[i - 1][k -1]) + triangle[i][k];
            } 
        }
        
        return Arrays.stream(dp[triangle.length - 1]).max().getAsInt();
    }
}