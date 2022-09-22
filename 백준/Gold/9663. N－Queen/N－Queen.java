import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int map[][];
	static int possible;
	static int putqueen;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		putqueen(0);
		System.out.println(possible);
	}
	
	public static void putqueen(int idx) {
		//기저조건
		if(idx==N) { //끝의 행까지 도달했다는 것은 전부 퀸을 놓았다는 뜻. 즉 가능하다는 것.
			possible++;
			return;
		}
		
		//나부터 내 위로, 대각선 왼쪽, 오른쪽 방향으로 나아갔을때 퀸이 없어야함. check로 확인. 있을시에 다음열로 이동.
		for(int i = 0; i<N; i++) {
			if(check(idx,i)) {
				map[idx][i] = 1; //놓을수있으므로 1을 만들어줌.
				putqueen(idx+1); //다시 재귀
				map[idx][i] = 0; //썼으니 제자리로.
			}
		}
	}
	
	public static boolean check(int x, int y) { //놓을수 있는지 없는지 체크.
		int left = y; //현재위치 열의 위치.
		int right = y; //현재위치 열의 위치.
		
		for(int i = x-1; i>=0; i--) { //i는 현재 행의 위치를 알려줌. 처음에 -1을 하는이유는 내 위의 행부터 검사를 시작하기위해서.
			left--; //왼쪽위를 검사하기위해 처음위치에서 --를 해줌
			right++; //오른쪽 위를 검사하기위해 처음위치에서 ++를 해줌.
			
			if(map[i][y] == 1) return false; //위쪽검사인데 이미 퀸이있다.
			if(left>=0 && map[i][left] == 1) return false; //왼쪽검사인데 이미 퀸이있다.
			if(right < N && map[i][right] == 1) return false; //오른쪽 검사인데 이미 퀸이있다.
		}
		return true;
	}
}