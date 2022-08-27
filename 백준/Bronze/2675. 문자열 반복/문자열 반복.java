import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) { //테스트 케이스만큼 반복.
			st = new StringTokenizer(br.readLine()); //반복횟수와 반복할 문자열 입력.
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			String result = ""; //빈 문자열 result를 만들어줌.
			for(int i = 0; i<S.length(); i++) { //처음엔 문자열의 길이만큼 for문을 해주고
				for(int j  = 0; j<R; j++) { //그다음엔 반복횟수 만큼 해주어서
					result += S.charAt(i);	//charAt(i)를 이용해 i번째에 있는 문자열을 R번반복해서 붙여준다.
				}
			}
			sb.append(result); //sb에 추가해준다.
			if(tc!=T)
				sb.append("\n"); //마지막이 아닐시에는 개행문자 추가.
		}
		System.out.println(sb);
	}
}