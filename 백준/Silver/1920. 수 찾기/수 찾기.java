import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(data);

		int m = Integer.parseInt(br.readLine());

		input = br.readLine().split(" ");

		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(input[i]);
			boolean check = false;

			int start = 0;
			int end = data.length - 1;

			while (start <= end) {
				int mid = (start + end) / 2;
				if (data[mid] == target) {
					check = true;
					break;
				}

				if (data[mid] < target) {
					start = mid + 1;
				} else if (data[mid] > target) {
					end = mid - 1;
				}
			}
			System.out.println(check ? 1 : 0);
		}

	}
}