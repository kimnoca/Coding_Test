import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.length() >= m) {
				int count = map.getOrDefault(str, 0) + 1;
				map.put(str, count);
			}
		}

		List<String> keySet = new ArrayList<>(map.keySet());

		keySet.sort(((o1, o2) -> {
			if (!map.get(o1).equals(map.get(o2))) {
				return Integer.compare(map.get(o2), map.get(o1));
			} else {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return Integer.compare(o2.length(), o1.length());
				}
			}

		}));

		StringBuilder sb = new StringBuilder();

		for (String str : keySet) {
			sb.append(str).append("\n");
		}

		System.out.println(sb);

	}
}
