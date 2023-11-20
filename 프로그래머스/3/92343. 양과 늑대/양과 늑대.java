import java.util.*;

class Solution {
    static List<Integer> li[];
	static int answer = 0;
    public int solution(int[] info, int[][] edges) {
        //먼저 부모가 어떤 자식들을 가지고있는지 저장해줄 List배열을 만들어줍니다.
		li = new ArrayList[info.length+1];
		for(int i = 0; i <= info.length; i++) {
			li[i] = new ArrayList<>();
		}
		//부모에 추가시켜주자.
		for(int i = 0; i < edges.length; i++) {
			li[edges[i][0]].add(edges[i][1]);
		}
		//현재까지 왔던 경로를 저장해줄 List입니다.
		List<Integer> road = new ArrayList<>();
		//처음엔 갈수있는 경로가 0밖에 없으니 0추가.
		road.add(0);
		//현재 위치, 양, 늑대의 수, 갈수있는 경로.
		dfs(0,0,0, road, info);
        return answer;
    }
    private static void dfs(int idx, int sheep, int wolf, List<Integer> road, int info[]) {
		//만약 현재 위치가 양이라면?
		if(info[idx] == 0) {
			sheep++;
		//늑대라면?
		}else {
			wolf++;
		}
		//만약 양보다 늑대가 같거나 많아진다면 끝내주어야함.
		if(sheep <= wolf) {
			return;
		}
		//위를 다 통과했을 때 가장많이 양을 가지고 있는 경우를 체크하기.
		answer = Math.max(sheep, answer);
		//다음 가야하는 경로를 넣어줄 List 새로 만들기
		List<Integer> nextroad = new ArrayList<>();
		//일단 이전에 가야했던거 전부 넣어주고?
		nextroad.addAll(road);
		//현재 온 곳은 빼주자.
		for(int i = 0; i < nextroad.size(); i++) {
			if(nextroad.get(i) == idx) {
				nextroad.remove(i);
				break;
			}
		}
		//내 현재 위치에 지금 자식이 있다면 그곳에도 갈수 있으니 확인하고 있으면 추가시켜주자.
		if(li[idx] != null) {
			for(int c : li[idx]) {
				nextroad.add(c);
			}
		}
		//갈수 있는 모든 경로 돌기
		for(int next : nextroad) {
			dfs(next, sheep, wolf, nextroad, info);
		}
	}
}