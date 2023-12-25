import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			HashMap<Integer,Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());;
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			int M = Integer.parseInt(br.readLine());
			int note[] = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				note[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < M; i++) {
				if(map.containsKey(note[i])) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}