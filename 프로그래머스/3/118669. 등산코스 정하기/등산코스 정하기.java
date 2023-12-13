import java.util.*;

class Solution {
    static class Node {
		int num;
		int w;
		public Node(int num, int w) {
			this.num = num;
			this.w = w;
		}
	}
	static List<List<Node>> list;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        list = new ArrayList<>();
		//리스트 배열 추가.
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		//다잌스트라를 위해 list에 path를 넣어주자.
		//시작지점과 끝지점은 양방향이 될수 없다.(나가고 들어가기만 해야함.)
		for(int path[] : paths) {
			//출발점
			int s = path[0];
			//도착점
			int e = path[1];
			//가중치
			int w = path[2];
			//출발지가 시작점이거나 도착지가 봉우리라면?
			if(start(s, gates) || end(e, summits)) {
				//출발지에서 추가 시켜주기.
				list.get(s).add(new Node(e,w));
			//반대로 출발지가 끝지점이거나 도착지가 시작점이라면?
			}else if(start(e, gates) || end(s, summits)) {
				list.get(e).add(new Node(s,w));
			//위와 둘다 되지않는다면 둘다 쉼터이니 두개 추가.
			}else {
				list.get(s).add(new Node(e,w));
				list.get(e).add(new Node(s,w));
			}
		}
		//다익스트라 알고리즘 사용.
		return djk(n, gates, summits);
    }
   private static int[] djk(int N, int[] gates, int[] summits) {
		Queue<Node> q = new LinkedList<>();
		int arr[] = new int[N+1];
		//가장 큰 값으로 채워놓고 최솟값으로 계속 갱신하기.
		Arrays.fill(arr, Integer.MAX_VALUE);
		for(int gate : gates) {
			//게이트의 처음 시작지점은 가중치가 0이니 0으로 저장해 놓기.
			q.add(new Node(gate, 0));
			arr[gate] = 0;
		}
		//게이트에서 출발해서 끝지점까지 가자.
		while(!q.isEmpty()) {
			Node n = q.poll();
			//만약 현재의 가중치가 저장된 가중치 보다 크다면? => 최소 갱신 못하니 다음으로 패스.
			if(n.w > arr[n.num]) continue;
			
			//해당 위치에서 갈수 있는 부분 전부 for문으로 탐색하자.
			for(int i = 0; i < list.get(n.num).size(); i++) {
				Node nn = list.get(n.num).get(i);
				
				//dis는 가중치가 더 큰걸로 계산해야함.
				int dis = Math.max(arr[n.num], nn.w);
				//만약 이동하는 구간이 더 크다면?(갱신)
				if(arr[nn.num] > dis) {
					arr[nn.num] = dis;
					q.add(new Node(nn.num, dis));
				}
			}
		}
		int num = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		
		Arrays.sort(summits);
		for(int summit : summits) {
			if(arr[summit] < min) {
				min = arr[summit];
				num = summit;
			}
		}
		
		return new int[] {num,min};
	}
    
	private static boolean start(int s, int gates[]) {
		//만약 출발 게이트에 포함 된다면?
		for(int gate : gates) {
			if(gate == s) {
				//true를 반환해주기.
				return true;
			}
		}
		//출발지가 아니니 false 반환.
		return false;
	}
	
	private static boolean end(int e, int summits[]) {
		//만약 도착 게이트에 포함된다면?
		for(int summit : summits) {
			if(summit == e) {
				//true를 반환해주기.
				return true;
			}
		}
		//도착지가 아니니 false반환.
		return false;
	}
}