import java.util.*;

class Solution {
    static class Node {
		int r;
		int c;
		int dir;
		int time;
		public Node(int r, int c, int dir, int time) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.time = time;
		}
	}
	//상하좌우 이동.
	static int drc[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static int answer = 0;
	//가로에서 세로 회전할때 바뀌는 점.
	static int rrc[][] = {{0,1},{0,0},{-1,1},{-1,0}};
	//회전하면서 벽에 걸리는지 체크해야할 부분 확인.
	static int checkrrc[][] = {{1,0},{1,1},{-1,0},{-1,1}};
	//세로에서 가로 회전할때 바뀌는 점.
	static int crc[][] = {{0,0},{0,-1},{1,0},{1,-1}};
	static int checkcrc[][] = {{1,1},{1,-1},{0,1},{0,-1}};
	//가로방향 세로방향에 대해서 visited.
	static boolean visited[][][];
	static Queue<Node> q;
    public int solution(int[][] board) {
        q = new LinkedList<>();
		visited = new boolean[board.length][board.length][2];
		q.add(new Node(0,0,0,0));
		visited[0][0][0] = true;
		bfs(board);
        return answer;
    }
    private static void bfs(int[][] board) {
		while(!q.isEmpty()) {
			Node n = q.poll();
			//만약 끝에 도달했다면 저장.
			//가로일때에는 세로 + 1
			//세로일때는 가로 + 1
			if((n.dir == 0 && n.r == board.length-1 && n.c + 1 == board.length - 1) || (n.dir == 1 && n.r + 1 == board.length - 1 && n.c == board.length - 1)) {
				answer = n.time;
				break;
			}
			//먼저 상하좌우 이동부터.
			for(int d = 0; d < 4; d++) {
				int nr = n.r + drc[d][0];
				int nc = n.c + drc[d][1];
				//다음방향으로 갈수 있는지 체크.
				if(check(nr,nc,n.dir,board)) {
					//방문체크 해주고.
					visited[nr][nc][n.dir] = true;
					//다음지점 큐에 담아주기.
					q.add(new Node(nr,nc,n.dir,n.time + 1));
				}
			}
			//회전 가능한지 체크해서 넣어주기.
			//먼저 가로라면? 세로로 회전가능한지 체크.
			if(n.dir == 0) {
				for(int d = 0; d < 4; d++) {
					int nr = n.r + rrc[d][0];
					int nc = n.c + rrc[d][1];
					//회전이 가능하면서 벽에 막히는지 체크.
					if(check(nr,nc,1,board) && board[n.r+checkrrc[d][0]][n.c + checkrrc[d][1]] == 0) {
						visited[nr][nc][1] = true;
						q.add(new Node(nr,nc,1,n.time + 1));
					}
				}
			//세로라면? 가로로 회전가능한지 체크.
			}else {
				for(int d = 0; d < 4; d++) {
					int nr = n.r + crc[d][0];
					int nc = n.c + crc[d][1];
					//회전이 가능하면서 벽에 막히는지 체크.
					if(check(nr,nc,0,board) && board[n.r+checkcrc[d][0]][n.c + checkcrc[d][1]] == 0) {
						visited[nr][nc][0] = true;
						q.add(new Node(nr,nc,0,n.time + 1));
					}
				}
			}
		}
		
	}
	private static boolean check(int nr, int nc, int dir, int board[][]) {
		//범위 밖으로 나가거나, 방문했거나, 벽이라면 멈춰.
		if(nr < 0 || nr >= board.length || nc < 0 || nc >= board.length || visited[nr][nc][dir] || board[nr][nc] == 1)
			return false;
		//가로이면서 내 다음 칸이 바깥으로 나가거나 벽에 부딪힌다면 못가.
		if(dir == 0 && (nc + 1 >= board.length || board[nr][nc + 1] == 1))
			return false;
		//세로이면서 내 다음 칸이 바까틍로 나가거나 벽에 부딪히면 못가.
		if(dir == 1 && (nr + 1 >= board.length || board[nr+1][nc] == 1))
			return false;
		//위의 조건을 다 뚫었을때 이동 가능.
		return true;
	}
}