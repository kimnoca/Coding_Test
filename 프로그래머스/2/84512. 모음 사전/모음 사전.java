class Solution {
    static int answer = 0;
    static int count = 0;
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    public void dfs(String cur, String word) {
        
        if (cur.equals(word)) {
            answer = count;
            return;
        }
        
        count ++;
        
        if (cur.length() == 5) {
            return;
        }
        
        for (char c : "AEIOU".toCharArray()) {
            dfs(cur + c, word);
        }
        
        
    }
}