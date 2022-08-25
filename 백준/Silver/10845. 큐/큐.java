import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static int front = -1, back = -1;
	static int size = 0;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[10001];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String behavior = st.nextToken();
			switch(behavior) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				push(num, i);
				break;
			case "pop":
				pop(i);
				break;
			case "size":
				size(i);
				break;
			case "empty":
				empty(i);
				break;
			case "front":
				front(i);
				break;
			case "back":
				back(i);
				break;
			}
		}
		System.out.println(sb);
	}
	static void push(int num, int i) {
		arr[++back] = num;
		size++;
	}
	
	static void pop(int i) { 
		if(size==0) {
			sb.append(-1);
			enter(i);
		}else {
			int pnum = arr[++front];
			arr[front] = 0;
			sb.append(pnum);
			enter(i);
			size--;
		}
	}
	
	static void size(int i) {
		sb.append(size);
		enter(i);
	}
	
	static void empty(int i) {
		if(size==0) {
			sb.append(1);
			enter(i);
		}else {
			sb.append(0);
			enter(i);
		}
	}
	
	static void front(int i) {
		if(size==0) {
			sb.append(-1);
			enter(i);
		}else {
			sb.append(arr[++front]);
			--front;
			enter(i);
		}
	}
	static void back(int i) {
		if(size==0) {
			sb.append(-1);
			enter(i);
		}else {
			sb.append(arr[back]);
			enter(i);
		}
	}
	static void enter(int i) {
		if(i!=N-1)
			sb.append("\n");
	}
}