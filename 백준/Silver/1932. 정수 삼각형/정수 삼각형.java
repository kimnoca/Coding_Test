import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                array[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = array[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + array[i][0];
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + array[i][j];
            }
        }

        int result = Integer.MIN_VALUE;

        for (int a : dp[n - 1]) {
            if (result < a) {
                result = a;
            }
        }

        System.out.println(result);
    }

}
