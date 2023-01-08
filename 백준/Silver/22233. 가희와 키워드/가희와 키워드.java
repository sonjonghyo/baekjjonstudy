import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> memo = new HashMap<String, Integer>();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //메모장에 써진 키워드
		int M = Integer.parseInt(st.nextToken()); //가희가 쓴 글과 관련된 키워드.
		for(int i = 1; i <= N; i++) {
			String keyword = br.readLine();
			memo.put(keyword, i);
		}
		for(int i = 0; i < M; i++) {
			String keword = br.readLine();
			String key[] = keword.split(","); //키워드를 콤마를 기준으로 나눠줍니다.
			for(int j = 0; j < key.length; j++) {
				if(memo.containsKey(key[j])) { //해당 키를 가지고있는지 확인.
					//가지고있다면?
					memo.remove(key[j]); //해당 키 삭제.
				}
			}
			sb.append(memo.size()); //j에 대한 for문이 끝나면
			//현재의 Map의 크기가 메모장에 남아있는 키워드의 개수.
			if(i != M-1) //마지막이 아니라면
				sb.append("\n"); //개행문자를 추가시켜줍니다.
		}
		System.out.println(sb);
	}
}