import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //저장된 사이트의 주소 개수
		int M = Integer.parseInt(st.nextToken()); //비밀번호 찾으려는 사이트의 개수
		HashMap<String, String> password = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pass = st.nextToken();
			password.put(site, pass);
		}
		for(int i = 0; i < M; i++) {
			String site = br.readLine();
			sb.append(password.get(site));
			if(i != M-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}