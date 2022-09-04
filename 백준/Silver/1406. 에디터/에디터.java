import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Character> list = new LinkedList<>();
	static ListIterator<Character> li = list.listIterator();
	public static void main(String[] args) throws Exception{
		//먼저 생각한거로는 list를 사용하여 단어를 하나씩넣고
		//문자열의 길이를 현재 위치로 잡으며 L,R이 나올때마다 위치 변경
		//시간초과가 뜸. (이유 : add와 remove는 한번에 접근이 불가능하여 시간복잡도가 n이되어서.)
		//질문글을 보니 ListIterator<E>를 사용하면 기존의 연결리스트의 remove와 add처럼 처음부터확인하는것이아닌 iterator의 위치에서 시작함.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String s = br.readLine(); //먼저 문자열을 하나받고.
		for(int i = 0; i<s.length(); i++) {
			li.add(s.charAt(i)); //그 문자열을 한 단어씩 쪼개서 list에 넣어준다. 따라서 list는 char형.
		}
		int M = Integer.parseInt(br.readLine()); //입력할 명령어의 개수
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			char E = st.nextToken().charAt(0);
			switch(E) {
			case 'P':
				Character word = st.nextToken().charAt(0);
				li.add(word); //현재 내 커서의 위치에서 단어를 추가해준다.
				break;
			case 'L': //커서를 왼쪽으로 한칸 이동.
				if(li.hasPrevious()) { //내 앞에 단어가있으면 true를 반환해주고 없으면 false를 반환해줌.
					li.previous(); //앞으로 한칸 이동.
				}
				break;
			case 'D':
				if(li.hasNext()) { //내 뒤에 단어가 있으면 true를 반환해주고 없으면 false를 반환해줌.
					li.next(); //뒤로한칸 이동.
				}
				break;
			case 'B':
				if(li.hasPrevious()) { //만약 커서의 위치가 맨처음이면 뺄것이없으므로 동작하지 않게함.
					li.previous(); //앞으로 한칸 이동하고
					li.remove(); //그 위치의 문자를 제거해준다.
				}
				break;
			}
		}
		for(char r : list) {
			sb.append(r);
		}
		System.out.println(sb);
	}
}