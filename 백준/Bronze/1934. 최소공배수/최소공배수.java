import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			maximum(A,B); //최소 공배수를 구하는 함수.
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);	
	}
	
	static void maximum(int A, int B) {
		int acnt = 2;
		int bcnt = 2;
		int comA = A;
		int comB = B;
		while(true) {
			if(comA==comB) { //두개의 수가 같을시에 최소공배수가 되므로
				sb.append(comA); //둘중 아무수나 추가를 해주고
				return; //함수를 끝내준다.
			}
			if(comA>comB) { //만약 comA가 comB보다 크다면
				comB = B*bcnt; //더 작은수를 먼저 수를 하나씩 늘려가며 곱해주어야하므로 처음에 2부터 곱해준다.
				bcnt++; //그러고 bcnt를 1늘려주어 다음에 더 작을시에는 원래수에서 3을 곱하게 해준다.
			}else {
				comA = A*acnt; //위와 반대이다.
				acnt++;
			}
		}
	}
}