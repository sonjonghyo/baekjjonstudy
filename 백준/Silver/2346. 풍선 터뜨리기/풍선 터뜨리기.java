import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static class blo {
		int idx, num;
		
		public blo(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque<blo> dq = new ArrayDeque<>(); //데큐 생성
		st = new StringTokenizer(br.readLine()); 
		for(int i = 1; i<=N; i++) { //풍선은 1번부터있으므로 1부터 저장.
			dq.add(new blo(i, Integer.parseInt(st.nextToken()))); //값 저장.
		}
		
		while(dq.size() > 1) {
			blo cur = dq.poll();
			sb.append(cur.idx).append(" ");
			int move = cur.num; //이동해야할 거리.
			if(move < 0) { //만약 이동해야할 거리가 0보다 작다면.
				while(move++ != 0) { //0이 될때까지 움직여 준다.
					dq.addFirst(dq.pollLast()); //맨 뒤에거를 빼서 맨 앞에 넣어주는 식.
				}
			}else {
				move--; //poll했을때 자동으로 오른쪽 한칸 이동하므로 +일때는 한칸 덜 이동시킴.
				while(move-- != 0) {  //0이 될때까지 이동시켜준다.
					dq.addLast(dq.pollFirst()); //맨 앞에거를 빼서 맨뒤에 넣어주는 식.
				}
			}
		}
		System.out.println(sb.append(dq.poll().idx));
	}
}