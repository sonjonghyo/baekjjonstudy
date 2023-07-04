import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < order.length; i++) {
        	stack.add(i + 1);
        	while(!stack.isEmpty()) {
        		if(stack.peek() == order[cnt]) {
        			queue.offer(stack.pop());
        			cnt++;
        		}else {
        			break;
        		}
        	}
        }
        answer = queue.size();
        return answer;
    }
}