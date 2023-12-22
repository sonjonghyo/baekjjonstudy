import java.io.*;
import java.util.*;

public class Main {
	static int N, M; 
	static long right;
	static long cable[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//랜선의 개수
		N = Integer.parseInt(st.nextToken());
		//필요한 랜선의 개수
		M = Integer.parseInt(st.nextToken());
		cable = new long[N];
		for(int i = 0; i < N; i++) {
			cable[i] = Integer.parseInt(br.readLine());
			//이분탐색 할때 오른쪽 최대값 설정하기.
			if(right < cable[i])
				right = cable[i];
		}
		//이분 탐색.
		System.out.println(binarySearch());
	}
	private static long binarySearch() {
		//왼쪽은 0 으로 설정
		long left = 1;
		//자른 랜선의 개수
		int cnt = 0;
		long answer = 0;
		while(left <= right) {
			//중간값 설정.
			long mid = (left + right) / 2;
			cnt = 0;
			//선 잘라서 더하기.
			for(int i = 0; i < N; i++) {
				cnt += (cable[i] / mid);
			}
			//다 하고나서 만약 자른 개수가 필요한 M개보다 많거나 같다면?
			if(cnt >= M) {
				left = mid + 1;
			//M개보다 적다면?(더 늘려줘야지.)
			}else {
				right = mid - 1;
			}
		}
		answer = right;
		return answer;
	}
}