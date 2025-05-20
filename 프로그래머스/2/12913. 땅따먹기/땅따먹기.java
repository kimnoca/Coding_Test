import java.util.*;

class Solution {
    static int SIZE = 4;
    int solution(int[][] land) {
        int answer = 0;
        int[][] result = new int[land.length][SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            result[0][i] = land[0][i]; 
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int k = 0; k < 4; k++) {
                int max = 0;
                for (int j = 0; j < 4; j++) {
                    if(k == j) {
                        continue;
                    }
                    max = Math.max(result[i -1][j % 4], max);
                    result[i][k] = max + land[i][k]; 
                }
            }
        }
        // 1 2 3 4
        // 10 11 12 11
        // 16 15 13 13
        
        return answer(result, land.length);
    }
    
    int answer(int result[][], int n) {
        int max = 0;
        for (int i = 0; i < SIZE; i++) {
            max = Math.max(result[n - 1][i], max);
        }
        return max;
    }
}


