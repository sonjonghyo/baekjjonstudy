class Solution {
    public int solution(int n) {
        int count = countOne(n);
		int answer = 0;
		while(true) {
			int compareCount = countOne(++n);
			if(compareCount == count) {
				answer = n;
				break;
			}
		}
        return answer;
    }
    public static int countOne(int n) {
		int count = 0;
		while(n != 0) {
			if(n%2 != 0) {
				count++;
			}
			n/=2;
		}
		return count;
	}
}