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
            for (int k = 0; k < SIZE; k++) {
                int max = 0;
                for (int j = 0; j < SIZE; j++) {
                    if(k == j) {
                        continue;
                    }
                    max = Math.max(result[i -1][j % SIZE], max);
                    result[i][k] = max + land[i][k]; 
                }
            }
        }
        
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


