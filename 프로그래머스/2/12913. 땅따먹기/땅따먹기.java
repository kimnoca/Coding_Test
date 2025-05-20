import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        
        return answer(land, land.length);
    }
    
    int answer(int result[][], int n) {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(result[n - 1][i], max);
        }
        return max;
    }
}


