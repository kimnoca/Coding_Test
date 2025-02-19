import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
	static int w;
	static int h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] input = br.readLine().split(" ");

			if (input[0].equals("0") && input[1].equals("0")) {
				break;
			}

			w = Integer.parseInt(input[0]);
			h = Integer.parseInt(input[1]);

			graph = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					graph[i][j] = Integer.parseInt(input[j]);
				}
			}

			int answer = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && graph[i][j] == 1) {
						dfs(i, j);
						answer++;
					}
				}
			}
			System.out.println(answer);

		}
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
				continue;
			}

			if (!visited[nx][ny] && graph[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}
