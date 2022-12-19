import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int Drawing[][]; //그림의 크기
	static int dr[] = {-1, 1, 0, 0}; //상하좌우
	static int dc[] = {0, 0, -1, 1};
	static boolean visited[][]; //방문처리배열
	static int maxSum = 0; //가장 큰 크림의 넓이
	static int drawSize = 0; //그림의 크기.
	static int n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //세로의 크기
		m = Integer.parseInt(st.nextToken()); //가로의 크기
		Drawing = new int[n][m]; //도화지의 크기를 설정해줍니다.
		visited = new boolean[n][m]; //방문처리배열의 크기를 설정해 줍니다.
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				Drawing[i][j] = Integer.parseInt(st.nextToken()); //1과 0을 넣어주는 for문 입니다.
			}
		}
		int draw = 0; //그림의 개수.
		for(int i = 0; i < n; i++) { //그림 전부를 탐색해줍니다.
			for(int j = 0; j < m; j++) {
				if(Drawing[i][j] == 1 && !visited[i][j]) { //만약 그림의 위치에서 1이고 방문하지않았다면?
					visited[i][j] = true; //방문처리해주고
					draw++; //그림의 개수를 1개 늘려줍니다.
					drawSize = 1; //그러고 현재 그림의 크기를 1로 설정해주고
					checkDraw(i,j); //사방으로 그림을 찾아 나섭니다.
				}
				if(maxSum < drawSize) //만약 그림의 크기가 전체 그림의 크기보다 크다면?
					maxSum = drawSize; //제일 큰 그림의 사이즈를 변경해줍니다.
			}
		}
		System.out.println(draw);
		System.out.println(maxSum);
	}
	private static void checkDraw(int r, int c) {
		for(int d = 0; d < 4; d++) { //사방탐색을 시작합니다.
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(OutOfRange(nr,nc)) { //범위를 벗어났는지 확인해줍니다.
				if(Drawing[nr][nc] == 1 && !visited[nr][nc]) { //먼저 그림인지 확인을 해주고 그 다음 방문처리 되어있는지 확인을 해줍니다.
					visited[nr][nc] = true; //조건에 맞을시 방문처리를 해주고
					drawSize++; //그림의 크기를 눌려주며
					checkDraw(nr,nc); //새로 사방에 그림을 찾아나섭니다.
				}
			}
		}
	}
	
	private static boolean OutOfRange(int nr, int nc) {
		return (nr >= 0 && nr < n && nc >= 0 && nc < m);
	}
}