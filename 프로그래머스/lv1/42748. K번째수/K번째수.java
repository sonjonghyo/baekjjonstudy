import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int anscnt = 0;
        for(int i = 0; i < commands.length; i++) {
            int tmp[] = new int[commands[i][1]-commands[i][0] + 1];
            int cnt = commands[i][0] - 1;
            for(int j = 0; j < tmp.length; j++) {
                tmp[j] = array[cnt++];
            }
            Arrays.sort(tmp);
            answer[anscnt++] = tmp[commands[i][2] - 1];
        }
        return answer;
    }
}