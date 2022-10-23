import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스의 개수
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); //동전의 가지수.
			
			int money[] = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=N; i++) {
				money[i] = Integer.parseInt(st.nextToken()); //각 동전의 가격.
			}
			int M = Integer.parseInt(br.readLine()); //만들어야 할 금액 M
			int dp[] = new int[M+1]; //dp로 계산하기 위해 dp의 크기는 만들어야할 금액 + 1로 만들어준다. 
			for(int i = 1; i<=N; i++) { //1부터 N번의 동전까지있으므로 계산.(금액이 오름차순이라 가능함.)
				for(int j = 1; j<=M; j++) { //총 금액까지 계산함.
					if(j - money[i] > 0) {	//현재 쓰는 금액보다 크다면
						dp[j] += dp[j-money[i]]; //현재의 dp에 저장된 값 + 현재 나의 j의 값에서 사용하는 금액을 뺀 부분의 dp값을 더해주어 누적시켜줌.
					}else if (j - money[i] == 0) { //0이라는 것은 그부분을 만들수 있다는 것.
						dp[j]++; //그부분을 만들수있으므로 1추가해준다.
					}
				}
			}
			sb.append(dp[M]); //결과적으로 마지막에 dp의 M의 위치에 있는것이 답.
			if(tc!=T)
				sb.append("\n");
			
		}
		System.out.println(sb);	
	}
}