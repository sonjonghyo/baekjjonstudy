import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bin[] = {"000", "001", "010", "011", "100", "101", "110", "111"}; //처음수가 8진수까지 표현되므로 0~7까지만 표현해주면된다.
		StringBuilder tmp = new StringBuilder(); //중간에 8진수를 2진수로 바꾸어주는 거쳐가는 변수
		StringBuilder result = new StringBuilder();
		Boolean check = true; //처음에 0이나올때 0을 없애주기 위한 변수.
		for(int i = 0; i<s.length(); i++) {
			int num = s.charAt(i)-48;
			tmp.append(bin[num]);
		}
		for(int i = 0; i<tmp.length(); i++) {
			if(s.equals("0")) { //0일때 안나오는것을 대비해서 만들어줌
				result.append("0");
				break;
			}
			if(tmp.charAt(i)=='0' && check) { //만약 시작부분이 0이고 check가 true이면 다음i로 넘어간다.
				continue;
			}else { //0이아니고 1이라면
				check = false; //check를 false로 만들어 더이상 위의 부분이 동작하지않게하고
				result.append(tmp.charAt(i));
			}
		}
		System.out.println(result);
	}
}