import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n + 1][n + 1];
		boolean[] visited = new boolean[n + 1];

		String[] input = br.readLine()
						   .split(" ");

		int targetX = Integer.parseInt(input[0]);
		int targetY = Integer.parseInt(input[1]);

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			input = br.readLine()
					  .split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);

			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] {targetX, 0});

		int answer = -1;

		while (!queue.isEmpty()) {

			int[] now = queue.poll();
			visited[now[0]] = true;

			if (now[0] == targetY) {
				answer = now[1];
				break;
			}

			for (int i = 0; i <= n; i++) {
				if (graph[now[0]][i] == 1 && !visited[i]) {
					queue.add(new int[] {i, now[1] + 1});
				}
			}
		}

		System.out.println(answer);
	}
}
