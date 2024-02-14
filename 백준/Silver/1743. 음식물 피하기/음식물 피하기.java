import java.io.*;
import java.util.*;

public class Main {
	//BFS를 위한 Node(위치저장)
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	//코레스코 콘도미니엄의 크기
	static int space[][];
	//상하좌우가 있는 배열
	static int drc[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	//방문 체크 배열
	static boolean visited[][];
	//세로길이, 가로길이, 음식물 쓰레기의 개수
	static int N,M,K;
	//가장 큰 음식물의 크기 저장.
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		space = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < K; i++) {
			//음식물 쓰레기의 위치 저장.
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			//음식물 쓰레기가 있는 공간은 -1로 저장하기.
			space[r][c] = -1;
		}
		
		//전체 탐색하면서 음식물 쓰레기 찾기.
		for(int i = 0; i < N; i++) {
			for(int j =0; j < M; j++) {
				//음식물 쓰레기가 있으며 새로운 것이라면?(기존에 합쳐진것이 아니라면)
				if(space[i][j] == -1 && !visited[i][j]) {
					//BFS시작.
					bfs(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	private static void bfs(int i, int j) {
		//BFS를 위한 큐 생성.
		Queue<Node> q = new LinkedList<>();
		//큐에 현재 위치 넣기.
		q.add(new Node(i, j));
		//방문했다고 체크
		visited[i][j] = true;
		int cnt = 1;
		//큐가 다 빌때까지.
		while(!q.isEmpty()) {
			Node n = q.poll();
			//현재 위치에서 사방탐색으로 이어질 수 있는 음식물 쓰레기 찾기.
			for(int d= 0 ; d < 4; d++) {
				int nr = n.r + drc[d][0];
				int nc = n.c + drc[d][1];
				//먼저 맵 밖으로 나가는지 체크 후 음식물 쓰레기인지 확인, 체크한 음식물 쓰레기인지 확인.
				if(outOfBounds(nr,nc) && space[nr][nc] == - 1 && !visited[nr][nc]) {
					//큐에 새로 담아줌.(음식물 쓰레기 하나 늘었으니 크기 1 증가.
					q.add(new Node(nr,nc));
					//방문 처리 해주기
					visited[nr][nc] = true;
					//하나 찾을 때 마다 cnt 추가(음식물 쓰레기 크기 증가)
					cnt++;
				}
			}
		}
		//음식물 쓰레기 크기 갱신해주는 IF문.
		if(cnt > answer)
			answer = cnt;
	}
	private static boolean outOfBounds(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}
}