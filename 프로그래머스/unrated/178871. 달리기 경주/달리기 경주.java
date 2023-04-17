import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < players.length; i++) {
			map.put(players[i], i);
		}
		//불렀을때 해당 사람의 키값확인.
		for(int i = 0; i < callings.length; i++) {
			int tmp = map.get(callings[i]);
			map.replace(players[tmp-1], tmp-1, tmp);
			map.replace(callings[i], tmp, tmp-1);
			String tmp1 = players[tmp]; //바꿀 변수
			players[tmp] = players[tmp-1];
			players[tmp-1] = tmp1;
		}
        return players;
    }
}