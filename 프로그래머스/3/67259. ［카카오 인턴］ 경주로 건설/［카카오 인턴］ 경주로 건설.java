import java.util.*;

class Solution {
    static class Node {
		int r;
		int c;
		int prevr;
		int prevc;
		int money;
		public Node(int r, int c, int prevr, int prevc ,int money) {
			this.r = r;
			this.c = c;
			this.prevr = prevr;
			this.prevc = prevc;
			this.money = money;
		}
	}
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int dp[][];
    public int solution(int[][] board) {
        int answer = 0;
        dp = new int[board.length][board.length];
		//dp 2차원 배열 벽 제외 가장 큰 값으로 교체 하기.
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == 1) continue;
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		//처음 시작할 땐 0원부터 시작.
		dp[0][0] = 0;
		answer = bfs(board);
        return answer;
    }
    private static int bfs(int[][] board) {
		//현재까지 든 최저 금액
		int nowMoney = Integer.MAX_VALUE;
		Queue<Node> q = new LinkedList<>();
		//처음 시작 지점을 큐에 담아 줍니다.
		q.add(new Node(0,0,-1,-1,0));
		
		//큐가 다 빌때 까지 돌려.
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.r == board.length - 1 && n.c == board.length - 1) {
				//끝까지 도달했을때 현재 금액이 더 싸다면?
				if(n.money < nowMoney) {
					//현재 금액 최저금액으로 변경 후 while문 다시 시작.
					nowMoney = n.money;
					continue;
				}
			}
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				//밖으로 나갔거나, 이미 지나온 경로거나 막혀있는 곳이라면?
				if(nr < 0 || nr >= board.length || nc < 0 || nc >= board.length || board[nr][nc] == 1)
					//다음
					continue;
				//기본적으로 직선도로 까는데 드는 비용 100원.
				int cost = 100;
				//이전에 아무것도 없으면 일단 100원. 그리고 두개의 값이 둘다 바뀌었다면?
				if(n.prevr != -1 && n.prevc != -1 && n.prevr != nr && n.prevc != nc) {
					//회전한 것. 500원 추가.
					cost += 500;
				}
				//현재 금액 추가.
				cost += n.money;
				//현재 dp에 들어간 금액보다 cost가 더 싸거나 같다면?
				if(dp[nr][nc] >= cost) {
					//dp 배열에 cost변경.
					dp[nr][nc] = cost;
					//큐에 추가.
					q.add(new Node(nr,nc,n.r,n.c,cost));
				//만약 cost보단 작지만 현재 들어가있는 금액 + 500 (즉 회전 값)보단 작다면 큐에는 넣어주기.
				}else if(dp[nr][nc] + 500 >= cost) {
					q.add(new Node(nr,nc,n.r,n.c,cost));
				}
			}
		}
		return nowMoney;
	}
}