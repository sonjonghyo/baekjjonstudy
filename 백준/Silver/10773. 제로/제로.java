import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		int sum = 0;
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) {
				s.add(num);
			}else {
				s.pop();
			}
		}
		if(s.size()==0) {
			sb.append(0);
		}else {
			for(int i =0; i<s.size(); i++) {
				sum += s.get(i);
			}
			sb.append(sum);
		}
		System.out.println(sb);
	}
}