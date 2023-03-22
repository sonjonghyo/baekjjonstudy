import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Node {
		int x;
		int y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static boolean checked[][];
	static Queue<Node> q = new LinkedList<>();
	static int dr[] = {-1,1,0, 0};
	static int dc[] = {0, 0,-1, 1};
	static int answer = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        int curx = 0;
		int cury = 0;
		checked = new boolean[maps.length][maps[0].length];
		checked[0][0] = true;
		q.add(new Node(curx, cury, 1));
		startBFS(maps.length, maps[0].length ,maps);
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
        return answer;
    }
    private static void startBFS(int N, int M, int maps[][]) {
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.x == N-1 && n.y == M-1) {
				if(answer > n.cnt) {
					answer = n.cnt;
					continue;
				}
			}
			for(int d = 0; d < 4; d++) {
				int nr = n.x + dr[d];
				int nc = n.y + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(!checked[nr][nc] && maps[nr][nc] == 1) {
						checked[nr][nc] = true;
						q.add(new Node(nr, nc, n.cnt + 1));
					}
				}
			}
		}
	}
}