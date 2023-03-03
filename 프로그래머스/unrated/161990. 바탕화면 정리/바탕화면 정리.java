class Solution {
    public int[] solution(String[] wallpaper) {
        int answer[] = new int[4];
		for(int i = 0; i < 4; i++) {
			if(i == 0 || i == 1) {
				answer[i] = Integer.MAX_VALUE;
			}else {
				answer[i] = Integer.MIN_VALUE;
			}
		}
		for(int i = 0; i < wallpaper.length; i++) {
			for(int j = 0; j < wallpaper[i].length(); j++) {
				if(wallpaper[i].charAt(j) == '#') { //만약 해당 부분이 #이라면?
					if(answer[0] >= i)
						answer[0] = i;
					if(answer[1] >= j)
						answer[1] = j;
					if(answer[2] <= i)
						answer[2] = i+1;
					if(answer[3] <= j)
						answer[3] = j+1;
				}
			}
		}
        return answer;
    }
}