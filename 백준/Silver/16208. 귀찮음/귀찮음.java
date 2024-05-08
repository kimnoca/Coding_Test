import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(input[i]));
        }

        Collections.sort(arrayList);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int curr = arrayList.get(i);
            int sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += arrayList.get(j);
            }
            answer += (curr * sum);
        }

        System.out.println(answer);
    }
}
