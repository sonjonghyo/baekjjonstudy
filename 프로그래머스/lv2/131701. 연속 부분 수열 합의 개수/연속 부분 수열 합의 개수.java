import java.util.*;
class Solution {
    public int solution(int[] elements) {
        		int answer = 0;
        int maxlength = elements.length;
        int cnt = 0;
        int minIdx = 0;
        int maxIdx = 0;
        int maxcnt = 0;
        int sum = 0;
        Set<Integer> setSum = new HashSet<>();
        for(int i = 0; i < maxlength; i++) {
            cnt = 0;
            minIdx = 0;
            maxIdx = 0;
            sum = 0;
            for(minIdx = 0; cnt < maxlength; ) {
                sum += elements[(maxIdx%maxlength)];
                if(maxIdx - minIdx == maxcnt) {
                    setSum.add(sum);
                    sum -= elements[(minIdx%maxlength)];
                    maxIdx++;
                    minIdx++;
                    cnt++;
                }else {
                    maxIdx++;
                }
            }
            maxcnt++;
        }
        answer = setSum.size();
        return answer;
    }
}