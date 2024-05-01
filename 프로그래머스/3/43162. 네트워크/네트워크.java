class Solution {
    boolean[][] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        
        for (int i = 0 ; i < n; i ++) {
            for (int k = 0; k < n ; k ++) {
                if (computers[i][k] == 1 && visited[i][k] == false) {
                    answer ++;
                    dfs(i, k ,computers, n);
                }
            }
        }
        
        return answer;
    }
    public void dfs(int x, int y, int[][] computers, int n) {
        visited[x][y] = true;
        
        for (int i = 0 ; i < n ; i++) {
            if (computers[y][i] == 1 && !visited[y][i]) {
                System.out.println(y + "," + i);
                dfs(y, i, computers, n);
            }
        }
        
    }
}