class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int weapon[] = new int[number+1];
		for(int i = 1; i <= number; i++) {
			num(i, weapon);
		}
		for(int i = 1; i <= number; i++) {
			if(weapon[i] > limit) {
				answer += power;
			}else {
				answer += weapon[i];
			}
		}
        
        return answer;
    }
    private static void num(int number, int weapon[]) {
		int cnt = 0;
		for(int i = 1; i * i <= number; i++) {
			if(i* i == number) { //만약 i * i가 이 수라면?(제곱근이라면)
				cnt++; //약수의 개수추가.				
			}else if(number % i == 0) { //0으로 나누어떨어진다면 2개 추가.
				cnt += 2;
			}
		}
		weapon[number] = cnt;
	}
}