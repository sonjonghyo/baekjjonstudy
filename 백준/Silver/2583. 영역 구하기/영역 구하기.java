import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K;
	static int maxArea = 0;
	static boolean visited[][];
	static int square[][];
	static int dr[] = {0,0, -1, 1};
	static int dc[] = {-1,1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //직사각형 가로의 길이
		N = Integer.parseInt(st.nextToken()); //직사각형 세로의 길이
		K = Integer.parseInt(st.nextToken()); //사각형의 개수
		square = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int r = x1; r < x2; r++) {
				for(int c = y1; c < y2; c++) {
					square[r][c] = 1; //범위 내에 있는 건 전부 1로 바꾸어줍니다.
				}
			}
		}
		List<Integer> area = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && square[i][j] == 0) { //방문하지않았고 0이어야 내가 들어갈수 있는 공간.
					maxArea = 1; //우선 나 자신부터이므로 공간은 1로 시작.
					visited[i][j] = true; //방문처리해줍니다.
					searchArea(i,j); //주변을 탐색해서 영역을 구해줍니다.
					area.add(maxArea); //리스트에 총 공간을 구해줍니다.
				}
			}
		}
		Collections.sort(area); //리스트를 정렬해줍니다.
		sb.append(area.size()).append("\n"); //먼저 사이즈를 저장하는 것은 사이즈가 총 나눈 구역의 개수이므로 저장해줍니다.
		for(int i = 0; i < area.size(); i++) { //그러고 사이즈만큼 반복문으로 돌며
			sb.append(area.get(i)).append(" "); //앞번호 부터 차례대로 StringBuilder에 넣어줍니다.
		}
		System.out.println(sb); //출력
		
	}
	private static void searchArea(int r, int c) {
		for(int d = 0; d < 4; d++) { //사방탐색으로 주위가 막혀있는지 확인해줍니다.
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(OutOfArange(nr, nc)) { //범위 내부일시에만 동작하게해줌.
				if(square[nr][nc] == 0) { //그리고 0인 경우만 탐색할 수 있으므로 조건문 설정.
					if(!visited[nr][nc]) { //방문처리가 안된 곳이라면?
						visited[nr][nc] = true; //방문처리해주며
						searchArea(nr, nc); //다시 dfs해주고
						maxArea++; //공간 추가.
					}
				}
			}
		}
	}
	private static boolean OutOfArange(int nr, int nc) { //범위를 벗어났는지 확인.
		return (nr >= 0 && nr < N && nc >= 0 && nc < M);
	}
}