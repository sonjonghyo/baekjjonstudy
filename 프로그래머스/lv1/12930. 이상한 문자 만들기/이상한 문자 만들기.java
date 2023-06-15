class Solution {
    public StringBuilder solution(String s) {
        String bigS = s.toUpperCase();
        String smallS = s.toLowerCase();
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer.append(" ");
                cnt = 0;
                continue;
            }else {
                if(cnt % 2 == 0) {
                    answer.append(bigS.charAt(i));
                }else {
                    answer.append(smallS.charAt(i));
                }
                cnt++;
            }
        }
        return answer;
    }
}