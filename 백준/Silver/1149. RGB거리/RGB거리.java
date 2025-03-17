import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = array[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + array[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + array[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + array[i][2];
        }

        int result = Arrays.stream(dp[n - 1]).min().getAsInt();

        System.out.println(result);
    }

}
