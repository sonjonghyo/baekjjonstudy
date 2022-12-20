import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char campus[][]; //캠퍼스의 크기.
	static boolean visited[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int N, M;
	static int visitHuman;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //캠퍼스 세로의 크기
		M = Integer.parseInt(st.nextToken()); //캠퍼스 가로의 크기
		
		campus = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine(); //배열에 사람, 공간, 벽 담아줌.
			for(int j = 0; j < M; j++) {
				campus[i][j] = s.charAt(j); //빈 공간, 벽, 사람, 도연이를 담아줍니다.
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) { 
				if(campus[i][j] == 'I') { //도연이가 사람을 만날수 있는지 확인.
					visited[i][j] = true; //방문처리해주고
					checkFriend(i,j); //주변에 친구가 있는지 찾아줍니다.
				}
			}
		}
		if(visitHuman != 0) { //만약 만난사람이 있다면?
			System.out.println(visitHuman); //만난사람의 수 출력
		}else { //만난사람이 없는경우엔?
			System.out.println("TT"); //TT를 출력해줍니다.
		}
	}

	private static void checkFriend(int r, int c) {
		for(int d = 0; d <4; d++) { //사방탐색을 해줍니다.
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(outOfRange(nr,nc)) { //배열 밖으로 나가는지 확인해줍니다.
				if(!visited[nr][nc]) { //방문하지 않았다면?
					if(campus[nr][nc] == 'P') { //사람을 만났다면?
						visited[nr][nc] = true; //방문처리해주고
						visitHuman++; //만난사람수 추가.
						checkFriend(nr,nc); //다시 사람찾기 시작.
					}
					if(campus[nr][nc] == 'O') { //빈 공간이라면?
						visited[nr][nc] = true; //방문처리해주고
						checkFriend(nr,nc); //그곳에서 사람찾기 시작.
					}					
				}
			}
		}
	}	
	private static boolean outOfRange(int nr, int nc) { //배열 벗어나는지 확인.
		return (nr >= 0 && nr < N && nc >= 0 && nc < M);
	}
}