class Solution {
    static String answer = "impossible";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(n,m,x-1,y-1,r-1,c-1,k, 0, "");
        return answer;
    }
    private static void dfs(int n, int m, int x, int y,int r, int c,int k, int cnt, String order) {
		//만약 답이 나왔다면? = 더이상 볼 필요가 없다.
		if(!answer.equals("impossible")) {
			return;
		}
		
		//만약 만약 현재 위치와 가야할 위치가 같고 이동거리까지 같으면 answer 변경
		if(x == r && y == c && k == cnt) {
			answer = order;
			//더이상 볼 필요가 없으므로 return.
			return;
		}
		
		//갈수있는지 체크해주는 변수. (갈수 있으면 true 없으면 false)
		if(check(n, m, x, y, r, c, k, cnt, order)) {
			
			//알파벳 순으로 하 : d 좌 : l 우 : r 상 : u
			dfs(n,m,x+1,y,r,c,k, cnt+1, order+"d");
			dfs(n,m,x,y-1,r,c,k, cnt+1, order+"l");
			dfs(n,m,x,y+1,r,c,k, cnt+1, order+"r");
			dfs(n,m,x-1,y,r,c,k, cnt+1, order+"u");
		}
	}
	private static boolean check(int n, int m, int x, int y, int r, int c, int k, int cnt, String order) {
		//범위 밖으로 나간 경우.
		if(x < 0 || x >= n || y < 0 || y >= m)
			return false;
		
		//가야할 남은 거리를 구합니다.
		int dis = Math.abs(r - x) + Math.abs(c - y);
		
		//갈 수 있는 거리가 부족하다면 그것도 못감.
		if(k - cnt < dis)
			return false;
		
		//갈 수 있는 거리와 남은거리의 홀 짝이 다를 경우 도달할 수 가 없다.
		if((k - cnt - dis) % 2 == 1)
			return false;	
		
		return true;
	}
}