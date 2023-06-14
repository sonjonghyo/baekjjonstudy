import java.util.*;

class Solution {
    public long solution(long n) {
        String result = "";
        long answer = 0;
        long tmp[] = new long[(int) (Math.log10(n)+1)];
        int cnt = 0;
        while(n != 0) {
            tmp[cnt++] = n%10;
            n /= 10;
        }
        int maxIdx = 0;
        int maxValue = -1;
        Arrays.sort(tmp);
        for(int i  = tmp.length-1 ; i >= 0; i--) {
            result += tmp[i];
        }
        answer = Long.parseLong(result);
        return answer;
    }
}