import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int endIndex = 1;
		int startIndex = 1;
		int answer = 1;
		int sum = 1;

		while (n != endIndex) {
			if (sum == n) {
				answer++;
				endIndex++;
				sum = sum + endIndex;
			} else if (sum > n) {
				sum = sum - startIndex;
				startIndex++;
			} else {
				endIndex++;
				sum = sum + endIndex;
			}
		}

		System.out.println(answer);

	}
}