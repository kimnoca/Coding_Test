import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            HashSet<Character> set = new HashSet<>();
            boolean isChecked = true;

            set.add(string.charAt(0));

            for (int k = 1; k < string.length(); k++) {
                if (string.charAt(k) != string.charAt(k - 1) && set.contains(string.charAt(k))) {
                    isChecked = false;
                    break;
                }
                set.add(string.charAt(k));
            }
            if (isChecked) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
