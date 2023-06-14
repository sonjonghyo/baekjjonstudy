class Solution {
    public StringBuilder solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        int size = phone_number.length();
        for(int i = 0; i < size; i++) {
            if(i >= size - 4) {
                answer.append(phone_number.charAt(i));
            }else {
                answer.append("*");
            }
        }
        return answer;
    }
}