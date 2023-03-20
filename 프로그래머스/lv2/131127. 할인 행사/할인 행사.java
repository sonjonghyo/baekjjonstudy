import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> sale = new HashMap<>();
		int repeat = discount.length - 10; //반복을 몇번해야하는지 체크.
		for(int i = 0; i <= repeat; i++) {
				sale.clear(); //한번 돌때마다 맵 초기화 시켜주기.
				for(int j = i; j < 10+i; j++) { //최대 10일까지 회원유지가 가능하므로 10인데 반복횟수만큼 더해주기.
					sale.put(discount[j], sale.getOrDefault(discount[j], 0) + 1); //10일간 할인항목들 전부 map에 저장.(중복시 개수 +1)
				}
				for(int j = 0; j < want.length; j++) {
					if(sale.containsKey(want[j])) { //키가 존재한다면?(존재하지 않으면 아래의 get에서 NullPointerException 발생.)
						if(sale.get(want[j]) != number[j]) //할인 개수가 모자르다면?
							break; //for문을 끝내줍니다.
						if(j == want.length -1) { //만약 for문 끝까지 갔다면?
							answer++; //살수 있으므로 답을 추가.
						}						
					}else {
                        break;
                    }
				}
		}
        return answer;
    }
}