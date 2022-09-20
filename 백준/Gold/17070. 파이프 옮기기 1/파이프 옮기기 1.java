import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//현재의 상태(가로 = 1, 대각선 = 2, 세로 = 3)
	static int arr[][];
	static int N;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,1,1); //0,1부터 시작하므로 comb(0과 1을 주었음.)
		System.out.println(cnt);
	}
	public static void comb(int r, int c, int state) {
		if((c >= N || r >= N)) { //범위 밖이므로 return해준다.
			return;
		} else if(arr[r][c]==1) { //1인 구간은 놓을수없는 구간이므로 return해준다.
			return;
		}
		if(state == 2) {
			if(arr[r][c-1]==1 || arr[r-1][c]==1) //체크해서 걸리면 return해준다.
				return;
		}
		if(r==N-1 && c==N-1) { //만약 r과 c가 2차원배열의 r과c의 끝까지 갔다면
			cnt++; //횟수를 1번 추가시켜주고
			return; //return해준다.
		}
		if(state == 1) { //상태가 1일때 즉 가로일때는
			comb(r, c+1, 1); //다음 상태 확인후
			comb(r+1, c+1, 2);
		} else if (state == 2) { //상태가 2일때는 대각선인데 대각선은 놓이는 기준 왼쪽,위쪽 자기자신이 1이면 안되므로
			comb(r+1, c+1, 2); //안걸리면 다음 상태 확인.
			comb(r, c+1, 1);
			comb(r+1, c,3 );
		} else { //마지막 상태가 3일때 세로.
			comb(r+1, c, 3);
			comb(r+1, c+1, 2);
		}
	}
}