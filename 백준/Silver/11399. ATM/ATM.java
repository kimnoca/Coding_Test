import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numbers);

        int answer = numbers[0];

        for (int i = 1; i < n; i++) {
            numbers[i] = (numbers[i - 1] + numbers[i]);
            answer += numbers[i];
        }

        System.out.println(answer);
    }
}
