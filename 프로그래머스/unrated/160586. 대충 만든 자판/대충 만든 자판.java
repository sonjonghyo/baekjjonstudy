class Solution {
    public int[] solution(String[] keymap, String[] targets) {
       int answer[] = new int[targets.length];
		 for(int i = 0; i < targets.length; i++) {
			 int cnt = 0;
		loop:for(int j = 0; j < targets[i].length(); j++) {
				int idx = Integer.MAX_VALUE;
				for(int k = 0; k < keymap.length; k++) {
					for(int z = 0; z < keymap[k].length(); z++) {
						if(targets[i].charAt(j) == keymap[k].charAt(z)) {
							if(idx > z) { 
								idx = z;
							}
							if(idx==0)
								break;
						}
					}
					if(idx==0)
						break;
				}
				if(idx == Integer.MAX_VALUE) {
					cnt = -1;
					break loop;
				}else {
					cnt += idx+1;
				}
			}
			 answer[i] = cnt;
		}
        return answer;
    }
}