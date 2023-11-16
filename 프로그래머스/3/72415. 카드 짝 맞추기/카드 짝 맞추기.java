import java.util.*;

class Solution {
    static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static boolean num[] = new boolean[7];
	static boolean numvisited[] = new boolean[7];
	static int size = 0;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1,1};
	static int answer = Integer.MAX_VALUE;
    public int solution(int[][] board, int r, int c) {
        //총 몇개의 카드를 뒤집어야하는지 체크.
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				//0이 아니라면? cnt를 추가해준다.
				if(board[i][j] != 0) {
					size++;
					//그리고 1로 만들어 해당 부분을 0으로 변경
					num[board[i][j]] = true;
				}
			}
		}
		// 2를 나누어 총 몇개의 카드인지 확인
		size /= 2;
		//모든 경우의 수를 체크해서 그중에 가장 작은 답을 뽑아내야함.
		//그러기에는 BFS사용 및 순열을 사용.
		//순서를 저장해줄 order배열.
		int order[] = new int[size];
		permutate(0, board, order, r, c);
        return answer;
    }
    private static void permutate(int cnt, int[][] board, int[] order, int r, int c) {
		//총 크기가 같아진다면 순서가 정해진 것이니 bfs동작.
		if(cnt == size) {
			bfs(board, order, r, c);
			return;
		}
		//카드는 1~6까지 있으므로 모든 경우의 수 찾기.
		for(int i = 1; i <= 6; i++) {
			//없는 수거나, 이미 차례에 넣은 수라면 패스.
			if(!num[i] || numvisited[i])
				continue;
			//처음에 방문했으니 true로 바꿔주고
			numvisited[i] = true;
			//카드 순서를 저장해준다.
			order[cnt] = i;
			//다음.
			permutate(cnt + 1, board, order, r, c);
			//다시 방문 해제해주기.
			numvisited[i] = false;
		}
	}
	private static void bfs(int[][] board, int[] order, int r, int c) {
		//총 이동거리
		int result = 0;
		//카드 찾으러 갈때 이동횟수를 저장해줄 변수
		int cnt = 0;
		//위치를 담아줄 큐입니다.
		Queue<Node> q= new LinkedList<>();
		//큐에 현재 위치를 담아주자.
		q.add(new Node(r,c));
		//현재 순서를 나타내줄 idx변수
		int idx = 0;
		//최단거리 찾을때 방문했는지 체크할 배열.
		boolean visited[][] = new boolean[4][4];
		
		//이것은 발판을 2개 찾아야하니 2개 찾는거 확인 시켜줄 변수.
		boolean flag = false;
		
		//bvistied는 엔터 눌렀는지 안눌렀는지 체크해줄 boolean 2차원배열입니다.
		boolean bvisited[][] = new boolean[4][4];
		//큐가 다 빌때까지 돌리기.
		while(!q.isEmpty()) {
			//처음에 전체 큐 사이즈를 구한 다음 그에맞게 for문을 돌려주자.
			int length = q.size();
			
			for(int l = 0; l < length ; l++) {
				Node n = q.poll();
				//내 위치에 서있는지 체크해주는 부분입니다.
				//현재 위치가 순서에 맞는 번호인지 체크, 그리고 엔터를 누르지 않은 것이어야함.
				if(board[n.r][n.c] == order[idx] && !bvisited[n.r][n.c]) {
					//방문배열 초기화 시켜주어야함.
					visited = new boolean[4][4];
					//여기서 result를 증가시키는 이유는 엔터를 누르기 때문이다.
					result++;
					//그러고 이동거리 증가시켜주기.
					result += cnt;
					//어짜피 무조건 아래에서 +1을 해주기때문에 -1로 초기화를 시켜야한다.
					cnt = -1;
					//방문 체크.
					bvisited[n.r][n.c] = true;
					//다시 최단거리 이동위해 큐 비워주기.
					q.clear();
					//그러고서 현재 위치를 다시 큐에 담아두고?
					q.add(new Node(n.r, n.c));
					//방문 체크하기.
					visited[n.r][n.c] = true;
					//처음 발판이라면?
					if(!flag) {
						//다음번 flag를 찾을 수 있게 하자.
						flag = true;
					}else {
						flag = false;
						//다음 발판을 찾아야 하니 idx를 추가시켜주자.
						idx++;
						//발판을 다 찾았다면?
						if(idx == order.length) {
							//더 작은 결과 값이 answer에 저장되게 만들어준다.
							answer = Math.min(result, answer);
							return;
						}
					}
					break;
				}
				//한칸 씩 이동
				for(int d=0; d < 4; d++) {
					int nr = n.r + dr[d];
					int nc = n.c + dc[d];
					//배열 범위이내이며 방문하지 않았을때.
					if(outofSize(nr,nc) && !visited[nr][nc]) {
						//방문처리 해주고
						visited[nr][nc] = true;
						//큐에 담아주자.
						q.add(new Node(nr,nc));
					}
				}
				//컨트롤을 누르며 쭉 이동
				for(int d=0; d < 4; d++) {
					int nr = n.r;
					int nc = n.c;
					//범위 바깥으로 나갈때까지 while문 돌려주기
					while(outofSize(nr + dr[d], nc + dc[d])) {
						nr += dr[d];
						nc += dc[d];
						//근데 만약 아직 누르지 않은 말이 있다면 그 말에서 멈춰.
						if(!bvisited[nr][nc] && board[nr][nc] != 0) break;
					}
					
					if(outofSize(nr,nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Node(nr,nc));
					}
				}
			}
			//한번 이동이 끝날때마다 cnt를 증가시켜줍니다.
			cnt++;
		}
		
	}
	private static boolean outofSize(int nr, int nc) {
		if(nr >= 0 && nr < 4 && nc >=0 && nc <4) return true;
		return false;
	}
}