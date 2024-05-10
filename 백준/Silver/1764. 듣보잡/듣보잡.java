import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        for (int i = 0; i < n + m; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list);
        list.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1))));

        int number = 0;
        ArrayList<String> answers = new ArrayList<>();

        for (String name : list) {
            if (map.get(name) == 2) {
                number++;
                answers.add(name);
            }
        }

        System.out.println(number);

        for (String name : answers) {
            System.out.println(name);
        }


    }
}
