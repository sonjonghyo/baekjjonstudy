import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List solution(String[] record) {
        List<String> answer = new ArrayList<>();
		HashMap<String, String> nickUID = new HashMap<>();
		String splitRecord[][] = new String[record.length][3];
		for(int i = 0; i < record.length; i++) {
			splitRecord[i] = record[i].split(" ");
			if(!splitRecord[i][0].equals("Leave")) {
				nickUID.put(splitRecord[i][1], splitRecord[i][2]);
			}
		}
	

		for(int i = 0; i < record.length; i++) {
			if(splitRecord[i][0].equals("Enter")) {
				answer.add(nickUID.get(splitRecord[i][1]) + "님이 들어왔습니다.");
			}else if(splitRecord[i][0].equals("Leave")) {
				answer.add(nickUID.get(splitRecord[i][1]) + "님이 나갔습니다.");
			}
		}
        return answer;
    }
}