import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);

        String[][] graph = new String[n][m];
        int[][] visited = new int[n][m];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int k = 0; k < m; k++) {
                if (input[k].equals("2")) {
                    startX = i;
                    startY = k;
                }
                graph[i][k] = input[k];
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny] == 0 && graph[nx][ny].equals("1")) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if (visited[i][k] == 0 && graph[i][k].equals("1")) {
                    sb.append("-1").append(" ");
                    continue;
                }
                sb.append(visited[i][k]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}
