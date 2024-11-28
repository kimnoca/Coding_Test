import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		graph = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			graph[start].add(end);
			graph[end].add(start);
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				answer++;
				dfs(i);
			}
		}

		System.out.println(answer);
	}

	private static void dfs(int start) {
		visited[start] = true;

		for (int x : graph[start]) {
			if (!visited[x]) {
				dfs(x);
			}
		}
	}
}