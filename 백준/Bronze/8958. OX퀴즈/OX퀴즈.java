import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트케이스 횟수 입력.
		for(int tc = 1; tc<=T; tc++) {
			String s = br.readLine(); //OX를 입력받음.
			int len = s.length(); //입력받은 OX의 개수를 len에 저장함.
			int cnt = 0; //O가 연속으로 몇번나왔는지 세어주는 변수.
			char ox[] = new char[len]; //OX 하나씩 입력받기 위해 사용. char형 배열 사용
			int sum = 0; //cnt누적합.
			for(int i = 0; i<len; i++) {
				ox[i] = s.charAt(i); //OX의 길이만큼 for문을돌려 ox에 넣어준다.
			}
			for(int i = 0; i<len; i++) {
				if(ox[i]=='O') { //O를 만났다면.
					cnt++; //cnt를 하나씩 추가시킨다.
				}else { //X를 만났다면
					cnt = 0; //cnt를 초기화시켜 0으로 만들어준다.
				}
				sum += cnt;
			}
			System.out.println(sum);
		}
	}
}
