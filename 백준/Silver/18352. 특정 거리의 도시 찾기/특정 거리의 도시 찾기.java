import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer> result = new ArrayList<>();
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		int x = Integer.parseInt(input[3]);

		graph = new ArrayList[n + 1];
		visited = new int[n + 1];

		Arrays.fill(visited, -1);

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			graph[start].add(end);
		}

		Queue<Integer> queue = new LinkedList<>();

		queue.add(x);
		visited[x] = 0;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i : graph[curr]) {
				if (visited[i] == -1) {
					visited[i] = visited[curr] + 1;
					queue.add(i);
				}
			}
		}

		for (int i = 0; i <= n; i++) {
			if (visited[i] == k) {
				result.add(i);
			}
		}

		if (result.isEmpty()) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();

			for (int r : result) {
				sb.append(r).append("\n");
			}

			System.out.println(sb);
		}

	}

}