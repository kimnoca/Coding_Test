import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] visited;
    static char[][] graph;

    static int l;
    static int w;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        l = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);

        graph = new char[l][w];

        for (int i = 0; i < l; i++) {
            String temp = br.readLine();
            for (int k = 0; k < w; k++) {
                graph[i][k] = temp.charAt(k);
            }
        }

        int answer = -1;

        for (int i = 0; i < l; i++) {
            for (int k = 0; k < w; k++) {
                visited = new int[l][w];
                if (graph[i][k] == 'L') {
                    bfs(i, k);
                    answer = Math.max(answer, maxValue());
                }
            }
        }
        System.out.println(answer - 1);
    }

    public static int maxValue() {
        int max = -1;
        for (int i = 0; i < l; i++) {
            for (int k = 0; k < w; k++) {
                max = Math.max(visited[i][k], max);
            }
        }
        return max;
    }

    public static void bfs(int startX, int startY) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = 1;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || nx >= l || ny < 0 || ny >= w) {
                    continue;
                }

                if (visited[nx][ny] == 0 && graph[nx][ny] == 'L') {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
