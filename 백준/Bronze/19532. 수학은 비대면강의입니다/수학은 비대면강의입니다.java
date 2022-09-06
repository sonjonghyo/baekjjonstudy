import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		check(a,b,c,d,e,f);
		System.out.println(sb);
	}
	public static void check(int a, int b, int c, int d, int e, int f) {  //해를 구해주는 메소드.
		for(int x = -999; x<=999 ; x++) { //x와 y의 범위만큼 for문을 돌려 전부 대입해서 해를 찾게한다.
			for(int y = -999; y<=999; y++) { //
				if((a*x + b*y == c) && (d*x + e*y == f)) { //만약 두개의 값이 같다면 해를 찾은것이므로
					sb.append(x).append(" ").append(y); //sb에 추가해주고
					return; //이 메소드를 끝내준다.
				}
			}
		}
	}
}