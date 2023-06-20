class Solution {
    public int solution(String word) {
        int answer = 0;
        int value[] = {781, 156, 31, 6, 1};
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == 'A') {
                answer += 1;
            }else if(word.charAt(i) == 'E') {
                answer += value[i] + 1;
            }else if(word.charAt(i) == 'I') {
                answer += ((value[i] * 2) + 1);
            }else if(word.charAt(i) == 'O') {
                answer += ((value[i] * 3) + 1);
            }else if(word.charAt(i) == 'U') {
                answer += ((value[i] * 4) + 1);
            }
        }
        return answer;
    }
}