class Solution {
    static int[] score;
    public int solution(String dartResult) {
        int answer = 0;
        int score[] = new int[3];
        int cnt = 0;
        for(int i = 0; i < dartResult.length(); i++) {
            if(dartResult.charAt(i) - '0' >= 0 && dartResult.charAt(i) - '0' <= 9) {
                if(i != 0)
                    cnt++;
                int num = 0;
                if(dartResult.charAt(i) -'0' == 1) {
                    if(dartResult.charAt(i+1) - '0' == 0) {
                        i++;
                        num = 10;    
                    }else {
                        num = 1;
                    }
                }else {
                    num = dartResult.charAt(i) - '0';
                }
                score[cnt] = num;
            }else {
                //S는 어짜피 그대로 이므로 필요가 없다.
                if(dartResult.charAt(i) == 'D') {
                    score[cnt] = score[cnt] * score[cnt];    
                }else if(dartResult.charAt(i) == 'T') {
                    score[cnt] = score[cnt] * score[cnt] * score[cnt];
                }else if(dartResult.charAt(i) == '*') {
                    if(cnt > 0) {
                        for(int j = cnt-1; j <= cnt; j++) {
                            score[j] *= 2;
                        }   
                    }else {
                        for(int j = 0; j <= cnt; j++) {
                            score[j] *= 2;
                        } 
                    }
                    
                }else if(dartResult.charAt(i) == '#') { 
                    score[cnt] = -score[cnt];
                }
            }
        }
        for(int i = 0; i < 3; i++) {
            answer += score[i];
        }
        return answer;
    }
}