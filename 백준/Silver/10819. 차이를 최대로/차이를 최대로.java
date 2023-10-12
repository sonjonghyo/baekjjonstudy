import java.io.*;
import java.util.*;

public class Main {
	static int result = Integer.MIN_VALUE;
	static int N;
	static int A[];
	static boolean visited[];
	static int select[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		select = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] =  Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(result);
	}
	private static void dfs(int cnt) {
		if(cnt == N) { //기저조건
			result = Math.max(sumArray(), result);
			return;
		}
		
		for(int i = 0; i < N; i++) { //배열안에 수를 넣어주기 위해 0번째부터 시작.
			if(!visited[i]) {
				visited[i] = true;
				select[cnt] = A[i];
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
	}
	private static int sumArray() {
		int sum = 0;
		for(int i = 0; i < N-1; i++) {
			sum += Math.abs(select[i] - select[i + 1]);
		}
		return sum;
	}
}