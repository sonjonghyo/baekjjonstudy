import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> bracket = new Stack();
		int answer = 0;
		int cnt = 0;
		while(cnt != s.length()) {
			for(int i = 0; i < s.length(); i++) {
				if(bracket.isEmpty()) {
					bracket.add(s.charAt(((i+cnt)%s.length())));					
				}else {
					if(bracket.peek() == '[') {
						if(s.charAt(((i+cnt)%s.length())) == ']') {
							bracket.pop();
						}else {
							bracket.add(s.charAt(((i+cnt)%s.length())));
						}
					}else if(bracket.peek() == '{') {
						if(s.charAt(((i+cnt)%s.length())) == '}') {
							bracket.pop();
						}else {
							bracket.add(s.charAt(((i+cnt)%s.length())));
						}
					}else if(bracket.peek() == '(') {
						if(s.charAt(((i+cnt)%s.length())) == ')') {
							bracket.pop();
						}else {
							bracket.add(s.charAt(((i+cnt)%s.length())));
						}
					}
				}
				
			}
			if(bracket.isEmpty()) {
				answer++;
			}
			cnt++;
			bracket.clear();
		}
        return answer;
    }
}