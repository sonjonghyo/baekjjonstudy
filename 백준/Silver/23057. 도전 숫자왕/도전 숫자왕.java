import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int card[] = new int[21];
	static Set<Integer> set = new HashSet<>();
	static int N, M;
	static int notmake;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //카드의 개수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			M += card[i]; //모든 카드에 적힌 수의 합.
		}
		
		check(0, 0);
		notmake = M - set.size() + 1; //처음에 0이 들어가서 +1을 해줍니다.
		System.out.println(notmake); //못만든거 계산.
	}
	private static void check(int depth, int sum) {
		set.add(sum);
		
		if(depth == N)
			return;
		
		check(depth + 1, sum);
		check(depth + 1, sum + card[depth]);
		
	}
}