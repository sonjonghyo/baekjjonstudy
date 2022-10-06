import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long dp[][][];
	static int map[][];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		dp = new long[N+1][N+1][3]; //방향에 따라서 넣어줄거라 3차원배열로 만들어줌.
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(map[N][N]==1) { //마지막구간이 1이라면
			System.out.println(0); //그 구간은 이동할수없으므로 바로 0출력.
		}else {
			//가로로 올수있는방법 + 세로로올수있는방법 + 대각선으로 올수있는방법을 전부 더해준다.
			System.out.println(move());
		}
		
		
	}
	
	public static long move() {
		dp[1][2][0] = 1; //현재 파이프는 가로형태로 1,2위치에 있다.
		for(int i = 1; i<=N; i++) {
			for(int j = 3; j<=N; j++) { //3부터 시작하는 이유는 1과 2는 갈수없기때문이다.
				if(map[i][j]==1) //장애물이 있으면 갈수가없어.
					continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]; //가로에 대한 부분 [0]
				
				if(i==1) //세로에 대한부분은 i가 1일경우엔 세로와 대각선은 이전값이 없으므로 넘어가주면 된다.
					continue;
				
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]; //세로에 대한 부분[0].
				
				if(map[i-1][j]==1 || map[i][j-1]==1)
					continue; //대각선으로 가는데 도착지점의 위와 왼쪽이 장애물이라면 대각선으로 못가니 다음으로.
				
				dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			}
		}
		return dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
	}
}