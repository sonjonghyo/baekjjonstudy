//Set을 사용해서 중복없는 수로 다 뽑아낸 다음에 소수 찾기.
import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
    public int solution(String numbers) {
        int answer = 0;
        char[] num = new char[numbers.length()];
        for(int i = 0; i < numbers.length(); i++) {
            num[i] = numbers.charAt(i);
        }
        boolean visited[] = new boolean[numbers.length()];
        searchNum(num, visited);
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()) {
        	int a = itr.next();
        	if(a == 1 || a == 0)
        		continue;
        	if(sosu(a))
        		answer++;
        }
        return answer;
    }
    private static boolean sosu(int a) {
		for(int i = 2; i <= a/2; i++) {
			if(a%i == 0)
				return false;
		}
		return true;
	}
	private static void searchNum(char[] num, boolean visited[]) {
		for(int i = 0; i < num.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sb.append(num[i]);
				String S = sb.toString();
				int a = Integer.parseInt(S);
				set.add(a);
				searchNum(num, visited);
				visited[i] = false;
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
    
}