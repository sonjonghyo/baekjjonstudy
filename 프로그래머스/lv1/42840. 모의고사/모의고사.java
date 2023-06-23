import java.util.*;

class Solution {
    public List solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] cnt = new int[3];
        int tmpAnswer = 0;
        int max = 0;
        for(int i = 0; i < 3; i++) {
            tmpAnswer = 0;
            for(int j = 0; j < answers.length; j++) {
                if(i == 0) {
                    if((j % 5) + 1 == answers[j]) {
                        tmpAnswer++;
                    }
                }else if(i == 1) {
                    if(j%2 == 0) {
                        if(answers[j] == 2) {
                            tmpAnswer++;
                        }
                    }else {
                        if(j % 8 == 1) {
                            if(answers[j] == 1) {
                                tmpAnswer++;
                            }
                        }else if(j % 8 == 3) {
                            if(answers[j] == 3) {
                                tmpAnswer++;
                            }
                        }else if(j % 8 == 5) {
                            if(answers[j] == 4) {
                                tmpAnswer++;
                            }
                        }else if(j % 8 == 7) {
                            if(answers[j] == 5) {
                                tmpAnswer++;
                            }
                        }
                    }
                }else if(i == 2) {
                    if(j % 10 == 0  || j % 10 == 1) {
                        if(answers[j] == 3) {
                            tmpAnswer++;
                        }
                    }else if(j % 10 == 2 || j % 10 == 3) {
                        if(answers[j] == 1) {
                            tmpAnswer++;
                        }
                    }else if(j % 10 == 4 || j % 10 == 5) {
                        if(answers[j] == 2) {
                            tmpAnswer++;
                        }
                    }else if(j % 10 == 6 || j % 10 == 7) {
                        if(answers[j] == 4) {
                            tmpAnswer++;
                        }
                    }else if(j % 10 == 8 || j % 10 == 9) {
                        if(answers[j] == 5) {
                            tmpAnswer++;
                        }
                    }
                }
            }
            cnt[i] = tmpAnswer;
            if(tmpAnswer > max) {
                max = tmpAnswer;
            }
        }
        for(int i = 0; i < 3; i++) {
            if(cnt[i] == max){
                answer.add(i+1);
            }
        }
        return answer;
    }
}