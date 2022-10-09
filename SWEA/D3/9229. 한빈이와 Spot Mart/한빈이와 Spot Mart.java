import java.util.Scanner;

public class Solution {
	static boolean visited[];
	static int snack[];
	static int N,M;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			max = -1;
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt(); //과자봉지의 개수
			M = sc.nextInt(); //최대로 들수있는 개수 (무조건 두봉지 사야함.)
			
			snack = new int[N]; //과자봉지의 무게를 담을 배열
			visited = new boolean[N]; //들었는지 안들었는지 확인.
			for(int i = 0; i<N; i++) {
				snack[i] = sc.nextInt();
			}
			
			dfs(0,0);
			sb.append(max);
			if(tc!=T)
				sb.append("\n");
			
		}
		System.out.println(sb);
		sc.close();
	}

	private static void dfs(int idx, int cnt) {
		if(cnt==2) {
			int sum = 0;
			for(int i = 0; i<N; i++) {
				if(visited[i])
					sum += snack[i];
			}
			if(max < sum && sum <= M)
				max = sum;
			return;
		}
		
		for(int i = idx; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, cnt+1);
				visited[i] = false;
			}
		}	
	}
}