import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer> answers;
    public int solution(String begin, String target, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        
        for (String word : words) {
            wordSet.add(word);
        }
        
        if (!wordSet.contains(target)) {
            return 0;
        }
        visited = new boolean[words.length];
        answers = new ArrayList<>();
        dfs(begin, target, words, 0);
        for (Integer i : answers) {
            answer = Math.min(answer, i);
        }
        return answer;
    }
    public void dfs(String start, String target, String[] words,int count) {
        if (start.equals(target)) {
            answers.add(count);
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(start, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }
    public boolean check(String a, String b) {
        int check = 0;
        for (int i = 0; i < a.length(); i ++) {
            if (a.charAt(i) == b.charAt(i)) {
                check ++;
            }
        }
        if (check  == a.length() -1) {
            return true;
        }
        return false;
    }
}