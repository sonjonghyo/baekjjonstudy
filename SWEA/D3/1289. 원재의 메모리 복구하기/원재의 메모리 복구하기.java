import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			sc.nextLine();
			String s = sc.next();
			int arr[] = new int[s.length()];
			for(int i = 0; i<arr.length; i++) {
				arr[i] = s.charAt(i)-48;
			}
			boolean check = true;
			while(check) {
				int change = 0;
				int cnt = 0;
				for(int i = 0; i<s.length(); i++) { //처음부터 0인지 1인지 확인해줌.
					cnt = i; //0이 몇개인지 세어주는 변수
					if(arr[i]==1) { //만약 1이라면 그 지점부터 메모리를 복구하기 시작한다.
						change++; //바꾼횟수.
						for(int j = i; j<s.length(); j++) {
							if(arr[j]==1) { //만약 j가 1이라면
								arr[j] = 0; //반대로 바뀌므로 0으로 바꾸어주고
								cnt++;
							}else {
								arr[j] = 1; //여기도 마찬가지이다.
							}
						}
					}
					if(cnt==s.length()) {
						sb.append(change);
						check = false;
						break;
					}
				}
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}