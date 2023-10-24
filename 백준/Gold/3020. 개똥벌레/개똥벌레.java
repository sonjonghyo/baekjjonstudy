import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int caveh[] = new int[N/2];
		int cavej[] = new int[N/2];
		int result = 0;
        //최소값은 현재 종유석의 개수로 설정.
		int min = N;
		for(int i = 0; i < N; i++) {
			//홀수번째 짝수번째 나누어서 저장해줍니다.
			if(i%2==0) {
				cavej[i/2] = Integer.parseInt(br.readLine());				
			}else {
				caveh[i/2] = Integer.parseInt(br.readLine());
			}
		}
		//이분탐색을 위해 오름차순 정렬.
		Arrays.sort(cavej);
		Arrays.sort(caveh);
		//높이 1부터 끝까지 전부 부셔보기.
		for(int i = 1; i <= H; i++) {
			int collide = binarySearch(cavej, 0, N/2, i) + binarySearch(caveh, 0, N/2, H-i+1);
			//부순 장애물의 개수가 더 적은 것 발생.
			if(collide < min) {
				min = collide;
				result = 1;
			//부순 장애물과 이전 부순 것의 개수가 같다면?
			}else if(collide == min) {
				//result값 추가.
				result++;				
			}
		}
		System.out.println(min + " " + result);
		
	}
	private static int binarySearch(int[] cave, int lo, int hi, int h) {
		//장애물 부순 갯수(굳이 계산 안해줘도 됌. 마지막에 총길이에 hi 빼면됌.
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if(cave[mid] >= h) {
				hi = mid;
			}else {
				lo = mid + 1;
			}
		}
		return cave.length - hi;
	}
}