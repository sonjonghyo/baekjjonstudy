class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int tmpx = x;
        while(tmpx != 0) {
            sum += tmpx % 10;
            tmpx /= 10;
        }
        if(x % sum != 0) {
            answer = false;
        }
        return answer;
    }
}