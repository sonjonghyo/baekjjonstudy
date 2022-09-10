import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static boolean check[];
	static int search[];
	static int bcnt;
	static int cnt = 1;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		search = new int[M];
		check = new boolean[N];
		backtracking(0);
		System.out.println(sb);
	}
	public static void backtracking(int depth) {
		if(depth==M) { //만약 현재 재귀한 횟수가 M과 같다면
			bcnt++;
			//depth는 깊이를 따지는데 M의 값이 깊이를 결정해주므로 그 값과 같을시에 그동안에 search에 저장된 값들을 뽑아줌
			for(int i = 0; i<search.length; i++) {
				if(i!=search.length-1) {
					sb.append(search[i]).append(" ");					
				}else {
					sb.append(search[i]);
				}
			}
			sb.append("\n"); //마지막은 개행문자.					
			return; //현재 돌고있는 백트래킹함수를 끝내준다.
		}
		for(int i = 0; i<N; i++) {
			if(!check[i]) { //한번도 방문하지 않은 곳이라면 탐색시작
				check[i] = true; //탐색이 들어가면 바로 true로 만들어줌.
				search[depth] = i+1; 
				//search에 저장되는 값들은 깊이에 따라 갯수가 정해짐. M의 값이 1개면 1개저장 2개면 2개저장 이런식이 된다.
				backtracking(depth+1); //다음수 탐색.
				check[i] = false; //탐색이 끝났으므로 false로 다시 탐색할수있게 만들어줌.
			}
		}
	}
}