import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(input[i]);
		}
		int[] sum = new int[n + 2];

		sum[1] = array[0];

		for (int i = 2; i <= n; i++) {
			sum[i] = sum[i - 1] + array[i - 1];
		}

		for (int k = 0; k < m; k++) {
			input = br.readLine().split(" ");
			int i = Integer.parseInt(input[0]);
			int j = Integer.parseInt(input[1]);

			System.out.println(sum[j] - sum[i - 1]);
		}

	}
}