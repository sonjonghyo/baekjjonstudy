import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//배열에 있는 값 하나를 1 증가
//배열 모든 값 2배
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //배열의 크기
		int num[] = new int[N];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken()); //배열에 값 집어넣기.
			sum += num[i]; //먼저 합 누적시켜주기.
		}	
		int answer = 0;
		int count = 0;
		while(sum != 0) {
			count = 0;
			for(int i = 0; i < N; i++) {
				if(num[i] % 2 == 1) { //하나라도 홀수가 있다면?
					num[i]--;
					count++;
				}
			}
			if(count != 0) { //홀수가 1개라도 있으면?
				sum -= count;
				answer += count;
			}else { //전부 짝수라면?
				for(int i = 0; i < N; i++) {
					num[i] /= 2;
				}
				sum /= 2;
				answer++;
			}
		}
		System.out.println(answer);	
	}
}