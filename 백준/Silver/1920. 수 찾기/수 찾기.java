import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//배열의 크기 N
		int N = Integer.parseInt(br.readLine());
		//정수들을 담을 배열 num 선언
		int num[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		//이분탐색을 위해 먼저 num을 정렬해 준다.
		Arrays.sort(num);
		
		int M = Integer.parseInt(br.readLine());
		int check[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < M; i++) {
			//왼쪽은 0번째
			int left = 0;
			//오른쪽은 배열의 가장 마지막 번째
			int right = N-1;
			//flag를 사용해 true로 바뀌면 찾은거로 1 출력 아니면 0 출력
			boolean flag = false;
			//왼쪽보다 오른쪽이 더 커지면 끝.
			while(left <= right) {
				//먼저 중간 지점을 구한다.
				int mid = (left + right) / 2;
				//만약 해당 위치의 값이 검사해야하는 값보다 크다면?
				if(num[mid] > check[i]) {
					right = mid - 1;
				//반대로 위치의 값보다 작다면?
				}else if(num[mid] < check[i]) {
					left = mid + 1;
				//두개의 값이 같다면?
				}else {
					//flag를 true로 만들어주고 끝낸다.
					flag = true;
					break;
				}
			}
			if(flag) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}
}