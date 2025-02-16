import java.util.*;

class Solution {
    static Set<Integer> result = new HashSet<>();
    
    public int solution(int[] elements) {
        
        for (int e : elements) {
            result.add(e);
        }
        
        for(int i = 2; i <= elements.length; i++) {
            for (int k = 0; k < elements.length; k ++) {
                 dfs(elements[k], i, 1, elements, k);
            }
        }
        
        return result.size();
    }
    
    public void dfs(int n, int size, int depth, int[] elements, int start) {
        
        if (size == depth) {
            result.add(n);
            return;
        }

        dfs(n + elements[(start + 1) % elements.length], size, depth + 1, elements, start + 1);
    }
}