import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class cur {
		int r, c, cnt;

		public cur(int r, int c, int cnt) {
			this.r = r; // 현재 뱀의 열의 위치
			this.c = c; // 현재 뱀의 행의 위치
			this.cnt = cnt; // 현재 뱀의 길이.
		}
	}

	// 사과를 먹으면 뱀 길이가 늘어남.
	// 기어다니다가 벽또는 자기자신 몸과 부딛히면 게임끝.
	// 뱀의 처음위치는 0,0 길이는 1. 방향은 오른쪽. (방향이 있네. 4방.)
	// 먼저 몸길이를 늘려 머리를 다음칸. -> 이동칸에 사과있을시 사과사라지고 꼬리 X 사과 없으면 꼬리비워주기.
	static int N, K, L;
	static int dr[] = { -1, 0, 1, 0 }; // 상우하좌 순으로 구현하자
	static int dc[] = { 0, 1, 0, -1 };
	static int map[][];
	static int directidx[];
	static char direct[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 맵의 크기 NxN
		map = new int[N][N];
		K = Integer.parseInt(br.readLine()); // 사과의 개수
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1; // 0,0부터시작하므로 1씩빼준다.
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1; // 사과가 있는 부분은 1으로 만들어줌
		}
		L = Integer.parseInt(br.readLine()); // 방향설정을 몇번할지.
		directidx = new int[10001]; // X의 범위가 10000이하의 양의 정수이므로 10001개를 저장.
		direct = new char[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			directidx[X]++;
			direct[i] = C;
		}
		map[0][0] = 2; // 처음시작하는부분은 뱀의 위치이다. 뱀의위치는 2로 표시.
		int rotate = 0; // 현재까지 몇번 돌았는지. (direct의 idx를 담당).
		int di = 1; // 상하좌우 순으로 0123 방향.
		Deque<cur> snake = new LinkedList<>(); // 큐에 현재 뱀이 있는 부분을 담아줌.
		snake.add(new cur(0, 0, 1));
		int time;
		loop: for (time = 1; time < N * N; time++) { // 시간을 알려줄 for문.
			cur c = snake.pollFirst(); // 머리부분을 현재 위치로 저장해준다.
			int curr = c.r;
			int curc = c.c;
			int curcnt = c.cnt;
			if (directidx[time - 1] != 0) { // 내 이전 시간이 회전했어야 하는 시간이라면 방향을 바꿔준다.
				if (direct[rotate] == 'L') { // 왼쪽으로 90도방향 회전
					di -= 1;
					if (di == -1) // 만약 상에서 좌로갈때 0에서 -1을 빼서 -1이 되었다면 3으로 바꿔줘서 좌 방향으로 만들어준다.
						di = 3;
					rotate++;
				} else {
					di += 1;
					if (di == 4)
						di = 0;
					rotate++;
				}
			}
			switch (di) {
			case 0:
				int nr0 = curr + dr[di]; // 다음방향확인
				int nc0 = curc + dc[di]; // 다음방향확인.
				if (in(nr0, nc0)) {
					if (map[nr0][nc0] == 0) { // 다음번에 사과도없고 벽 안이라면
						map[nr0][nc0] = 2;
						if (curcnt > 1) { // 만약 뱀의 길이가 1보다 크다면
							// 꼬리부분을 없애면 된다.
							cur tail = snake.pollLast(); // 꼬리부분을 빼온다.
							map[tail.r][tail.c] = 0;
							snake.addFirst(new cur(curr, curc, curcnt)); // 다시 몸통부분추가.
						} else { // 뱀의 길이가 1이라면
							map[curr][curc] = 0; // 내 현재 위치를 0으로만들어준다.(머리가 앞으로가면서 꼬리부분을 짤라야하므로)
						}
						snake.addFirst(new cur(nr0, nc0, curcnt)); // 머리추가.

					} else if (map[nr0][nc0] == 1) { // 사과가 있다면
						snake.addFirst(new cur(curr, curc, curcnt + 1)); // 떼진 머리 다시추가.
						snake.addFirst(new cur(nr0, nc0, curcnt + 1)); // 큐에 추가만해줌(뱀의 길이는 1 추가)
						map[nr0][nc0] = 2;
					} else if (map[nr0][nc0] == 2) { // 자기 자신을 부딪힌 것이므로
						break loop; // break를 걸어준다.
					}
				} else { // 벽을 만난것이므로.
					break loop; // for문 끝내줌.
				}
				break;
			case 1:
				int nr1 = curr + dr[di]; // 다음방향확인
				int nc1 = curc + dc[di]; // 다음방향확인.
				if (in(nr1, nc1)) {
					if (map[nr1][nc1] == 0) { // 다음번에 사과도없고 벽 안이라면
						map[nr1][nc1] = 2;
						if (curcnt > 1) { // 만약 뱀의 길이가 1보다 크다면
							// 꼬리부분을 없애면 된다.
							cur tail = snake.pollLast(); // 꼬리부분을 빼온다.
							map[tail.r][tail.c] = 0;
							snake.addFirst(new cur(curr, curc, curcnt)); // 다시 몸통부분추가.
						} else { // 뱀의 길이가 1이라면
							map[curr][curc] = 0; // 내 현재 위치를 0으로만들어준다.(머리가 앞으로가면서 꼬리부분을 짤라야하므로)
						}
						snake.addFirst(new cur(nr1, nc1, curcnt)); // 머리추가.
					} else if (map[nr1][nc1] == 1) { // 사과가 있다면
						snake.addFirst(new cur(curr, curc, curcnt + 1)); 
						snake.addFirst(new cur(nr1, nc1, curcnt + 1)); // 큐에 추가해줌
						map[nr1][nc1] = 2;
					} else if (map[nr1][nc1] == 2) { // 자기 자신을 부딪힌 것이므로
						break loop; // break를 걸어준다.
					}
				} else {
					break loop; // for문 끝내줌.
				}
				continue;
			case 2:
				int nr2 = curr + dr[di]; // 다음방향확인
				int nc2 = curc + dc[di]; // 다음방향확인.
				if (in(nr2, nc2)) {
					if (map[nr2][nc2] == 0) { // 다음번에 사과도없고 벽 안이라면
						map[nr2][nc2] = 2;
						if (curcnt > 1) { // 만약 뱀의 길이가 1보다 크다면
							// 꼬리부분을 없애면 된다.
							cur tail = snake.pollLast(); // 꼬리부분을 빼온다.
							map[tail.r][tail.c] = 0;
							snake.addFirst(new cur(curr, curc, curcnt)); // 다시 몸통부분추가.
						} else { // 뱀의 길이가 1이라면
							map[curr][curc] = 0; // 내 현재 위치를 0으로만들어준다.(머리가 앞으로가면서 꼬리부분을 짤라야하므로)
						}
						snake.addFirst(new cur(nr2, nc2, curcnt)); // 머리추가.
					} else if (map[nr2][nc2] == 1) { // 사과가 있다면
						snake.addFirst(new cur(curr, curc, curcnt + 1)); 
						snake.addFirst(new cur(nr2, nc2, curcnt + 1)); // 큐에 추가해줌
						map[nr2][nc2] = 2;
					} else if (map[nr2][nc2] == 2) { // 자기 자신을 부딪힌 것이므로
						break loop; // break를 걸어준다.
					}
				} else {
					break loop; // for문 끝내줌.
				}
				continue;
			case 3:
				int nr3 = curr + dr[di]; // 다음방향확인
				int nc3 = curc + dc[di]; // 다음방향확인.
				if (in(nr3, nc3)) {
					if (map[nr3][nc3] == 0) { // 다음번에 사과도없고 벽 안이라면
						map[nr3][nc3] = 2;
						if (curcnt > 1) { // 만약 뱀의 길이가 1보다 크다면
							// 꼬리부분을 없애면 된다.
							cur tail = snake.pollLast(); // 꼬리부분을 빼온다.
							map[tail.r][tail.c] = 0;
							snake.addFirst(new cur(curr, curc, curcnt)); // 다시 몸통부분추가.
						} else { // 뱀의 길이가 1이라면
							map[curr][curc] = 0; // 내 현재 위치를 0으로만들어준다.(머리가 앞으로가면서 꼬리부분을 짤라야하므로)
						}
						snake.addFirst(new cur(nr3, nc3, curcnt)); // 머리추가.
					} else if (map[nr3][nc3] == 1) { // 사과가 있다면
						snake.addFirst(new cur(curr, curc, curcnt + 1));
						snake.addFirst(new cur(nr3, nc3, curcnt + 1)); // 큐에 추가해줌
						map[nr3][nc3] = 2;
					} else if (map[nr3][nc3] == 2) { // 자기 자신을 부딪힌 것이므로
						break loop; // break를 걸어준다.
					}
				} else {
					break loop; // for문 끝내줌.
				}

				continue;
			default:
				continue;
			}

		}
		System.out.println(time);
	}

	private static boolean in(int nr, int nc) {
		return (nr >= 0 && nr < N && nc >= 0 && nc < N);
	}
}