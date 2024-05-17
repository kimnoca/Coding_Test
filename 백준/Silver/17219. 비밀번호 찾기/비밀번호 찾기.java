import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            map.put(temp[0], temp[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String answer = br.readLine();
            sb.append(map.get(answer)).append("\n");
        }
        System.out.println(sb);

    }
}
