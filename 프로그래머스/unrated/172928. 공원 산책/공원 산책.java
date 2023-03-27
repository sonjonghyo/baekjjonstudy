class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int startx = 0;
		int starty = 0;
		loop : for(int i = 0; i < park.length; i++) {
			for(int j = 0; j < park[i].length(); j++) {
				if(park[i].charAt(j) == 'S') {
					startx = j;
					starty = i;
					break loop;
				}
			}
		}
		for(int i = 0; i < routes.length; i++) {
			String direction[] = routes[i].split(" "); //split을 사용하여 띄어쓰기를 기준으로 나누어 줍니다.
			int distance = Integer.parseInt(direction[1]); //형 변환
			boolean flag = true; //매번 돌때마다 제대로 동작하는지 확인하기 위해 flag 사용.
			switch(direction[0]) { //방향을 나타내주는 direction[0];
			case "N" :
				int tmpn = starty;
				//북쪽이므로 y에 대한 값만 확인하면 된다.
				for(int j = 0; j < distance; j++) {
					tmpn--;
					if(tmpn < 0) { //만약 0보다 작아진다면?
						flag = false;
						break;
					}						
					if(park[tmpn].charAt(startx) == 'X') {
						flag = false;
						break;
					}
				}
				if(flag) { //이동이 가능하다면?
					starty = tmpn;
				}
				break;
			case "S" :
				int tmps = starty;
				//남쪽이므로 y에 대한 값만 확인하면 된다.
				for(int j = 0; j < distance; j++) {
					tmps++;
					if(tmps >= park.length) { //만약 세로 최대길이보다 커진다면?
						flag = false;
						break;
					}
					if(park[tmps].charAt(startx) == 'X') {
						flag = false;
						break;
					}					
				}
				if(flag) { //이동이 가능하다면?
					starty = tmps;
				}
				break;
			case "W" :
				int tmpw = startx;
				//서쪽이므로 x에 대한 값만 확인하면 된다.
				for(int j = 0; j < distance; j++) {
					tmpw--;
					if(tmpw < 0) { //만약 0보다 작아진다면?
						flag = false;
						break;
					}
					if(park[starty].charAt(tmpw) == 'X') {
						flag = false;
						break;
					}
				}
				if(flag) { //이동이 가능하다면?
					startx = tmpw;
				}
				break;
				
			case "E" :
				int tmpe = startx;
				//동쪽이므로 x에 대한 값만 확인하면 된다.
				for(int j = 0; j < distance; j++) {
					tmpe++;
					if(tmpe >= park[0].length()) { //만약 가로 최대길이 보다 커진다면?
						flag = false;
						break;
					}
					if(park[starty].charAt(tmpe) == 'X') {
						flag = false;
						break;
					}
				}
				if(flag) { //이동이 가능하다면?
					startx = tmpe;
				}
				break;
			}
		}
        answer[0] = starty;
        answer[1] = startx;
        return answer;
    }
}