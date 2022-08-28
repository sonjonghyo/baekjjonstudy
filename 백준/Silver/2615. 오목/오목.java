import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int board[][];
	static int dc[] = { 0, 1, -1, 1 };
	static int dr[] = { 1, 0, 1, 1 }; // 오른쪽, 아래쪽, 대각선위, 대각선아래 순서.
	static boolean ch;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[21][21]; // 바둑판은 원래 19칸짜리지만 21x21로 만들어 1.1부터 시작해 계산하기 편하게 하기위함.
		for (int i = 1; i < board.length-1; i++) { // 1,1부터 입력을 넣어줌
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < board[i].length-1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check();
		System.out.println(sb);
	}
	static void check() { // 오목이 되었는지 확인해주는 함수.
		int c = 0;
		int r = 0;
		int dir = 0;
		int cnt = 0; // 오목이 되었는지 체크해주는 변수
		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[i].length - 1; j++) {
				ch = false;
				cnt = 0;
				if (board[i][j] == 1) { // 현재위치가 검은 바둑알 이라면?
					for (int x = 0; x < 4; x++) {
						cnt = 1;
						ch = false;
						c = i + dc[x];
						r = j + dr[x];
						if (c >= 0 && c < board.length && r >= 0 && r < board.length) { //밖으로 나가는지 안나가는지 확인.
							if (board[c][r] == 1) {
								if (board[i - dc[x]][j - dr[x]] != 1) {
									ch = true; // 오목을 하기에 준비가 되었다.
									dir = x; // 현재 가고있는 방향 저장.
									cnt++; // 2칸이 채워졌으므로 확인해줌.
									int cdir = dir; // 복제.
									if (ch) {
										for (int y = 1; y <= 4; y++) { // 한번더감. 혹시라도 5칸이아닌 6칸이 찰수도 있으므로.
											if(c+(dc[cdir]*y)>=0 && c+(dc[cdir]*y)<board.length && r+(dr[cdir]*y)>=0 && r+(dr[cdir]*y)<board.length){
												if (board[c + (dc[cdir] * y)][r + (dr[cdir] * y)] == 1) {
													cnt++;
												}else {
													break;
												}
											}else {
												break;
											}
										}
										if (ch && cnt == 5) { // 만약 오목이 되었다면?
											sb.append(1).append("\n"); // 검은 바둑돌이 이겼으니 1을 추가
											sb.append(i).append(" ").append(j); // 그러고 시작한 위치인 i,j를 넣어준다.
											return;
										}
									}
								}
							}
						}else {
							continue;
						}
					}
				} else if (board[i][j] == 2) { // 현재위치가 흰 바둑알 이라면?
					for (int x = 0; x < 4; x++) {
						cnt = 1;
						ch = false;
						c = i + dc[x];
						r = j + dr[x];
						if (c >= 0 && c < board.length && r >= 0 && r < board.length) { //밖으로 나가는지 안나가는지 확인.
							if (board[c][r] == 2) {
								if (board[i - dc[x]][j - dr[x]] != 2) {
									ch = true; // 오목을 하기에 준비가 되었다.
									dir = x; // 현재 가고있는 방향 저장.
									cnt++; // 2칸이 채워졌으므로 확인해줌.
									int cdir = dir; // 복제.
									if (ch) {
										for (int y = 1; y <= 4; y++) { // 한번더감. 혹시라도 5칸이아닌 6칸이 찰수도 있으므로.
											if(c+(dc[cdir]*y)>=0 && c+(dc[cdir]*y)<board.length && r+(dr[cdir]*y)>=0 && r+(dr[cdir]*y)<board.length){
												if (board[c + (dc[cdir] * y)][r + (dr[cdir] * y)] == 2) {
													cnt++;
												}else {
													break;
												}
											}else {
												break;
											}
										}
										if (ch && cnt == 5) { // 만약 오목이 되었다면?
											sb.append(2).append("\n"); // 검은 바둑돌이 이겼으니 1을 추가
											sb.append(i).append(" ").append(j); // 그러고 시작한 위치인 i,j를 넣어준다.
											return;
										}
									}
								}
							}
						}else {
							continue;
						}
					}
			} else { // 알이 없다면 바로 다시 for문시작.
				continue;
			}
		}
	}
		sb.append(0); // 만약 for문이 다 끝났다는 것은 오목이 완성된 것을 발견하지 못한것이므로 승부가 나지않았다는것으로 0을 추가해준다.
	}
}