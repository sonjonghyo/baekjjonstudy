import java.util.Scanner;
import java.util.Stack;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		for(int tc = 1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			for(int i = 0; i<arr.length; i++) {
				for(int j = 0; j<arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int cnt = 0; //교착상태에있는 갯수확인.
			//스택을 이용한다.
			//빨간색은 위에서 아래로 파란색은 아래에서 위로 올라간다는 특성을 이용하여
			//빨간색을 만나면 stack에 넣어주고 파란색을만나면 빼주는 것을 이용해준다.
			for(int i = 0; i<arr.length; i++) {
				for(int j = 0; j<arr[i].length; j++) {
					if(arr[j][i]==1) { //N극인 경우
						s.add(1);								
					}else if(arr[j][i]==2) { //S극인 경우
						if(s.size()==0) { //만약 사이즈가 0이라는 것은 바로 파란색을 만난것이므로 사라짐.
							continue;
						}
						if(s.peek()==1) {
							s.add(2);
							cnt++;
						}else {
                            s.add(2);
                        }
					}else { //0인경우 아무것도 일어나지 않는다.
						continue;
					}
				}
				s.clear(); //한 열을 끝냈으면 스택을 초기화 시켜준다.
			}
			sb.append(cnt);
			if(tc!=10)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}