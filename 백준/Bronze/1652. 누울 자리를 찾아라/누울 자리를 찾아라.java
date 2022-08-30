import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char room [][];
	static int rcnt = 0; //가로로 누울자리
	static int ccnt = 0; //세로로 누울자리
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		room = new char[N][N];
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<N; j++) {
				room[i][j] = s.charAt(j);
			}
		}
		row(N); //가로로 누울수 있는 자리를 찾음
		col(N); //세로로 누울수 있는 자리를 찾음.
		System.out.println(rcnt + " " + ccnt);
		
	}
	static void row(int N) {
		for(int i = 0; i<N; i++) {
			int cnt = 0; //행이 초기화 될때마다 cnt는 0으로 초기화 시켜주어야한다.
			for(int j = 0; j<N; j++) { //열 방향으로 가는데
				if(room[i][j] == '.') { //만약 내 현재위치가 아무것도없는곳이라면 누울수있기때문에
					cnt++; //cnt를 1 증가시키고
				}else {
					cnt = 0; //누울수 없으면 이전에 누울수있었어도 의미가없으므로 0으로 초기화시켜준다.
				}
				if(cnt==2) { //2칸이상부턴 무조건 누울수있으므로 cnt가 2가될때는 
					rcnt++; //이번 가로는 누울수있으니 1개 추가시켜준다.
				}
			}
		}
	}
	
	static void col(int N) {
		for(int i = 0; i<N; i++) {
			int cnt = 0; //열이 초기화 될때마다 cnt를 0으로 초기화 시켜주어야한다.
			for(int j = 0; j<N; j++) { 
				if(room[j][i] == '.') { //위와같다.
					cnt++;
				}else {
					cnt = 0;
				}
				if(cnt==2) {
					ccnt++;
				}
			}
		}
	}
}