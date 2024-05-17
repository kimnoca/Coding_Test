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
        HashMap<String, Integer> numberMap = new HashMap<>();
        HashMap<Integer, String> stringMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            numberMap.put(temp, i + 1);
            stringMap.put(i + 1, temp);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String answer = br.readLine();
            if (!Character.isDigit(answer.charAt(0))) {
                sb.append(numberMap.get(answer)).append("\n");
            } else {
                int temp = Integer.parseInt(answer);
                sb.append(stringMap.get(temp)).append("\n");
            }
        }
        System.out.println(sb);

    }
}
