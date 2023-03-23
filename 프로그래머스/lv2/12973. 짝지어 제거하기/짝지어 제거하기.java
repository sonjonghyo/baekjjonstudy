import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> content =  new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			content.add(s.charAt(i));
			while(content.size()>1) {
				char a = content.pop();
				char b = content.pop();
				if(a == b) {
					continue;
				}else {
					content.add(b);
					content.add(a);
					break;
				}
			}
		}
		if(content.size() == 0) {
			answer = 1;
		}else {
			answer = 0;
		}

        return answer;
    }
}