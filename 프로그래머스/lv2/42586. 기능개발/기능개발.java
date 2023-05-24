import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List solution(int[] progresses, int[] speeds) {
        	List<Integer> answer = new ArrayList<>();
		Stack<Integer> finish = new Stack<>();
		int remainProgress[] = new int[progresses.length];
		for(int i = 0; i < progresses.length; i++) {
			int remainNum = 100 - progresses[i];
			if(remainNum % speeds[i] == 0) {
				remainProgress[i] = remainNum/speeds[i];
			}else {
				remainProgress[i] = (remainNum/speeds[i]) + 1;
			}
		}
		int cnt = 0;
		int result = 0;
		while(cnt != progresses.length) {
			if(cnt == 0) {
				finish.add(remainProgress[cnt]);
				result++;
				cnt++;
			}else {
				if(finish.peek() >= remainProgress[cnt]) {
					cnt++;
					result++;
				}else {
                    finish.pop();
					finish.add(remainProgress[cnt]);
					cnt++;
					answer.add(result);
					result = 1;
				}
			}
		}
		answer.add(result);
        return answer;
    }
}