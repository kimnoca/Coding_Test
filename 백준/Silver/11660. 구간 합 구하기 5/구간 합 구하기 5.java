import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sun.security.jgss.GSSUtil;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int k = 0; k < n; k++) {
				map[i][k] = Integer.parseInt(input[k]);
			}
		}
		int[][] sum = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			for (int k = 1; k <= n; k++) {
				sum[i][k] = sum[i][k - 1] + map[i][k - 1];
			}
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]);
			int y1 = Integer.parseInt(input[1]);
			int x2 = Integer.parseInt(input[2]);
			int y2 = Integer.parseInt(input[3]);

			int answer = 0;

			// 12 + 15
			for (int k = x1 - 1; k < x2; k++) {
				answer = answer + (sum[k][y2] - sum[k][y1 - 1]);
			}

			System.out.println(answer);

		}

	}
}
