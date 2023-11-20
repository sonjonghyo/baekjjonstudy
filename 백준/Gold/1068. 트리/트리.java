import java.util.*;
import java.io.*;

public class Main {
	static int answer = 0;
	static int delete;
	static List<Integer> li[];
	static boolean flag[];
	static List<Integer> nli[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		flag = new boolean[N];
		int start = 0;
		li = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			li[i] = new ArrayList<>();
		}
		nli = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			nli[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a == -1) {
				start = i;
				continue;
			}
			li[a].add(i);
		}
		//삭제할 노드.
		delete = Integer.parseInt(br.readLine());
		//전부 돌면서 탐색.
		List<Integer> road = new ArrayList<>();
		if(delete != start) {
			road.add(start);
			dfs(road);
			for(int i = 0; i  < N; i++) {
				if(nli[i].size() == 0 && !flag[i])
					answer++;
			}
			System.out.println(answer);
		}else {
			System.out.println(0);
		}
	}
	private static void dfs(List<Integer> road) {
		if(road.isEmpty()) {
			return;
		}
		int idx = road.get(0);
		List<Integer> list = new ArrayList<>();
		list.addAll(road);
		list.remove(0);
		//자식이 있으면?
		if(li[idx].size() != 0) {
			for(int child : li[idx]) {
				//삭제되는 노드라면 flag를 true로 변경시켜주기.
				if(child == delete) {
					flag[child] = true;
				}
				//또는 내 부모가 true라면? 밑에도 볼 필요없으니까 true로 바꿔주기.
				if(flag[idx] == true) {
					flag[child] = true;
				}
				list.add(child);
				if(child != delete && flag[idx] == false) {
					nli[idx].add(child);
				}
			}
		}
		dfs(list);
	}
}