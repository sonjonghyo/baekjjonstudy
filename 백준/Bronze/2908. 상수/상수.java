import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int achangenum;
	static int bchangenum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		change(A,B);
		if(achangenum > bchangenum) {
			System.out.println(achangenum);
		}else {
			System.out.println(bchangenum);
		}
	}
	static void change(int A, int B) { //수를 바꿔줄 함수.
		achangenum = 0;
		bchangenum = 0;
		
		achangenum += (A/100);
		A -= (A/100)*100;
		achangenum += (A/10)*10;
		achangenum += (A%10)*100;
		
		bchangenum += (B/100);
		B -= (B/100)*100;
		bchangenum += (B/10)*10;
		bchangenum += (B%10)*100;
	}
}
