import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = ""; //입력한 변수를 문자열로 받아오기 위한 변수 선언.
		for(int i = Integer.parseInt(br.readLine()); ;i++) {
			s = String.valueOf(i); //Integer형 i를 String형으로 바꿔주었다.
			if(sosu(s) && palin(s)) { //둘다 참일시에만 소수와 팰린드롬수를 만족해주므로 이때
				System.out.println(i); //i를 출력해주고
				break; //for문을 끝내줍니다.
			}
		}
	}
	public static boolean sosu(String s) { //소수인지 확인해 주는 함수.
		int n = Integer.valueOf(s); //String형으로 받아온 입력한 수를 Integer 형으로 바꿔준다.
		if(n==1) //1은 소수가 아니므로 바로 false를 반환해준다.
			return false; 
		for(int i = 2; i<=Math.sqrt(n); i++) { //2보다 크다면 n의 제곱근까지만 범위를 설정해 나누어주면됩니다.
			//제곱근까지 하는 이유는 제곱근을 넘어가는 수는 우리가 약수를 구할때 보았듯 이미 앞의 수에서 전부 없애준 수입니다.
			if(n%i==0) //만약 나누어떨어진다면
				return false; //false로 return해주며
		}
		return true; //for문을 다돌았는데도 안에 if문이 동작을 안했다면 true를 반환해줍니다.
	}
	public static boolean palin(String s) { //팰린드롬수인지 확인해줌.
		String revs = ""; //거꾸로 받을 문자열 빈문자열로 입력.
		for(int i = s.length() - 1; i>=0; i--) { //문자열의 마지막부터 0 순으로 내림차순으로 입력받아옴.
			revs += s.charAt(i); //revs에 charAt으로 하나씩 넣어주기.
		}
		if(s.equals(revs)) { //만약 둘이 비교했을때 같다면
			return true;	//true를 반환해주며
		}else {
			return false; //다르다면 false를 반환해줌.
		}
	}
}