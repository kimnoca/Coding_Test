import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int k = 0; k < n; k++) {
                graph[i][k] = input.charAt(k);
            }
        }
        int answer1 = 0;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (!visited[i][k]) {
                    answer1++;
                    dfs(i, k, graph[i][k]);
                }
            }
        }
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (graph[i][k] == 'G') {
                    graph[i][k] = 'R';
                }
            }
        }

        int answer2 = 0;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (!visited[i][k]) {
                    dfs(i, k, graph[i][k]);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    public static void dfs(int startX, int startY, char start) {

        visited[startX][startY] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (!visited[nx][ny]) {
                if (graph[nx][ny] == start) {
                    dfs(nx, ny, graph[nx][ny]);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
