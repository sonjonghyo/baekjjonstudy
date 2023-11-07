import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int X;
		int num;
		public Node(int X, int num) {
			this.X = X;
			this.num = num;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//부품의 개수. N번째는 완제품의 번호.(노드)
		int N = Integer.parseInt(br.readLine());
		//부품관의 관계(간선)
		int M = Integer.parseInt(br.readLine());
		int indegreeX[] = new int[N+1];
		int indegreeY[] = new int[N+1];
		//결과를 저장해줄 result배열입니다.
		int result[] = new int[N+1];
		//연결된 간선들 저장.		
		List<Node>[] li = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			li[i] = new ArrayList<>();
		}
		//간선의 수 만큼 for문을 돌려줍니다.
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			//부품의 번호.
			int X = Integer.parseInt(st.nextToken());
			//중간 부품 혹은 기본 푸품.
			int Y = Integer.parseInt(st.nextToken());
			//필요한 개수
			int K = Integer.parseInt(st.nextToken());
			//연결된 부품 List에 추가.
			li[X].add(new Node(Y,K));
			//만드는 부품과 만들어야할 부품 하나씩 올리기.
			indegreeX[X]++;
			indegreeY[Y]++;
		}
		Queue<Node> q = new LinkedList<>();
		//완성부터 시작하기위해 N을 넣어주고 1개만드니까 1 추가.
		q.add(new Node(N, 1));
		//마지막은 1개 들어가니까 1 저장.
		result[N] = 1;
		while(!q.isEmpty()) {
			Node n = q.poll();
			//반복문을 돌리는데? 해당 번호가 가지고있는 크기만큼 for문을 돌려주기.
			//예로 7번을 만드는데 4번 5번 6번이 필요하다면 size는 3이므로 3번 돌아감.
			for(int i = 0; i < li[n.X].size(); i++) {
				//현재 List의 번호에서 필요한 부품 꺼내오기.
				Node o = li[n.X].get(i);
				//다음 필요한 부품의 개수는 현재 부품의 개수 * 현재 부품을 만드는데 필요한 다음 부품의 개수.
				result[o.X] += result[n.X] * o.num;
				//다음 필요한 부품을 가지고 만들어야할 부품이 만들어졌으니 1개 빼주자.
				indegreeY[o.X]--;
				//만약 다음 필요한 부품이 더이상 만들 것이 없다면?
				if(indegreeY[o.X] == 0) {
					//큐에 담아서 이제 그 부품을 만들기 위해 필요한 부품 찾기.
					q.add(new Node(o.X, result[o.num]));
				}
			}
		}
		for(int i = 1; i < N; i++) {
			//즉 중간부품이었던 애들은 전부 제외.
			//완제품은 안봐도 되니 N-1까지만 for문.
			if(li[i].size() != 0) 
				continue;
			sb.append(i).append(" ").append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
}