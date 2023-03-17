class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long savemoney = 0;
        for(int i = 1; i <= count; i++) {
            savemoney += (price * i);
        }
        answer = savemoney - money;
        if(answer < 0) {
            answer = 0;
        }
        return answer;
    }
}