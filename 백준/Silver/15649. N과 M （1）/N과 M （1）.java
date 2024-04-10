import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> arr;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        dfs();
    }
    private static void dfs() {
        if (arr.size() == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= n ; i ++) {
            if(!arr.contains(i)) {
                arr.add(i);
                dfs();
                arr.remove(arr.size() - 1);
            }
        }
    }
}