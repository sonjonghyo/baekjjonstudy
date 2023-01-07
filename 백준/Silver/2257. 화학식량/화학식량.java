import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String chemicalfood = br.readLine(); //식량을 입력.
		Stack<Integer> food = new Stack<>();
		int length = chemicalfood.length(); //식량의 길이를 미리 저장해줄 변수입니다.
		int sum = 0; //중간중간 합을 더해줄 변수입니다.
		for(int i = 0; i < length; i++) {
			char ch = chemicalfood.charAt(i); //해당하는 원소 뽑아내기.
			if(ch == '(') { //여는 괄호라면?
				food.add(0); //추가시켜줍니다.(Integer라 (를 넣을수없음. 숫자0으로 대체.)
			}else if(ch ==')') { //닫는 괄호라면?
				sum = 0;
				while(true) { //여는괄호가 나올때까지 while문.
					if(food.peek() == 0) { //여는 괄호라면?
						food.pop();
						food.add(sum); //그대로 sum을 추가합니다.
						break; //while문을 끝내줍니다.
					}
					sum += food.pop(); //스택의 맨 위에있는 수를 누적해서 더해줍니다.
				}
			}else if(ch == 'C') {
				food.add(12);
			}else if(ch == 'H') {
				food.add(1);
			}else if(ch == 'O') {
				food.add(16);
			}else {
				int lastnum = food.pop(); //위에쌓여있던 마지막 수를 뽑아내기.
				lastnum = lastnum * (ch-'0'); //lastnum을 현재 나온 숫자를 곱한수로 바꿔준 후에
				food.add(lastnum); //더해줍니다.
			}
		}
		int result = 0; //결과를 내줄 변수입니다.
		while(!food.isEmpty()) { //다 빌때까지 빼주기.
			result += food.pop(); //하나씩 빼주면서 더해줍니다.
		}
		System.out.println(result);
	}
}