import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] graph = new int[101];
        boolean[] visited = new boolean[101];

        for (int i = 0; i < n + m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            graph[x] = y;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int depth = now[1];
            visited[x] = true;

            if (x == 100) {
                System.out.println(depth);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int nx = x + i;
                if(nx >= 101) {
                    continue;
                }
                if (graph[nx] == 0 ) {
                    if (!visited[nx]) {
                        queue.add(new int[]{nx, depth + 1});
                    }
                } else {
                    if (!visited[graph[nx]]) {
                        queue.add(new int[]{graph[nx], depth + 1});
                    }
                }
            }
        }
    }
}
