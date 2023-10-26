import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        //나와 부모를 저장해줄 map입니다.
		HashMap<String, String> parent = new HashMap<>();
		//여태까지 나에게 쌓인 돈을 저장해줄 맵입니다.
		HashMap<String, Integer> money = new HashMap<>();
		//전체 사람의 수만큼 for문을 돌려 참여시킨 조직원들을 체크해줍니다.
		for(int i = 0; i < enroll.length; i++) {
			parent.put(enroll[i], referral[i]);
		}
		for(int i = 0; i < seller.length; i++) {
			//seller가 판 총 금액을 price에 저장.
			int price = amount[i] * 100;
			//현재 위치해 있는 사람을 저장.
			String human = seller[i];
			//그러고서 money에 판 사람이 가져갈 수 있는 90% 저장.
			money.put(human, money.getOrDefault(human, 0) + price -  price/10);
			//현재 금액 / 10 이 1의 단위보다 크고 내 연결책이 있을때만 while문 동작.
			while(price / 10 > 0 && parent.containsKey(human) && !parent.get(human).equals("-")) {
				//human을 내 부모로 바꿔주고.
				human = parent.get(human);
				//금액을 1/10으로 나눠준다.
				price /= 10;
				//그러고서 money에 저장.
				money.put(human, money.getOrDefault(human, 0) + price -  price/10);
			}
		}
		//money에 담긴 값 뽑아주기.
		for(int i = 0; i < enroll.length; i++) {
			answer[i] = money.getOrDefault(enroll[i], 0);
		}
        return answer;
    }
}