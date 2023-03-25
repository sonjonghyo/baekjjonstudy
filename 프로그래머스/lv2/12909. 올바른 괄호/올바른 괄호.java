import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') { //'('라면 무조건 추가.
				stack.add('(');
			}else if(stack.isEmpty() && s.charAt(i) == ')') { //만약 스택이 비어있고 ) 라면?
				answer = false;
				break;
			}else if(!stack.isEmpty() && s.charAt(i) == ')') { //비어있지않고 ')'라면?
				stack.pop(); //하나빼줘.
			}
		}
		if(!stack.isEmpty()) { //스택이 비어있지않다면?
			answer = false;
		}
        return answer;
    }
}