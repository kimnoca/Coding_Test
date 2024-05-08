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

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arrayList.get(i);
        }
        long answer = 0;

        for (int i = 0; i < n; i++) {
            sum = sum - arrayList.get(i);
            answer += sum * arrayList.get(i);
        }

        System.out.println(answer);
    }
}
