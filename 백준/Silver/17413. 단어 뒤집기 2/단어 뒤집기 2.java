import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine(); //뒤집을 문자열 입력.
		boolean tag = false;
		Stack<Character> s = new Stack<>(); //스택에 쌓아서 하기위해 스택 s선언.
		for(int i = 0; i<S.length(); i++) { //내가 받은 문자열의 길이만큼 for문을 사용함.
			if (S.charAt(i) =='<') { //만약 문자 <를 만났다면
				while(!(s.isEmpty())) { //기존의 스택에 무언가가 채워져있었다면 전부 비워내기 위해 while문을 사용하였다.
					System.out.print(s.pop()); //바로 거꾸로 출력 되게 만들어 주었다.
				}
				System.out.print("<");
				tag= true;
			}else if(S.charAt(i)=='>') {
				System.out.print(">");; //while문이 >를 만나면 끝나므로 >를 아래에서 추가시켜주고.
				s.clear(); //스택내부도 다시 사용할수 있으므로 내부를 전부 비워준다.
				tag = false;
			} else if(tag) {
				System.out.print(S.charAt(i));
			} else if(S.charAt(i)==' ' | i==S.length()-1) { //만약 띄어쓰기를 만나거나 문자열의 마지막에 도달했을시에는
				if(i==S.length()-1) { //만약 문자열의 마지막에 도달했을때에는 마지막 문자추가는 마지막 else문에 있으므로 아직 추가하지 못했으므로
					s.add(S.charAt(i)); //마지막 문자를 추가해준다.
				}
				while(!(s.isEmpty())) { //스택내부가 전부 비워질때까지
					System.out.print(s.pop()); //바로 거꾸로 출력되게 만들어줌.
				}
				if(i != S.length()-1) { //문자열의 끝이아닌 띄어쓰기를 만났을때만 띄어쓰기를 추가해주기 위해 사용하였다.
					System.out.print(" ");  //띄어쓰기 사용함.
				}
			}else {
				s.add(S.charAt(i)); //아무것도 아닐시에는 그냥 문자열을 스택에 저장해준다.
			}
		}
	}
}