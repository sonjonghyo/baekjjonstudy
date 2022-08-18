import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		Queue<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		int a = 0;
		for(int i = 1; i<=N; i++) {
			q.add(i);
		}
		if(N==1) {
			System.out.println(1);
		}else {
		for(; 1!=q.size();) {
			q.remove();
			a = q.poll();
			q.add(a);
		}
		System.out.println(a);
		}
	}
}