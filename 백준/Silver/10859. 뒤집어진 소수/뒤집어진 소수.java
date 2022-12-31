import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine(); //소수인지 먼저 확인.
		checktfs(N); //3,4,7이 있는지 확인해주는 함수.
		checksosu(N); //소수인지 확인해주는 함수.
		boolean check = false;
		if(checktfs(N) && checksosu(N)) { //3,4,7이없고 소수라면?
			String revN = "";
			revN = reversenum(N); //수를 180도 뒤집어 주는 함수.
			if(checksosu(revN)) { //거꾸로 뒤집은 수도 소수인지 확인.
				check = true; //check를 true로 만들어줍니다.
			}
		}
		if(check) { //다 통과했다면?
			System.out.println("yes"); //yes로 출력해줍니다.
		}else { //아닐시엔
			System.out.println("no"); //no를 출력해줍니다.
		}
	}
	private static String reversenum(String N) {
		String rev = ""; //바뀔 수를 담아줄 rev
		for(int i = N.length()-1; i >= 0 ; i--) {
			char num = N.charAt(i); //거꾸로 담기
			if(num == '9') { //만약 현재의 수가 9라면?
				num = '6'; //9를 180도 뒤집을시 6이므로 6으로 저장해줍니다. 
			}else if(num == '6') { //6인 경우는
				num = '9'; //9로 바꾸어줍니다.
			}
			rev += num; //그러고나서 rev변수에 추가시켜줍니다.
		}
		return rev; //마지막으로 for문이 끝날시 rev를 반환해줍니다.
	}
	private static boolean checktfs(String N) { //3,4,7가 들어있는지 확인.
		for(int i = 0; i < N.length(); i++) { 
		//3,4,7이 들어가면 뒤집을시 수가 안되므로 바로 끝내줍니다.
			if(N.charAt(i) == '3' || N.charAt(i) == '4' || N.charAt(i) == '7') {
				return false; //3,4,7중 하나가 포함되어있으면 false를 반환해줍니다.
			}
		}
		return true; //없을경우 true를 반환해줍니다.
	}
	private static boolean checksosu(String N) {
		long num = Long.parseLong(N); //먼저 범위가 최대 10의 16승까지이므로 long으로 선언해줍니다.
		if(num == 1) return false; //1인경우는 소수가 아니므로 true반환
		for(long i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false; //나누어 떨어지면 넌 소수가아니야
		}
		return true; //안나누어 떨어질시 소수
	}
}