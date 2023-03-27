import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int answer[];
		Stack<Integer> number = new Stack<>();
		for(int i = 0; i < arr.length; i++) {
			if(number.isEmpty()) {
				number.add(arr[i]);
			}else {
				if(number.peek() == arr[i]) {
					continue;
				}else {
					number.add(arr[i]);
				}
			}
		}
		answer = new int[number.size()];
		for(int i = number.size()-1; i >= 0; i--) { 
			answer[i] = number.pop();
		}

        return answer;
    }
}