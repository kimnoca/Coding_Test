class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String inputBinary = Integer.toBinaryString(n);
        
        for(int i = n + 1; i <= 100000000; i ++) {
            if (countChar(inputBinary) == countChar(Integer.toBinaryString(i))) {
                answer = i;
                break;
            }
            
        }
        
        return answer;
    }
    
    
    public int countChar(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count ++;
            }
        }
        
        return count;
    }
}