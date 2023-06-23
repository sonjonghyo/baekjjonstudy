class Solution {
    public StringBuilder solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				answer.append(calCul(s.charAt(i), n, 90));
			}else if(s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				answer.append(calCul(s.charAt(i), n, 122));
			}else {
				answer.append(s.charAt(i));
			}
		}
        return answer;
    }
    public static char calCul(char a, int n, int max) {
		int tmpCnt = a + n;
		if(tmpCnt > max) {
			tmpCnt -= 26;
		}
		char tmp = (char) tmpCnt;
		return tmp;
	}
}