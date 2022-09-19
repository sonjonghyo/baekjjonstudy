import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int A;
	static int B;
	static int m;
	static int arr[];
	static int ten; //십진수를 저장해줄 변수
	static int result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); //미래세계에서 사용하는 진법A
		B = Integer.parseInt(st.nextToken()); //정이가 사용하는 진법 B
		m = Integer.parseInt(br.readLine()); //A진법으로 나타낸 숫자의 자리수의 개수
		st = new StringTokenizer(br.readLine());
		arr = new int[m];
		for(int i = 0; i<m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		atot();
		ttob();
		System.out.println(sb);
	}
	
	public static void atot() { //A진법 변수를 10진수로 바꾸기
		for(int i = 0; i<m; i++) {
			ten += (Math.pow(A, m-1-i) * arr[i]);			
		}
	}
	
	public static void ttob() { //10진수의 변수를 B진수로 바꾸기.
		int cnt= 1;
		while(cnt < ten) {
			cnt *= B;
		}
		if(cnt!=1)
		cnt /= B;
		while(cnt!=0) {
			if(ten - cnt >= 0) {
				sb.append(ten/cnt).append(" ");
				ten = ten - cnt*(ten/cnt);
				cnt/=B;
			}else {
				sb.append(0).append(" ");
				cnt/=B;
			}
			
		}
	}
}