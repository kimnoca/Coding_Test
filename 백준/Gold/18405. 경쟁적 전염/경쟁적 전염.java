import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[][] graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int value = Integer.parseInt(input[j]);
				if (value != 0) {
					queue.add(new Node(value, i, j));
				}
				graph[i][j] = value;
			}
		}

		input = br.readLine().split(" ");

		int S = Integer.parseInt(input[0]);
		int X = Integer.parseInt(input[1]);
		int Y = Integer.parseInt(input[2]);

		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		int count = 0;
		while (S != count) {
			Queue<Node> tempQueue = new LinkedList<>();
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				int value = node.value;
				int x = node.x;
				int y = node.y;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
						continue;
					}

					if (graph[nx][ny] == 0) {
						graph[nx][ny] = value;
						tempQueue.add(new Node(value, nx, ny));
					}
				}
			}
			count++;
			for (Node e : tempQueue) {
				queue.add(e);
			}
		}

		System.out.println(graph[X - 1][Y - 1]);
	}

}

class Node implements Comparable<Node> {
	int value;
	int x;
	int y;

	public Node(int value, int x, int y) {
		this.value = value;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(value, o.value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
