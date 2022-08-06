import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[N][5]; //학년은 5학년 고정이므로 행은 5행 열은 학생수가 내가 정해줄수 있으므로 N으로 설정함.
		int grade = 0; 
		int ban = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt(); //배열 생성
			}
		}
		for (int a = 0; a < N; a++) {
			Set<Integer> set = new HashSet<>();  //중복을 방지하기 위해 Set을 사용해줌
			for (int i = 0; i < 5; i++) { //비교해줄 학생수만큼 돌려야 하므로 N까지.
				for (int j = 0; j < N; j++) { //5학년까지있으므로 5보다 작게 돌리면 된다.
						if(a==j) //a랑 j가 같은경우는 자기 자신을 의미하기때문에 다음으로 넘겨주면 된다.
							continue;
						if(arr[a][i] == arr[j][i]) {
							set.add(j); //같은 부분이 있으면 set.add로 추가시킨다.
						}
					}
				}
			if(ban < set.size()) {
				ban = set.size();
				grade = a + 1;
			}
			}
			if(grade == 0) {
				System.out.println(1); //만약 모두가 같은반이 아닐확률이 있을수 있기에 grade가 0일시 1번이 반장이 되게한다.
			}else {
				System.out.println(grade);
			}
			sc.close();
		}
}