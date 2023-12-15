import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> list = new ArrayList<>();
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			//등록되지 않은 수라면?
			if(!map.containsKey(num)) {
				//리스트에 수를 추가시켜주자.
				list.add(num);
				//map에 해당 수 추가
				map.put(num, map.getOrDefault(num, 0) + 1);
			//이미 등록된 수라면?
			}else {
				//이미 등록되었으면 map에 개수만 추가.
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}
		//list에 담긴 수들 정렬해주기.
		Collections.sort(list);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			//수를 넣어주고.
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				sb.append(map.get(num)).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}
}