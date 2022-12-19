import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //슬라임의 개수.
		int slime[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			slime[i] = Integer.parseInt(st.nextToken()); //슬라임 저장.
		}
		Arrays.sort(slime); //오름차순으로 정렬해줍니다.
		int maxScore = 0; //점수의 최대값을 저장해줄 배열입니다.
		for(int i = N-1; i >= 1; i--) {
			maxScore = slime[i] * slime[i-1] + maxScore; //우선 점수를 먼저 누적시켜주고
			//정렬 해놨으므로 (가장 큰 슬라임 * 그 다음으로 큰 슬라임)점수 + 여태까지 쌓인점수 
			slime[i-1] += slime[i]; //현재값에서 이전값을 더해준 것을 이전에 넣어줍니다.
		}
		System.out.println(maxScore);
	}
}