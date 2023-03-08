class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = ' ';
		int one = 0;
		int two = 0;
		for(int i = 0; i < s.length(); i++) {
			if(first == ' ') {
				first = s.charAt(i);
				one++;
				two = 0;
			}else {
				if(first == s.charAt(i)) {
					one++;
				}else {
					two++;
				}
				if(one == two) { //두개가 같다면?
					answer++;
					one = 0;
					two = 0;
					first = ' ';
				}
			}
		}
		if(first != ' ') {
			answer++;
		}
        return answer;
    }
}