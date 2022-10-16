import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int tree[];
	static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int result = 0;
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] > max)
				max = tree[i];
		}
		result = binarysearch();
		System.out.println(result);
	}
	private static int binarysearch() {
		int left = 0;
		int right = max;
		while(left <= right) {
			int mid = (left+right)/2;
			long sum = 0;
			for(int i = 0; i<N; i++) {
				if(tree[i] > mid)
					sum += tree[i] - mid;
			}
			if(M <= sum) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return right;
	}
}