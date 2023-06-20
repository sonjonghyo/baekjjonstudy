class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++) {
			int min = -1;
			loop: for(int j = 0; j < skill_trees[i].length(); j++) {
				for(int k = 0; k < skill.length(); k++) {
					if(skill.charAt(k) == skill_trees[i].charAt(j)) {
						if(min + 1 == k) {
							min = k;
						}else {
							break loop;
						}
					}
				}
				if(j == skill_trees[i].length()-1)
					answer++;
			}
		}
        return answer;
    }
}