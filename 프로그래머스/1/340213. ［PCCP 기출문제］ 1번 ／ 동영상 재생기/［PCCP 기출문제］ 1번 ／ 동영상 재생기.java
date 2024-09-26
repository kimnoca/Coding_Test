class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int posSec = minToSec(pos);
        int opStartSec = minToSec(op_start);
        int opEndSec = minToSec(op_end);
        int lenSec = minToSec(video_len);
        
        for (String command : commands) {
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
            if (command.equals("next")) {
                posSec += 10;

                if (posSec >= lenSec) {
                    posSec = lenSec;
                }
            } else {
                posSec -= 10;
                if (posSec < 0) {
                    posSec = 0;
                }
            }
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }
        System.out.println(posSec);
        
        return secToMin(posSec);
    }
    public int minToSec(String min) {
        String[] split = min.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);  
    }
    public String secToMin(int inputSec) {
        String minString = "";
        String secString = "";
        
        int min  = inputSec / 60;
        if (min < 10) {
            minString = "0" + String.valueOf(min);
        } else {
            minString = String.valueOf(min);
        }
        int sec = inputSec % 60;
        if (sec < 10) {
            secString = "0" + String.valueOf(sec);
        } else {
            secString = String.valueOf(sec);
        }
        
        return minString + ":" + secString;
    }
}