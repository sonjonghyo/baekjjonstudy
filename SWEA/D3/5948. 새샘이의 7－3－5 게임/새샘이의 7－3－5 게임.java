import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static List<Integer> li;
	static Set<Integer> s;
	static int arr[];
	static int rsum[];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			s = new HashSet<>();
			arr = new int[7];
			rsum = new int[3];
			visited = new boolean[7];
			for(int i = 0; i<7; i++) {
				arr[i] = sc.nextInt();
			}		
			dfs(0,0);
			li = new ArrayList<>(s);
			Collections.sort(li, Collections.reverseOrder());
			sb.append(li.get(4));
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	private static void dfs(int idx, int cnt) {
		if(cnt==3) {
			int sum = 0;
			for(int i = 0; i<3; i++) {
				sum += rsum[i];
			}
			s.add(sum);
			return;
		}
		
		for(int i = idx; i<7; i++) {
			if(!visited[i]) {			
				visited[i] = true;
				rsum[cnt] = arr[i];
				dfs(i+1, cnt+1);
				visited[i] = false;
			}
		}
		
		
	}
}