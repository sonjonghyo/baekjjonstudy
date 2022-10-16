import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int tree[];
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
		}
		Arrays.sort(tree);
		result = binarysearch();
		System.out.println(result);
	}
	private static int binarysearch() {
		int left = 0;
		int right = tree[N-1];
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