import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int num[] = {1,5,10, 50};
	static boolean sum[] = new boolean[1001];
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs(0,0,0);
		System.out.println(result); //합의 개수
	}
	private static void dfs(int dep, int idx, int realsum) {
		if(dep==N) { //깊이가 N까지 내려왔을때에
			if(!sum[realsum]) { //그때 만약 내 합이 그동안 나온것이 없다면?
				sum[realsum] = true; //이제 사용했으니 true로 바꿔준후에
				result++; //결과를 하나 추가해준다.
			}
			
			return;
		}
		
		for(int a = idx; a<4; a++) { //idx번째 부터 총 1,5,10,50있는거 확인.
			dfs(dep+1, a, realsum + num[a]); //깊이는 하나 내려가고 idx는 a를 주고 합은 realsum에 num의 a번째를 더해줌.
		}
	}	
}