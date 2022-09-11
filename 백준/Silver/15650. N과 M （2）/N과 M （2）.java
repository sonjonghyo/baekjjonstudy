import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int search[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		search = new int[M];
		backtracking(1, 0);
		System.out.println(sb);
	}
	public static void backtracking(int idx, int depth) { //오름차순으로 넣기.
		if(depth==M) { //만약 현재 재귀한 횟수가 M과 같다면
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
		for(int i = idx ; i<=N; i++) { //오름차순으로 하기 위해 사용함.
			search[depth] = i; //search의 깊이부분에 i를 넣어줌.
			backtracking(i+1, depth+1); //다음수 탐색
		}
	}
}