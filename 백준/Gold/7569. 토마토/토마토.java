import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 1은 익은 토마토(사방 주위를 하루지나면 익은 토마토로 변경시켜줌.)
	// 0은 아직 익지않은 토마토 -1은 토마토가 없는 부분
	// BFS를 사용하여 1을 발견하였을때 주위에 0이 있는지 확인.
	// 0이있다면 cnt++해주고 더이상 못갈때까지 cnt추가한다음 result에 추가해준다.
	static int M, N, H;
	static int pan[][][];
	static int dy[] = { 0, 0, -1, 1 };
	static int dx[] = { -1, 1, 0, 0 };
	static int dh[] = { -1, 1 };
	static int cnt;
	static int day;
	static int result;
	static int starti = 0;
	static int startj = 0;
	static int starth = 0;
	static boolean check;
	static Queue<Node> queue = new LinkedList<>();

	static class Node {
		int r;
		int c;
		int h;

		Node(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		pan = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) { // 먼저 판 채우기.
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					pan[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) { // 토마토 익히러 가는 부분.
				for (int j = 0; j < M; j++) {
					if (pan[h][i][j] == 1) {
						if (!check) {
							starti = i;
							startj = j;
							starth = h;
							check = true;
						}
						queue.add(new Node(i, j, h));
					}
				}
			}
		}
		cook(starti, startj, starth);
		loop: for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (pan[h][i][j] == 0) {
						result = -1;
						break loop;
					}
				}
			}
		}
		System.out.println(result);

	}

	public static void cook(int i, int j, int k) { // 주위에 익지않은 토마토가 있을경우에만 cnt를 추가해주어야한다.
		pan[k][i][j] = 1; // 들어오면 토마토가 익음.
		int tmp = 1;
		day = 0;
		while (!queue.isEmpty()) {
			cnt = 0; // cnt초기화.
			tmp = queue.size();
			for (int f = 0; f < tmp; f++) {
				Node n = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nx = n.r + dx[d];
					int ny = n.c + dy[d];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (pan[n.h][nx][ny] == 1 || pan[n.h][nx][ny] == -1)
						continue;

					pan[n.h][nx][ny] = 1;
					queue.add(new Node(nx, ny, n.h));
					cnt++;
				}
				for(int h = 0; h < 2; h++) {
					int nh = n.h + dh[h];
					if (nh < 0 || nh >= H)
						continue;
					if (pan[nh][n.r][n.c] == 1 || pan[nh][n.r][n.c] == -1)
						continue;
					pan[nh][n.r][n.c] = 1;
					queue.add(new Node(n.r, n.c, nh));
					cnt++;
				}
			}
			if (cnt != 0)
				day++;
		}
		result += day;
	}
}