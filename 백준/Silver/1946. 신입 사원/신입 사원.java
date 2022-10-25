import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); //출력을 담아줄 stringbuiler
		int T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수.
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); //지원자의 숫자.
			//지원자의 서류심사 성적, 면접 성적 순위.
			int grade[] = new int[N+1];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); //서류 성적 순위
				int b = Integer.parseInt(st.nextToken()); //면접 성적 순위
				grade[a] = b; //배열의 idx가 서류 성적 순위, 그 값이 면접 성적 순위
			}
			int min = grade[1]; //grade[1]의 값이 첫번째 서류 성적 순위에 대한 면접 성적 순위의 값을 최소값으로 지정.
			int result = N; //일단 신입사원의 수를 결과값으로 지정.
			for(int i = 2; i<=N; i++) { //1등은 볼필요가 없으므로 2등부터 본다.
				if(grade[i] > min) //만약 min보다 grade[i]의 값이 더 크다면? (어짜피 서류순위는 idx순이므로 비교할 필요가없음.)
					result--; //결과값을 감소시켜주고 min은 그대로.
				if(grade[i] < min) //grade[i]보다 min이 더크다면 다음 면접 성적 순위를 최소값으로 교체해준다.
					min = grade[i];
			}
			sb.append(result); //결과값 저장.
			
			if(tc!=T)
				sb.append("\n");		
		}
		System.out.println(sb);
	}
}