class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n < m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        int max = n * m;
        int min = 0;
        while(m != 0) {
            min = n % m;
            n = m;
            m = min;
        }
        answer[0] = n;
        answer[1] = max / n;
        return answer;
    }
}