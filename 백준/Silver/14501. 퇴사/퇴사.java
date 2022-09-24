import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int N;
	static int max = Integer.MIN_VALUE;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][2];
		visited = new boolean[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		perms(1,sum);
		System.out.println(max);
		
	}
	public static void perms(int idx, int sum) {
		if(idx>N+1) //idx가 N보다 클시엔 수행이 안되므로
			return; //return시켜준다.
		if(idx<=N+1) { //N보다 작을시엔
			if(max < sum) //현재까지 더해준 sum이 max보다 작을시에
				max = sum; //max에 sum을 더해줌.
		}
		
		for(int i = idx; i<=N; i++) {
			if(!visited[i]) { //아직 방문을 안했어야 들어감.
				int t = arr[i][0] + i; //현재 가능한시점에서 얼마나 시간이 걸리는지 계산.
				if(t>N+1) //만약 시간이 넘어가는건 수행할수없으므로 return시켜준다.
					continue;
				for(int r = i; r<t; r++) { //수행한 시간은 전부 true로 바꿔줌.
					visited[r] = true;
				}
				sum += arr[i][1]; //처음 시작한 부분을 sum에 추가시켜준다.
				perms(i+1, sum); //다음 idx를 다시 재시행.
				for(int r = i; r<t; r++) { //방문한부분을 다시 false로 만들어줌.
					visited[r] = false;
				}
				sum -= arr[i][1];
				perms(i+1, sum);
			}
		}
			
	}
}