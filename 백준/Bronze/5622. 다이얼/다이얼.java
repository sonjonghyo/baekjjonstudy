import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		dial(S);
		System.out.println(sb);
	}
	static void dial(String S) {
		char num[] = new char[S.length()];
		int time = 0; //총 걸리는 시간.
		for(int i =0; i<S.length(); i++) {
			num[i] = S.charAt(i);
			switch(num[i]) { //각 알파벳마다 걸리는 시간을 case문에 넣어 더해줌.
			case 'A' : case 'B' : case 'C' :
				time += 3;
				break;
			case 'D' : case 'E' : case 'F' :
				time += 4;
				break;
			case 'G' : case 'H' : case 'I' :
				time += 5;
				break;
			case 'J' : case 'K' : case 'L' :
				time += 6;
				break;
			case 'M' : case 'N' : case 'O' :
				time += 7;
				break;
			case 'P' : case 'Q' : case 'R' : case 'S' :
				time += 8;
				break;
			case 'T' : case 'U' : case 'V' :
				time += 9;
				break;
			case 'W' : case 'X' : case 'Y' : case 'Z' :
				time += 10;
				break;
			}
		}
		sb.append(time);
	}
}