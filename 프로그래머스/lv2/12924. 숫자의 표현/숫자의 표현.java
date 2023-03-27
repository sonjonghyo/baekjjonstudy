class Solution {
    public int solution(int n) {
        int answer = 0;
        //누적합을 저장해줄 sum 배열입니다.
		int sum[] = new int[n+1];
		for(int i = 1; i < n + 1; i++) {
			sum[i] = i + sum[i-1];
		}
		int start = 0; //시작지점
		int end = 1; //끝지점.
		while(start != n) { //시작지점이 끝까지 가면 while문을 끝내줍니다.
			if(sum[end] - sum[start] < n) { //만약 두 누적합의 차가 n보다 작다면?
				end++; //끝을 한칸 늘려줍니다.
			}else if(sum[end] - sum[start] > n) { //만약 두 누적합의 차가 n보다 크다면?
				start++; //시작지점을 한칸 늘려줍니다.
			}else { //만약 같다면?
				answer++; //answer를 하나 추가시켜주고
				start++; //시작지점을 한칸 늘려줍니다.
			}
		}
        return answer;
    }
}