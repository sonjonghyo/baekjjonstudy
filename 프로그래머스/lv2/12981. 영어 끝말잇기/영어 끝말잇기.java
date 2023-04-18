import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
		int answer[] = new int[2];
		for(int i = 0; i < words.length; i++) {
			if(!list.contains(words[i])) {
				//리스트가 이미 나와있는 단어를 포함하고있지 않다면?
				list.add(words[i]); //추가해주기.
			}else {
				//이미 나와있는 단어라면?
				answer[0] = (i%n) + 1; //0부터시작이므로 +1을 해줌
				answer[1] = (i/n) + 1; //위와 마찬가지.
				break;
			}
			if(i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) { //이전 글자의 끝말과 새로운 말의 시작말이 다르다면?
				answer[0] = (i%n) + 1;
				answer[1] = (i/n) + 1;
				break;
			}
		}
        return answer;
    }
}