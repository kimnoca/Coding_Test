import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    static char[][] graph;
    static StringBuilder visited;
    static int r;
    static int c;
    static int answer;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");

        r = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);

        graph = new char[r][c];
        visited = new StringBuilder();
        answer = 0;

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                graph[i][j] = temp.charAt(j);
            }
        }

        visited.append(graph[0][0]);
        max = 0;
        
        dfs(0, 0);

        System.out.println(max);

    }

    static public void dfs(int x, int y) {

        max = Math.max(visited.length(), max);

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (validate(nx, ny) && !(visited.toString().contains(String.valueOf(graph[nx][ny])))) {
                visited.append(graph[nx][ny]);
                dfs(nx, ny);
                visited.deleteCharAt(visited.length() - 1);
            }
        }
    }

    static public boolean validate(int x, int y) {
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return false;
        }
        return true;
    }
}
