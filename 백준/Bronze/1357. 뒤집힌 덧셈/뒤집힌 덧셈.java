import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		String revA = ""; //거꾸로 담아줄 변수
		String revB = ""; 
		for(int i = A.length()-1; i>=0; i--) {
			revA += A.charAt(i);
		}
		for(int i = B.length()-1; i>=0; i--) {
			revB += B.charAt(i);
		}
		int a = Integer.parseInt(revA);
		int b = Integer.parseInt(revB);
		int revresult = a+b;
		String revr = String.valueOf(revresult);
		String rr = "";
		for(int i = revr.length()-1; i>=0; i--) {
			rr += revr.charAt(i);
		}
		int result = Integer.parseInt(rr);
		System.out.println(result);
		
	}
}