class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int length = lock.length + (2 * key.length) - 2;
		//뚫고 넘어갈 수 있으니 확장시켜서 전부 탐색 시켜주기.
		int expand[][] = new int[length][length];
		//확장시킨 배열 가운데에 자물쇠를 집어넣어주기.
		for(int i = key.length - 1; i < key.length + lock.length - 1; i++) {
			for(int j = key.length - 1; j < key.length + lock.length - 1; j++) {
				expand[i][j] = lock[i-(key.length-1)][j-(key.length-1)];
			}
		}
		//전부 탐색하고 없으면 회전하는 식으로 하자.
		for(int r = 0; r < 4; r++) {
			if(check(expand, key, lock.length)) {
				answer = true;
				break;
			}
			//만약 한 방향으로 다 돌았는데 없으면 키 회전.
			key = rotate(key);
		}
        return answer;
    }
    //expand함수 전체를 탐색하며 키가 맞는지 확인 시켜줄 함수입니다.
	private static boolean check(int[][] expand, int[][] key, int length) {
		boolean flag;
		//먼저 전체를 탐색 시켜줄 2중 for문.
		for(int i = 0; i < expand.length - key.length + 1; i++) {
			for(int j = 0; j < expand.length - key.length + 1; j++) {
				//키에 맞는지 확인해줄 boolean변수를 계속 true로 초기화해줍니다.
				flag = true;
				//전체 expand배열에 key배열 추가시켜주기.
				for(int a = 0; a < key.length; a++) {
					for(int b = 0; b < key.length; b++) {
						expand[i+a][j+b] += key[a][b];
					}
				}
				
				//그러고 자물쇠가 있는 구간을 체크해서 전부 1인지 확인.
				for(int a = key.length - 1; a < key.length + length - 1; a++) {
					for(int b = key.length - 1; b < key.length + length - 1; b++) {
						//만약 1이 아닌 구간이 있다면 맞지 않는구간이 있는 것이니 
						//왜 == 0 으로 안했냐면 1에서 1이 더 들어가 2가되는 경우도 있기 때문이다.
						if(expand[a][b] != 1) {
							//2중for문 끝내주기.
							//안맞았으니 flag를 false로 변경.
							flag = false;
							break;
						}
					}
					if(!flag) break;
				}
				//flag가 true이면 자물쇠가 전부 1이므로 true를 return해준다.
				if(flag)
					return true;
				
				//그러고 추가한 만큼 다시 빼주자.
				for(int a = 0; a < key.length; a++) {
					for(int b = 0; b < key.length; b++) {
						expand[i+a][j+b] -= key[a][b];
					}
				}
			}
		}
		return false;
	}
	
	//키를 회전 시켜줄 함수입니다.
	private static int[][] rotate(int[][] key) {
		int tmp[][] = new int[key.length][key.length];
		
		for(int i = 0; i < key.length; i++) {
			for(int j = 0; j < key.length; j++) {
				tmp[i][j] = key[key.length-j-1][i];
			}
		}
		return tmp;
	}
}