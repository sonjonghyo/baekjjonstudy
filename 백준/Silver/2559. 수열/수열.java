import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //온도를 측정한 날짜의 수
		int K = Integer.parseInt(st.nextToken()); //합을 구하기 위한 연속적인 날짜
		
		int temparature[] = new int[N]; //온도를 담아줄 배열입니다.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) { 
			temparature[i] = Integer.parseInt(st.nextToken()); //온도를 담아주자.
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		while(true) {
			sum += temparature[end];
			if(end-start == K) { //초과했으면?
				sum -= temparature[start++];
			}
			if(end-start == K-1) { //연속 날짜에 도달했다면?
				if(max < sum) //만약 최댓값이라면? 끝내주기.
					max = sum;
			}
			if(end == N-1) //끝에 도달한다면 while문 끝내주기
				break;
			
			end++; //끝부분 추가
		}
		System.out.println(max);
	}
}