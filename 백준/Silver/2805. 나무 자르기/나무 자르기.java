import java.io.*;
import java.util.*;

public class Main {
	static int max  = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int tree[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			//최댓값 설정
			if(tree[i] > max) {
				max = tree[i];
			}
		}
		System.out.println(searchMax(N, M, tree));
	}
	private static int searchMax(int n, int m, int[] tree) {
		int left = 0;
		int right = max;
		while(left <= right) {
			//중간값 설정.
			int mid = (left + right) / 2;
			long sum = 0;
			for(int i = 0; i < n; i++) {
				//만약 나무의 길이가 mid값보다 크면 자를수 있는게 생김.
				if(tree[i] > mid) {
					sum +=  tree[i] - mid;
				}
			}
			if(sum >= m) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return right;
	}
}