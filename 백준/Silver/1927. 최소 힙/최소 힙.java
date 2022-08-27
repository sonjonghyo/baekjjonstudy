import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> pq = new PriorityQueue<>(); //우선순위 큐(낮은 숫자가 우선)
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		priorityq(N);
		System.out.println(sb);
	}
	
	public static void priorityq(int N) throws Exception{ //우선순위 큐 함수
		for(int i = 0; i<N; i++) { //N번 for문을 돌리고
			int x = Integer.parseInt(br.readLine()); //입력을받아옴.
			if(x==0) { //만약 0이면 가장 작은 수를 빼주는 것이므로
				if(pq.size()==0) { //만약 사이즈가 0이면 우선순위 큐 안에 저장된것이 없는것이므로
					sb.append(0); //0을 sb에 넣어주고
					if(i!=N-1) //마지막번째가 아니라면
						sb.append("\n"); //개행문자도 추가해줍니다.
				}else {
					sb.append(pq.poll()); //만약 사이즈가 0이 아니라면 안에 저장된 수가 있는것이므로 그 수를 빼서 sb에 넣어준다.
					if(i!=N-1)
						sb.append("\n");
				}
			}else { //0이아닐시에는 수를 추가해주는것이므로 add를 사용해 우선순위 큐에 수를 추가해준다.
				pq.add(x);
			}
		}
	}
}