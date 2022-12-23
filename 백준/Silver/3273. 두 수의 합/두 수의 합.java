import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//두 포인터를 사용해보자!
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); //수열의 크기 n을 저장해줍니다.
		int array[] = new int[n]; //수열을 담아줄 배열을 형성해줍니다.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken()); //수열에 각 수를 담아줍니다.
		}
		int x = Integer.parseInt(br.readLine()); //수열의 쌍의 합이 이 값을 만족해야함.
		Arrays.sort(array); //오름차순으로 정렬.
		int result = 0; //총 쌍의 개수를 담아줄 변수입니다.
		int start = 0; //포인터 시작위치
		int end = n-1;  //포인터 끝위치
		int sum = 0; //부분 배열의 합.
		while(start < end) {
			sum = array[start] + array[end]; //두수의 합을 먼저 체크해주고
			if(sum == x) { //두개가 같을시
				result++; //결과 값 1개 추가
			}
			if(sum <= x) { //합이 작거나 같을시엔 시작값 추가.
				start++; 
			}else { //합이 더 크다면 끝을 감소시켜줍니다.
				end--;
			}
		}
		System.out.println(result); //결과 쌍의 개수를 출력해줍니다.
	}
}