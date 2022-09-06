import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int x;
	static int y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		check(a,b,c,d,e,f);
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
	}

	public static void check(int a, int b,int c, int d, int e, int f) {
		if(a*e-b*d != 0) {
			y = (a*f - c*d) / (a*e-b*d);
		}else {
			y = 0;
		}
		if(a*e-b*d != 0) {
			x = (c*e - b*f) / (a*e-b*d);
		}else {
			x = 0;
		}
	}
}