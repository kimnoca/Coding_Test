import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 0});
        visited[1] = true;

        int result = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int x = now[0];
            int degree = now[1];

            if (degree <= 2) {
                result++;
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[x][i] == 1) {
                    queue.add(new int[]{i, degree + 1});
                    visited[i] = true;
                }
            }
        }
        System.out.println(result);
    }
}