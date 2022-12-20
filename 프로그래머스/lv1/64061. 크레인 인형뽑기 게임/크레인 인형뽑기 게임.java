import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> Doll = new ArrayList<>();
		for(int i = 0; i < moves.length; i++) { //인형을 옮긴 횟수만큼 반복문을 돌려줍니다.
			int catct = moves[i]-1; //배열은 0번째부터시작이므로 -1을 해준 수를 잡은 변수에 넣어줍니다.
			for(int j = 0; j < board.length; j++) {
				if(board[j][catct] != 0) {	//위에서부터 내려오는데 만약 인형이 있는 구간이라면?
					int catchDoll = board[j][catct];
					board[j][catct] = 0; //그 구간엔 인형이 뽑혔으므로 0으로 만들어줍니다.
					if(!Doll.isEmpty()) { //만약 뽑은인형의 칸이 차있는 상황이라면?
						int number = Doll.get(Doll.size()-1); //큐에서 인형을 빼줍니다.
						Doll.remove(Doll.size()-1);
						if(number == catchDoll) { //새로 뽑은인형과 이전에 뽑은 인형이 서로 같다면?
							answer += 2; //2개를 더해주고 끝내줍니다.
							break;
						}else { //다르다면?
							Doll.add(number);
							Doll.add(catchDoll);
							//두개를 뽑은 인형인 큐에 담아주고
							break; //for문을 끝내줍니다.
						}
					}else { //뽑아놓은 인형이 없다면?
						Doll.add(catchDoll); //인형을 뽑아놓은 인형에 추가.
						break;
					}
				}
			}
		}
        return answer;
    }
}