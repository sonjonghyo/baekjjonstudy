import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static int jackpot[] = new int[6];
	static int arr[];
	static int T;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			if(T==0)
				break;
			arr = new int[T];
			visited = new boolean[T];
			for(int i = 0; i<T; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			DFS(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void DFS(int idx) {
		if(idx==6) { //idx가 7이라는 것은 수가 6개를 담겼다는 것을 이미.
			for(int i = 0; i<6; i++) {
				sb.append(jackpot[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		if(idx>=T) //만약 idx가 T보다 크거나 같으면 return시켜주어야함.(배열의 범위밖이므로)
			return;
		
		for(int i = 0; i<T; i++) {
			if(!visited[i]) {
				if(idx>0 && jackpot[idx-1] > arr[i])
					continue;
				visited[i] = true;
				jackpot[idx] = arr[i];
				DFS(idx+1);
				visited[i] = false;
			}
		}
		
	}
}