import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //맵을 사용하여 참가자들을 저장해줄 것.
		HashMap<String, Integer> finish = new HashMap<>();
		//참가자들에 대해 for문을 돌려 만약 키가 없었다면 기본값을 0 으로해서 1을 더해주고 있었다면 기존에 있었던 키값에 대한 value를 1 더해주기.
		for(int i = 0; i < participant.length; i++) {
			finish.put(participant[i], finish.getOrDefault(participant[i], 0) + 1);
		}
		//위와 반대로 완주한 사람들의 이름의 value -1씩 해주기.
		for(int i = 0; i < completion.length; i++) {
			finish.put(completion[i], finish.getOrDefault(completion[i], 0) - 1);
		}
		//value를 이용한 key값 찾기.
		for(String key : finish.keySet()) {
			//만약 value가 1이라면 그사람이 완주를 못한것이므로 저장후 break;
			if(finish.get(key).equals(1)) {
				answer = key;
				break;
			}
		}
        return answer;
    }
}