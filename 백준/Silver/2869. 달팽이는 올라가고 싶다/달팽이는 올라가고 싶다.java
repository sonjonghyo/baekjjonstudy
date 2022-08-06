import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferdreader를 이용하여 Scanner보다 시간단축함.
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); //bufferdreader는 내가 쓴 문자를 String으로 읽어오기 때문에 중간에 공백인 부분이 나오면 문자열을 분리해준다.
		int A = Integer.parseInt(st.nextToken()); //문자열을 읽어서 String을 int형으로 변환해준다.
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int date = 0;
		date = (V-B)/(A-B);
		if(((V-B)%(A-B))!=0) {
			date++;
		}
		System.out.println(date);
	}
}