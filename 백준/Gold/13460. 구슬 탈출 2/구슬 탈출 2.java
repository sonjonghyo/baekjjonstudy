import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//빨간구슬 기준으로 상하좌우 판별해서 움직일수있는지 없는지 확인.
	static class Node {
		int r,c,cnt;
		
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int N,M;
	static int result = -1;
	static char map[][]; //
	static boolean visited[][][][]; //방문했는지 안했는지 찾아주는 visited배열.
	static int dr[] = {-1,1,0,0}; //상하좌우 판별
	static int dc[] = {0,0,-1,1};
	static Queue<Node> red = new LinkedList<>();
	static Queue<Node> blue = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로의 길이
		M = Integer.parseInt(st.nextToken()); //가로의 길이.
		map = new char[N][M]; //NxM 크기의 map배열 생성.
		visited = new boolean[N][M][N][M];
		for(int i = 0; i <N; i++) {
			String s = br.readLine(); //한줄씩 받아와서
			for(int j = 0 ; j<M; j++) {
				map[i][j] = s.charAt(j); //그 문자열에 해당하는 하나의 단어씩 map에 넣어준다.
				if(map[i][j] == 'R') {
					red.add(new Node(i,j,0)); //R의 현재위치를 red라는 큐에 넣어주고 현재 이동시간은 0으로 저장해준다
				}else if(map[i][j] == 'B') {
					blue.add(new Node(i,j,0)); //B도 마찬가지.
				}
			}
		}
		BFS();
		System.out.println(result);
	}
	private static void BFS() {
		while(!red.isEmpty() && !blue.isEmpty()) { //둘중 하나라도 비면 while문이 끝나게 함.
			Node r = red.poll();
			Node b = blue.poll();
			
			visited[r.r][r.c][b.r][b.c] = true; //빨간구슬 파란구슬 방문처리.
			
			if(r.cnt > 10) { //10번초과로 굴렸을경우엔
				result = -1; //횟수초과이므로 -1 저장해주고 return해준다.
				return;
			}
			
			if(map[b.r][b.c]=='O') //파란색이 빠져나간 경우에
				continue;
			
			if(map[r.r][r.c] == 'O') { //빨간공이 구멍에 들어갔을경우에.
				result =  r.cnt; //그때의 횟수를 result값에 담아주고 return해준다.
				return;
			}
			
			for(int d = 0; d<4; d++) { //사방탐색 시작.
				 // 기울였을때 빨간 구슬이 도달하는 지점으로 이동
                int rnr = r.r;
                int rnc = r.c;
                while(true) {
                    rnr += dr[d];
                    rnc += dc[d];
                    // 빠져나간 경우
                    if(map[rnr][rnc] == 'O') break;
                    // 벽을 만난 경우
                    else if(map[rnr][rnc] == '#'){
                        rnr -= dr[d];
                        rnc -= dc[d];
                        break;
                    }
                }
                
                // 기울였을때 파란 구슬이 도달하는 지점으로 이동
                int bnr = b.r;
                int bnc = b.c;
                while(true) {
                    bnr += dr[d];
                    bnc += dc[d];
                    // 빠져나간 경우
                    if(map[bnr][bnc] == 'O') break;
                    // 벽을 만난 경우
                    else if(map[bnr][bnc] == '#'){
                        bnr -= dr[d];
                        bnc -= dc[d];
                        break;
                    }
                }
                
                
                //빨간공과 파란공의 위치가 같을때.(구멍에 들어가지 않고.)
                if(rnr == bnr && rnc == bnc && map[rnr][rnc] != 'O') {
                    // 이동한 거리가 더 긴 쪽이 덜 이동하게 처리
                    int r_dis = Math.abs(r.r - rnr) + Math.abs(r.c - rnc);
                    int b_dis = Math.abs(b.r - bnr) + Math.abs(b.c - bnc);

                    // 빨간 구슬이 더 이동한 경우(같은곳에 있을수없으므로 한칸 덜 가야한다.)
                    if(r_dis > b_dis) {
                        rnr -= dr[d];
                        rnc -= dc[d];
                    }
                    // 파란 구슬이 더 이동한 경우
                    else {
                        bnr -= dr[d];
                        bnc -= dc[d];
                    }
                }
                
                // 기울였을때 구슬들이 도달하는 지점을 방문 처리 후 큐에 추가 - 두 구슬 중 이전과 하나라도 다르다면 다른결과가 있을수 있음
                if(!visited[rnr][rnc][bnr][bnc]) {
                    // 방문처리
                    visited[rnr][rnc][bnr][bnc] = true;
                    // 두 구슬을 큐에 추가
                    red.add(new Node(rnr, rnc, r.cnt + 1));
                    blue.add(new Node(bnr, bnc, b.cnt + 1));
                }                 
			}
			
		}
	}
			
}