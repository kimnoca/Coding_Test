import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		ArrayList<Integer> array = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			array.add(Integer.parseInt(input[i]));
		}

		Collections.sort(array);

		System.out.println(array.get(k - 1));
	}
}