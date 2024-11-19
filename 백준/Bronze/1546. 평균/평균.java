import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");

		int sum = 0;
		int max = 0;

		for (String s : input) {
			int number = Integer.parseInt(s);
			max = Math.max(number, max);
		}

		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(input[i]);
		}

		System.out.println((double)sum / max * 100 / n);

	}
}