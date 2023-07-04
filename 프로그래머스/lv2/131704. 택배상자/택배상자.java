import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int turn = 0;
        int cnt = order[turn];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < order.length; i++) {
            if(cnt == i+1) {
                turn++;
                answer++;
                if(turn < order.length) {
                    cnt = order[turn];
                }
            }else {
                stack.add(i+1);
            }
            while(!stack.isEmpty()) {
                if(stack.peek() == cnt) {
                    stack.pop();
                    answer++;
                    turn++;
                 if(turn < order.length) {
                        cnt = order[turn];
                    }       
                }else {
                break;
                }
            }
        }
        return answer;
    }
}