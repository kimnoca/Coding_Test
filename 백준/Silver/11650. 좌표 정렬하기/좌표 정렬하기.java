import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        list.sort(((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        }));

        StringBuilder sb = new StringBuilder();

        for (int[] a : list) {
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }

        System.out.println(sb);
    }

}
