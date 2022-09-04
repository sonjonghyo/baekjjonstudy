import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		//덱은 큐의 양쪽에 데이터를 넣고 뺄 수 있는 형태의 자료구조를 말함.
		//하나의 자료구조에 큐와 스택을 합쳐놓은 형태를 말함.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<Integer> de = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int x = 0; //수를 추가해줄때 넣어줄 변수.
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch(s) {
			case "push_front" :
				x = Integer.parseInt(st.nextToken());
				de.addFirst(x);
				break;
			case "push_back" :
				x = Integer.parseInt(st.nextToken());
				de.addLast(x);
				break;
			case "pop_front" :
				if(de.size()==0) { //사이즈가 0이면 덱에 들어있는정수가 없으므로 -1을 넣어준다.
					sb.append(-1);
				}else {
					sb.append(de.pollFirst());
				}
				if(i!=N-1)
					sb.append("\n");
				break;
			case "pop_back" :
				if(de.size()==0) { //사이즈가 0이면 덱에 들어있는정수가 없으므로 -1을 넣어준다.
					sb.append(-1);
				}else {
					sb.append(de.pollLast());
				}
				if(i!=N-1)
					sb.append("\n");
				break;
			case "size" :
				sb.append(de.size());
				if(i!=N-1)
					sb.append("\n");
				break;
			case "empty" :
				if(de.isEmpty()) { //덱이 비어있으면 1을 아니면 0을 추가해준다.
					sb.append(1); 
				}else {
					sb.append(0);
				}
				if(i!=N-1)
					sb.append("\n");
				break;
			case "front" :
				if(de.size()==0) { //사이즈가 0이면 덱에 들어있는정수가 없으므로 -1을 넣어준다.
					sb.append(-1);
				}else {
					sb.append(de.peekFirst());
				}
				if(i!=N-1)
					sb.append("\n");
				break;
			case "back" :
				if(de.size()==0) { //사이즈가 0이면 덱에 들어있는정수가 없으므로 -1을 넣어준다.
					sb.append(-1);
				}else {
					sb.append(de.peekLast());
				}
				if(i!=N-1)
					sb.append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}