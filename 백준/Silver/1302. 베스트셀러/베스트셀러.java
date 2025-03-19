import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> set = new ArrayList<>(map.keySet());
        set.sort((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o1.compareTo(o2);
            }
            return Integer.compare(map.get(o2), map.get(o1));
        });

        System.out.println(set.get(0));

    }

}
