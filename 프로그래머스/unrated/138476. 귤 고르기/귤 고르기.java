import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int max = 0;
        for(int i = 0; i < tangerine.length; i++) {
            if(max < tangerine[i]) {
                max = tangerine[i];
            }
        }
        int guul[] = new int[max+1];
        for(int i = 0; i < tangerine.length; i++) {
            guul[tangerine[i]]++;
        }
        Arrays.sort(guul);
        int cnt = 0;
        for(int i = max; i >= 0; i--) {
            cnt += guul[i];
            if(cnt >= k) {
                answer++;
                break;
            }
            answer++;
        }
        return answer;
    }
}