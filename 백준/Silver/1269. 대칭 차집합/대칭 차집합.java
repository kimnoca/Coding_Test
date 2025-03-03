import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		HashSet<Integer> aSet = new HashSet<>();

		input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			aSet.add(Integer.parseInt(input[i]));
		}

		HashSet<Integer> bSet = new HashSet<>();

		int answer = 0;

		input = br.readLine().split(" ");

		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(input[i]);
			if (!aSet.contains(x)) {
				answer++;
			}
			bSet.add(x);
		}

		for (int e : aSet) {
			if (!bSet.contains(e)) {
				answer++;
			}
		}

		System.out.println(answer);
	}

}
