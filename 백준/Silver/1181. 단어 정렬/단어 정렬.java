import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		List<String> list = new ArrayList<>();

		for (String str : set) {
			list.add(str);
		}

		list.sort(((o1, o2) -> {
			if (o1.length() != o2.length()) {
				return Integer.compare(o1.length(), o2.length());
			} else {
				return o1.compareTo(o2);
			}
		}));

		StringBuilder sb = new StringBuilder();

		for (String str : list) {
			sb.append(str).append("\n");
		}

		System.out.println(sb);
	}
}
