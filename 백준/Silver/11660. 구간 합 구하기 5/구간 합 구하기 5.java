import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //NxN개의 수를 표현하기 위한 것.
		int M = Integer.parseInt(st.nextToken()); //합을 구해야 하는 개수.
		int table[][] = new int[N][N]; //NxN의 2차원 배열을 생성해준다.
		int dp[][] = new int[N][N]; 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken()); //수를 table[i][j]에 넣어준다.
			}
		}
		for(int i = 0; i < N; i++) { //누적합을 저장해줄 dp배열에 값을 넣어주기.
			for(int j = 0; j < N; j++) {
				if(j==0) {
					dp[i][0] = table[i][0]; //만약 첫번째 열이라면 그대로 저장
				}else {
					dp[i][j] = table[i][j] + dp[i][j-1]; //첫번째가 아닐시엔 dp 이전 열의 값 + table의 현재값을 더해줍니다. 
				}
			}
		}
		for(int tc = 1; tc <= M ; tc++) { //M번만큼 반복한다.
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1; //x1의 좌표
			int y1 = Integer.parseInt(st.nextToken())-1; //y1의 좌표
			int x2 = Integer.parseInt(st.nextToken())-1; //x2의 좌표
			int y2 = Integer.parseInt(st.nextToken())-1; //y2의 좌표
			//-1을 해준이유는 시작이 내 테이블은 0,0 시작인데 입력값은 1,1부터 시작이므로 1씩 빼줍니다.
			if(x1 == x2 && y1 == y2) { //만약 서로 위치가 같다면
				sb.append(table[x1][y1]); //현재 위치에 있는 값을 저장해줍니다.
			}else { //위치가 다르다면?
				int sum = 0;
				
				for(int start = x1; start <= x2; start++) {
					if(y1-1<0) { //처음 열부터 더해줄시
						sum += dp[start][y2]; //y2까지를 sum에 누적시켜주면 된다.
					}else { //만약 그게 아닐시에는
						sum += dp[start][y2]-dp[start][(y1-1)]; //누적해놓은 것을 빼서 값을 재조정해준다.											
					}
				}
				sb.append(sum);
			}
			if(tc != M) { //마지막이 아닐시 개행문자 추가.
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}