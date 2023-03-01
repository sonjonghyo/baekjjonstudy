import java.util.ArrayList;
import java.util.List;

class Solution {
    public List solution(int k, int[] score) {
        List<Integer> rank = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();
		for(int i = 0; i < score.length; i++) {
			if(rank.size() == 0) {
				rank.add(score[i]);
			}else {
				if(rank.get(0) < score[i]) {
					rank.add(0, score[i]);
				}else {
					for(int j = 0; j < rank.size(); j++) {
						if(rank.get(j) <= score[i]) {
							rank.add(j, score[i]);
							break;
						}
                        if(j == rank.size()-1) {
							rank.add(rank.size(), score[i]);
                            break;
						}
					}
				}
			}
			if(rank.size() < k) {
				answer.add(rank.get(rank.size()-1));
			}else {
				answer.add(rank.get(k-1));
			}
		}
        return answer;
    }
}