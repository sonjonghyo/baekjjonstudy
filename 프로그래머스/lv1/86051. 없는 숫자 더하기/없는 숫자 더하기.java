class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean checknumber[] = new boolean[10];
        for(int i = 0; i < numbers.length; i++) {
            checknumber[numbers[i]] = true;
        }
        for(int i = 0; i < 10; i++) {
            if(!checknumber[i]) {
                answer += i;
            }
        }
        return answer;
    }
}