import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String result = ""; //바뀐 암호화된 결과를 저장해줄 result변수.
		for(int i = 0; i<s.length(); i++) { //암호화해줄 문자의 길이만큼 for문해줌,
			if((int)s.charAt(i)>=65 && (int)s.charAt(i)<91) { //아스키코드에서 A~Z까지 범위
				int a = s.charAt(i)+13; //암호화 하기위해 13을 더해주고
				if(a>90) { //만약 a가 90보다 크다면 대문자 범위 내에서 벗어난 것이므로 
					a=a-91+65; //91번째부터 대문자가 아니므로 91을 빼주고 시작지점인 A의 아스키코드인 65를 더해준다.
				}
				result += (char)a; //바뀐 암호를 result에 추가해준다.
			}else if((int)s.charAt(i)>=97 && (int)s.charAt(i)<123) { //아래는 대문자가아닌 소문자이다.
				int b = s.charAt(i)+13;
				if(b>=123) {
					b=b-123+97;
				}
				result += (char)b;
			}else { //만약 대문자, 소문자 둘다 아니라면 바로 추가해준다.
				result += s.charAt(i); 
			}
		}
		System.out.println(result);
	}
}