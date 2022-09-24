import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int team[][];
	static int min = Integer.MAX_VALUE;
	static int N;
	static boolean visited[];
	static int start[];
	static int link[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		visited = new boolean[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		back(0,0);
		System.out.println(min);
		
	}
	public static void back(int cnt ,int idx) {
		//이때 true인 애들과 false인 애들 나누어서 팀만들기.
		if(cnt==N/2) { //팀을 나누어야하므로 N/2와 idx가 같을시에 기저조건에 들어감.
			int S = 0; //스타트팀의 능력치합
			int L = 0; //링크팀의 능력치합.
			int result = 0;
			for(int i = 0; i<N-1; i++) {
				for(int j = i+1; j<N; j++) {
					if(i==j) 
						continue;
					if(visited[i] && visited[j]) { //둘다 참일시에 스타트팀증가.
						S += team[i][j] + team[j][i]; 
					}else if(!visited[i] && !visited[j]) { //둘다 거짓일시에 링크팀 증가. 
						L += team[i][j] + team[j][i];
					}else {
						continue; //둘이 다르면 같은팀이 될수없으므로 continue를 사용해주었다.
					}
					
				}
			}
			result = Math.abs(S-L); //둘의 능력치차를 절대값을 씌워주어 계산함.
			if(min > result) //만약 그때의 값이 현재의 최소값보다 작다면
				min = result; //최소값을 result에 저장.
			
			return;
		} 
		if(idx >= N) //만약idx가 N보다 큰 경우가 생길수있으니 그경우엔 return을 해주어 배열범위밖에 나가는 것을 방지.
			return;
		
			visited[idx] = true; //방문시에 참으로 변경
			back(cnt+1, idx+1); //cnt는 몇번째 방문인지 알려주고 idx는 어디위치인지 알려줌.
			visited[idx] = false; //방문안했어요~
			back(cnt, idx+1); //cnt는 그대로 보내고 idx만 하나 추가해서 보내준다.
	}
}