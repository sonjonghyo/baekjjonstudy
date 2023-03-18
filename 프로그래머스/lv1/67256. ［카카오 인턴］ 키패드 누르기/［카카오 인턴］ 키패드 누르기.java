class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //왼손의 현재위치를 나타내주는 변수
		String lefthand = "*";
		//오른손의 현재위치를 나타내주는 변수
		String righthand = "#";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numbers.length; i++) {
			//만약 1,4,7의 수를 눌러야 한다면? (왼손으로 누를수 있음.)
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				//왼손이므로 L 추가.
				sb.append("L");
				//왼손의 위치 변경
				lefthand = String.valueOf(numbers[i]);
				continue;
			}else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				//오른손이므로 R 추가.
				sb.append("R");
				//오른손의 위치 변경
				righthand = String.valueOf(numbers[i]);
				continue;
			}else { //2, 5, 8, 0 가운데 있는 것을 누를때는?
				int leftlength = 0; //왼쪽손이 해당 위치까지의 길이를 나타내주는 변수
				int rightlength = 0; //오른쪽손이 해당 위치까지의 길이를 나타내주는 변수
				//만약 숫자가 2라면?
				//현재 위치 파악해서 계산하기.
				if(numbers[i] == 2) {
					if(lefthand.equals("1") || lefthand.equals("5")) {
						leftlength = 1;
					}else if(lefthand.equals("4") || lefthand.equals("8")) {
						leftlength = 2;
					}else if(lefthand.equals("7") || lefthand.equals("0")) {
						leftlength = 3;
					}else if(lefthand.equals("*")) {
						leftlength = 4;
					}else {
						leftlength = 0;
					}
					if(righthand.equals("3") || righthand.equals("5")) {
						rightlength = 1;
					}else if(righthand.equals("6") || righthand.equals("8")) {
						rightlength = 2;
					}else if(righthand.equals("9") || righthand.equals("0")) {
						rightlength = 3;
					}else if(righthand.equals("#")) {
						rightlength = 4;
					}else {
						rightlength = 0;
					}
					if(leftlength < rightlength) {
						sb.append("L");
						lefthand = "2";
					}else if(leftlength > rightlength) {
						sb.append("R");
						righthand = "2";
					}else {
						if(hand.equals("left")) {
							sb.append("L");
							lefthand = "2";
						}else {
							sb.append("R");
							righthand = "2";
						}
					}
				}else if(numbers[i] == 5) {
					if(lefthand.equals("2") || lefthand.equals("4") || lefthand.equals("8")) {
						leftlength = 1;
					}else if(lefthand.equals("1") || lefthand.equals("7") || lefthand.equals("0")) {
						leftlength = 2;
					}else if(lefthand.equals("*")) {
						leftlength = 3;
					}else {
						leftlength = 0;
					}
					if(righthand.equals("2") || righthand.equals("6") || righthand.equals("8")) {
						rightlength = 1;
					}else if(righthand.equals("3") || righthand.equals("9") || righthand.equals("0")) {
						rightlength = 2;
					}else if(righthand.equals("#")) {
						rightlength = 3;
					}else {
						rightlength = 0;
					}
					if(leftlength < rightlength) {
						sb.append("L");
						lefthand = "5";
					}else if(leftlength > rightlength) {
						sb.append("R");
						righthand = "5";
					}else {
						if(hand.equals("left")) {
							sb.append("L");
							lefthand = "5";
						}else {
							sb.append("R");
							righthand = "5";
						}
					}
				}else if(numbers[i] == 8) {
					if(lefthand.equals("5") || lefthand.equals("7") || lefthand.equals("0")) {
						leftlength = 1;
					}else if(lefthand.equals("2") || lefthand.equals("4") || lefthand.equals("*")) {
						leftlength = 2;
					}else if(lefthand.equals("1")) {
						leftlength = 3;
					}else {
						leftlength = 0;
					}
					if(righthand.equals("5") || righthand.equals("9") || righthand.equals("0")) {
						rightlength = 1;
					}else if(righthand.equals("2") || righthand.equals("6") || righthand.equals("#")) {
						rightlength = 2;
					}else if(righthand.equals("3")) {
						rightlength = 3;
					}else {
						rightlength = 0;
					}
					if(leftlength < rightlength) {
						sb.append("L");
						lefthand = "8";
					}else if(leftlength > rightlength) {
						sb.append("R");
						righthand = "8";
					}else {
						if(hand.equals("left")) {
							sb.append("L");
							lefthand = "8";
						}else {
							sb.append("R");
							righthand = "8";
						}
					}
				}else if(numbers[i] == 0) {
					if(lefthand.equals("8") || lefthand.equals("*")) {
						leftlength = 1;
					}else if(lefthand.equals("5") || lefthand.equals("7")) {
						leftlength = 2;
					}else if(lefthand.equals("2") || lefthand.equals("4")) {
						leftlength = 3;
					}else if(lefthand.equals("1")) {
						leftlength = 4;
					}else {
						leftlength = 0;
					}
					if(righthand.equals("8") || righthand.equals("#")) {
						rightlength = 1;
					}else if(righthand.equals("5") || righthand.equals("9")) {
						rightlength = 2;
					}else if(righthand.equals("2") || righthand.equals("6")) {
						rightlength = 3;
					}else if(righthand.equals("3")) {
						rightlength = 4;
					}else {
						rightlength = 0;
					}
					if(leftlength < rightlength) {
						sb.append("L");
						lefthand = "0";
					}else if(leftlength > rightlength) {
						sb.append("R");
						righthand = "0";
					}else {
						if(hand.equals("left")) {
							sb.append("L");
							lefthand = "0";
						}else {
							sb.append("R");
							righthand = "0";
						}
					}
				}
			}
		}
		answer = sb.toString();
        return answer;
    }
}