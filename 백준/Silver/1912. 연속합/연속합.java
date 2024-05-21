import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i < n; i++) {
            array[i] = Math.max(array[i], array[i] + array[i - 1]);
        }

        int answer = Integer.MIN_VALUE;

        for (Integer i : array) {
            answer = Math.max(i, answer);
        }

        System.out.println(answer);
    }
}
