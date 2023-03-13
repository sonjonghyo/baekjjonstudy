class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String crying[] = {"aya", "ye", "woo", "ma"};
		String noCrying[] = {"ayaaya", "yeye", "woowoo", "mama"}; //반복되는것이 나와서는 안돼
		
		for(int i = 0; i < babbling.length; i++) {
			if(babbling[i].contains(noCrying[0]) || babbling[i].contains(noCrying[1]) || babbling[i].contains(noCrying[2]) || babbling[i].contains(noCrying[3]))
				continue;
			
			babbling[i] = babbling[i].replace(crying[0], " ");
			babbling[i] = babbling[i].replace(crying[1], " ");
			babbling[i] = babbling[i].replace(crying[2], " ");
			babbling[i] = babbling[i].replace(crying[3], " ");
			babbling[i] = babbling[i].replace(" ", "");
			
			if(babbling[i].length()==0)
				answer++;
		}
        return answer;
    }
}