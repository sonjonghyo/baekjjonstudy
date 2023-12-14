import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			//등록되지 않은 수라면?
			if(!map.containsKey(num)) {
				//map에 해당 수 추가
				map.put(num, map.getOrDefault(num, 0) + 1);
			//이미 등록된 수라면?
			}else {
				//이미 등록되었으면 map에 개수만 추가.
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			//수를 넣어주고.
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				sb.append(1).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}
}