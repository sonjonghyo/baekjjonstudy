import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> list = new ArrayList<>();
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
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
		int answer[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			//수를 넣어주고.
			int num = Integer.parseInt(st.nextToken());
			//이분탐색 시작.
			System.out.print(binarySearch(num) + " ");
		}
	}
	private static int binarySearch(int num) {
		//초기에 왼쪽은 0 오른쪽은 list의 사이즈 - 1만큼.
		int left = 0;
		int right = list.size() - 1;
		while(left <= right) {
			//중간값 설정.
			int mid = (left + right) / 2;
			//list의 mid에 위치한 값이 num보다 크다면?
			if(list.get(mid) > num) {
				//num이 더 작으니 오른쪽 값을 내리기.
				right = mid -1;
			//num보다 작다면?
			}else if(list.get(mid) < num) {
				//num이 더 크니 왼쪽값을 올리기.
				left = mid + 1;
			//같다면?
			}else {
				//해당 위치에 있는 수 key값으로 설정해 map에서 개수 뽑아내기.
				return map.get(list.get(mid));
			}
		}
		return 0;
	}
}