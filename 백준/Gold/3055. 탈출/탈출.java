import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node { //큐 안에 넣어줄 노드
		int r,c,cnt; 
		public Node(int r, int c, int cnt) {
			this.r = r; //행의 위치
			this.c = c; //열의 위치
			this.cnt = cnt; //현재 까지 걸린 시간
		}
	}
	static int R,C;
	static char map[][]; //map을 미리 생성(bfs함수에서도 사용하기위해.) D . * X 가 들어가므로 char형으로 만들어 주었다.
	static int dr[] = {0,0,-1,1}; //사방 탐색을 위해 dr, dc생성.
	static int dc[] = {-1,1,0,0};
	static Queue<Node> q; //고슴도치의 위치를 담아줄 큐
	static Queue<Node> water; //물의 위치를 담아줄 큐.
	static int result = 0; //결과값을 담아줄 변수.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //행의 개수
		C = Integer.parseInt(st.nextToken()); //열의 개수
		map = new char[R][C]; //맵 RXC생성
		q = new LinkedList<>(); //고슴도치 위치저장할 큐 생성
		water = new LinkedList<>(); //물의 위치 저장할 큐 생성
		for(int i = 0; i<R; i++) { //map을 채우기 위한 for문
			String s = br.readLine();
			for(int j = 0; j<C; j++) {
				map[i][j] = s.charAt(j); 
				if(s.charAt(j)=='S') //만약 이때 뽑아온 문자가 고슴도치라면 q에 저장
					q.add(new Node(i,j,0));
				if(s.charAt(j)=='*') //이때 뽑아온 문자가 물이라면 water에 저장.
					water.add(new Node(i,j,0));
			}
		}
		bfs(); //bfs사용.
		if(result == 0) { //result가 0이라는것은 결국 굴에 도달하지 못한것이므로 KAKTUS출력
			System.out.println("KAKTUS"); 
		}else { //0이 아닌것은 도달했으므로 결과값 result를 출력해준다.
			System.out.println(result);
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) { //고슴도치가 이동할수있는만큼 bfs이다. 더이상 이동못할시 while문 종료.
			int qsize = q.size(); //먼저 여태까지 이동했던 고슴도치의 수를 qsize변수에 담아준 후에
			for(int i = 0; i<qsize; i++) { //qsize만큼 for문을 돌려준다.
				Node n = q.poll(); //고슴도치 하나씩 빼면서 사방탐색.
				for(int d = 0; d<4; d++) {
					boolean flag = false; //내가 이동했을때 그 주위 사방에 물이 있는지 탐색하기위한 flag.
					int nr = n.r + dr[d];
					int nc = n.c + dc[d];
					if(!in(nr,nc)) //만약 범위 밖이라면 for문으로 다시 돌아감.
						continue;
					if(map[nr][nc]=='.' || map[nr][nc]=='D') {
						//이동할수 있는 범위가 .과 D만 가능.
						if(map[nr][nc]=='D') { //만약 굴에 도달했으면
							result = n.cnt+1; //이때의 결과값은 현재 이동시간 +1을 해주고
							return; //bfs함수를 끝내준다.
						}
						for(int a = 0; a<4; a++) { //굴에 아직 도달하지못했다면
							int nnr = nr + dr[a]; //이동한 위치에서 사방탐색해서 주위에 물이있는지 확인해주고
							int nnc = nc + dc[a];
							if(in(nnr,nnc) && map[nnr][nnc]=='*') { //범위내에 물이있을시
								flag = true; //flag를 true로 만들어 물이 있다는것을 알려주고 for문을 즉시 종료
								break;
							}
						}
						if(flag) { //flag가 true인 것은 갈수없다는 뜻이므로 다음 사방탐색을 해준다.
							continue;
						}else { //flag가 false면 갈수있으므로
							q.add(new Node(nr,nc,n.cnt+1)); //q에 새로운 위치와 이동거리를 한칸 추가시켜 담아주고
							map[nr][nc] = 'S'; //그 위치를 고슴도치 S로 변경해준다.
							
						}
					}				
				
				}
			}
			int watersize = water.size(); //이전에 물이 이동했던 개수만큼 사이즈를 저장해주고
			for(int i = 0; i < watersize; i++) { //위와마찬가지로 사이즈만큼 for문을 돌려준다.
				Node n = water.poll();
				for(int d = 0; d<4; d++) {
					int nr = n.r + dr[d];
					int nc = n.c + dc[d];
					if(in(nr,nc) && map[nr][nc]!='X' && map[nr][nc]!='D' && map[nr][nc]=='.') {
						//만약 범위내에 있으며 물은 돌과 굴에 갈수없고 아무것도 없거나 고슴도치가 있는곳을 갈수있으므로 위와같은 if문작성.
						map[nr][nc] = '*';
						//만약 if문 통과시 그 부분은 물에 잠기고
						water.add(new Node(nr,nc,0));
						//물이 이동했으므로 water에 추가.
					}
				}
			}
		}
		
	}
	private static boolean in(int nr, int nc) { //범위내에 있는지 알려주는 in함수이다.
		return (nr >= 0 && nr < R && nc >= 0 && nc < C);
	}
}