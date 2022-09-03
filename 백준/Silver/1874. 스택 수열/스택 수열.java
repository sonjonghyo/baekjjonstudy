import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int arr[];
	static int N;
	static Stack<Integer> s = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		//먼저 N개의 수를 순서대로 arr배열에 넣어주고
		//스택에 수를 차례대로 쌓으면서 arr배열 0번째부터 비교해주며 같을시 계속 top부분을 peek를 사용해 비교해서 빼준다.
		//만약 for문이 N번 다 돌았으면 size가 0이면 다 빠진것이므로 +,-있는것을 출력해주고 아니면 sb를 전부비우고 NO를 추가해 NO를 출력해줌.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N]; //N개의 수만큼 배열생성.
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		stack();
		System.out.println(sb); //sb를 출력해 확인해준다.
	}
	public static void stack() {
		int idx = 1; //1부터 쌓기위해 idx를 1로 만들어주었다.
		int cnt = 0; //비교할 arr배열의 순서. 비교했을때 top과 같으면 +1이 된다.
		for(int i = 0; i<N ; i++) {
			s.add(idx); //먼저 1부터 순서대로 추가해준다.
			sb.append("+").append("\n"); //추가했으니 sb에 +를 넣어주고
			while(cnt < N && s.size()!=0 && arr[cnt]==s.peek()) { //cnt가 N보다 작아야하며 스택의 사이즈가 0이라는것은 뺄것이 없는것이므로 빼주고
				//현재 배열의 cnt의 위치가 스택의 top부분과 같다면 while문이 실행이된다.
				//while로 해준이유는 처음에 스택의 탑이 빠지고 그다음의 스택의 탑과 배열의 수가 같을때를 방지함.
				s.pop(); //같다면 스택의 맨 위를 지워주고
				sb.append("-"); //-를 추가해준다
				if(cnt!=N-1) //만약 cnt가 N-1과 같지않을시에는 개행문자를 추가.(cnt가 N-1까지 갔다는 것은 마지막순서라는 것.)
					sb.append("\n");
				cnt++; //arr의 다음위치를 보기위해 cnt를 추가해준다.
			}
			idx++; //for문이 돌때마다 수를 하나 큰것을 넣어주어야하므로 idx를 추가시켜준다.
		}
		if(s.size()!=0) { //만약 사이즈가 0이 아니라는것은 다 빠지지 않은것이므로 NO를 추가시켜주어야한다.
			sb.delete(0, sb.length()); //sb안에있는것을 전부 비워내 주고
			sb.append("NO"); //NO를 추가해준다.
		}else {
			return; //아닐시엔 그냥 끝내준다.
		}
	}
}