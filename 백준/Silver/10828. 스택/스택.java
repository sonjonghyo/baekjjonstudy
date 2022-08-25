import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int top = -1;
	static int arr[];
	static int size = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[10000];
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String behavior = st.nextToken();
			switch(behavior) {
			case "push" :
				int num = Integer.parseInt(st.nextToken());
				push(num);
				break;
			case "pop" :
				pop();
				if(i!=N-1)
					enter();
				break;
			case "empty" :
				empty();
				if(i!=N-1)
					enter();
				break;
			case "size" :
				size();
				if(i!=N-1)
					enter();
				break;
			case "top" :
				top();
				if(i!=N-1)
					enter();
				break;
			}
		}
		System.out.println(sb);
	}
	
	static void push(int num) {
		arr[++top] = num;
		size++;
	}
	
	static void pop() {
		if(size==0) {
			sb.append(-1);
		}else {
			int pnum = arr[top--];
			sb.append(pnum);
			size--;
		}
	}
	
	static void empty() {
		if(size==0) {
			sb.append(1);
		}else {
			sb.append(0);
		}
	}
	
	static void size() {
		sb.append(size);
	}
	
	static void top() {
		if(size==0) {
			sb.append(-1);
		}else {
			sb.append(arr[top]);			
		}
	}
	static void enter() {
		sb.append("\n");
	}
}