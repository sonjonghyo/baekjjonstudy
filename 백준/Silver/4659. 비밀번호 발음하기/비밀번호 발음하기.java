import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String end = "end"; //end를 미리 저장해줍니다.
		while(true) {
			String pw = br.readLine(); //pw를 입력합니다.
			if(pw.equals(end)) { //만약 입력이 end라면
				break; //while문을 끝내줍니다.
			}
			int collection = 0; //이 비밀번호 모음의 개수
			int mcnt = 0; //연속되는 모음이 몇개인지 계산해줄 mcnt.
			int jcnt = 0; //연속되는 자음이 몇개인지 계산해줄 jcnt.
			char m = ' '; //이전의 글자가 무엇인지 확인.
			boolean check = true;
			for(int i = 0; i < pw.length(); i++) { //있는지 계산.
				//먼저 같은글자가 연속적으로 왔는지 확인.
				if(m != 'e') { //e가 아니고?
					if(m != 'o') { //o도 아니라면?
						if(m == pw.charAt(i)) { //이 경우는 안돼.
							check = false; //발음 불가
							break;
						}
					}
				}
				if(pw.charAt(i) == 'a' || pw.charAt(i) == 'e' || pw.charAt(i) == 'i' || pw.charAt(i) == 'o' || pw.charAt(i) == 'u') { //만약 모음이라면?
					collection++; //모음의 개수 추가.
					mcnt++; //연속되는 모음수 1개 추가.
					jcnt = 0; //연속되는 자음은 없어지므로 0으로 초기화시켜줍니다.
					m = pw.charAt(i); //현재 문자 저장.
				}else { //자음이 온 경우에는. 
					mcnt = 0; //연속된 모음은 사라지므로 0으로 초기화
					jcnt++; //연속된 자음수계산위해 jcnt 추가
					m = pw.charAt(i);
				}
				//for문 마지막에 연속된 것 3번씩 왔는지 확인
				if(mcnt == 3 || jcnt == 3) { //둘중 하나라도 3이되었다면?
					check = false; //발음불가.
					break; 
				}
			}
			if(check && collection > 0) { //발음이 가능한지 확인
				sb.append('<').append(pw).append('>').append(" is acceptable.");
				sb.append("\n");
			}else {
				sb.append('<').append(pw).append('>').append(" is not acceptable.");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}