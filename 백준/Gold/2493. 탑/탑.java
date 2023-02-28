import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int num;
		int height;
		public Node(int num, int height) {
			this.num = num;
			this.height = height;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Node> top = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int height = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			height = Integer.parseInt(st.nextToken());
			
			if(top.isEmpty()) { //비어있으면 추가.
				sb.append(0).append(" ");
				top.add(new Node(i, height));
			} else {
				while(true) { //비어있지않으면 빌때까지 돌리기
					if(top.isEmpty()) {
						sb.append(0).append(" ");
						top.add(new Node(i, height));
						break;
					}
					
					Node n = top.peek();
					if(n.height > height) {
						sb.append(n.num).append(" ");
						top.add(new Node(i, height));
						break;
					}else {
						top.pop();
					}	
				}
			}
		}
		System.out.println(sb);
	}
}