import java.util.*;
import java.io.*;

public class Main {
	static int map[][];
	static List<Integer> answer;
	static int tmp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = new ArrayList<>();
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int starti = Integer.parseInt(st.nextToken());
			int startj = Integer.parseInt(st.nextToken());
			int endi = Integer.parseInt(st.nextToken());
			int endj = Integer.parseInt(st.nextToken());
			for(int a = starti; a < endi; a++) {
				for(int b = startj; b < endj; b++) {
					map[a][b] = 1;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					tmp = 1;
					map[i][j] = 2;
					check(N, M, i, j);
					answer.add(tmp);
				}
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i));
			if(i != answer.size()) {
				System.out.print(" ");				
			}
		}
	}
	private static void check(int N, int M, int i, int j) {
		int dc[] = {-1,1,0,0};
		int dr[] = {0,0,-1,1};
		for(int d= 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if(map[nr][nc] == 0) {
				map[nr][nc] = 2;
				tmp++;
				check(N, M, nr, nc);
			}
		}
	}
}
