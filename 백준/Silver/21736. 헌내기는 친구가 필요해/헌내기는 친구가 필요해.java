import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] visited;
    static char[][] graph;

    static int n;
    static int m;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        visited = new boolean[n][m];
        graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int k = 0; k < m; k++) {
                graph[i][k] = input.charAt(k);
            }
        }

        answer = 0;

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if (graph[i][k] == 'I') {
                    startX = i;
                    startY = k;
                }
            }
        }

        visited[startX][startY] = true;
        dfs(startX, startY);

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    public static void dfs(int x, int y) {


        if (graph[x][y] == 'P') {
            answer++;
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (!visited[nx][ny] && graph[nx][ny] != 'X') {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}
