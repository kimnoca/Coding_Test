import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static String[][] graph;
	static boolean[][] visited;
	static int whiteSum;
	static int blackSum;
	static int sum;

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		graph = new String[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				graph[i][j] = input[j];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && graph[i][j].equals("W")) {
					dfs(i, j, "W");

				}
				whiteSum += (sum * sum);
				sum = 0;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && graph[i][j].equals("B")) {
					dfs(i, j, "B");
				}
				blackSum += (sum * sum);
				sum = 0;
			}
		}

		System.out.println(whiteSum + " " + blackSum);

	}

	public static void dfs(int x, int y, String type) {

		visited[x][y] = true;
		sum++;

		for (int i = 0; i < 4; i++) {

			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
				continue;
			}

			if (!visited[nx][ny] && graph[nx][ny].equals(type)) {
				dfs(nx, ny, type);
			}

		}

	}
}
