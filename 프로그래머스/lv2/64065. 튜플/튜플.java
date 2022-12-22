import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        s = s.replace("{", ""); // "{" 문자 전부 빈공간으로 만들어주기.
		s = s.replace("}", ""); // "}" 문자 전부 빈공간으로 만들어주기.
		String number[] = s.split(",");
		List<Integer> tuple = new ArrayList<>();
		boolean exists[] = new boolean[100001]; //1이상 10만이하의 자연수 체크.
		int check[] = new int[100001]; //몇번 나왔는지 체크.
		for(int i = 0; i < number.length; i++) {
			int current = Integer.parseInt(number[i]); //현재 수가 몇인지 current에 저장.
			if(!exists[current]) { //만약 한번도 없었다면?
				exists[current] = true;
				tuple.add(current); //리스트에 수를 담아주고
				check[current]++; //1번 발생
			}else {
				check[current]++; //추가 발생.
			}
		}
		int answer[] = new int[tuple.size()]; //튜플의 개수만큼 answer의 사이즈 재생성.
		int cnt = 1; //튜플은 1개부터이므로 cnt는 1부터
		int savepoint = tuple.size()-1; //저장은 가장많은것 부터니 넣어주는 것은 size-1부터
		while(!tuple.isEmpty()) {
			for(int i = 0; i < tuple.size(); i++) {
				if(cnt == check[tuple.get(i)]) { //cnt와 횟수가 같다면?
					answer[savepoint] = tuple.get(i); //결과를 넣어줄 answer에 tuple에 해당하는 값 넣어주고
					tuple.remove(i); //list에서 없애고 
					cnt++; //cnt를 하나 증가시켜 다음 튜플을 찾고
					savepoint--; //저장위치를 하나 앞서게 만들고
					break; //for문은 더이상 돌 필요없으므로 break를 걸어줍니다.
				}
			}
		}
        return answer;
    }
}