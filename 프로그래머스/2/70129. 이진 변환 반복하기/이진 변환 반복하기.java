class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int loopCount = 0;
        
        
        while (!s.equals("1")) {
            zeroCount += countZero(s);
            s = s.replaceAll("0", "");
            loopCount ++;
            s = Integer.toBinaryString(s.length());
        }
        
        answer[0] = loopCount;
        answer[1] = zeroCount;
        
        return answer;
    }
    
    public int countZero(String str) {
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count ++;
            }
        }
        
        return count;
    }
}