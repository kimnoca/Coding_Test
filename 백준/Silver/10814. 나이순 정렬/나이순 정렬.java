import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int id = 0;

		List<User> users = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			users.add(new User(++id, input[1], Integer.parseInt(input[0])));
		}

		Collections.sort(users);

		StringBuilder sb = new StringBuilder();

		for (User user : users) {
			sb.append(user).append("\n");
		}

		System.out.println(sb);

	}
}

class User implements Comparable<User> {
	int id;
	String name;
	int age;

	public User(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(User o) {
		if (this.age == o.age) {
			return Integer.compare(this.id, o.id);
		}
		return Integer.compare(this.age, o.age);
	}

	@Override
	public String toString() {
		return this.age + " " + this.name;
	}
}