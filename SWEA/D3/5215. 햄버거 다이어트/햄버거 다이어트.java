
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//비트마스킹으로 풀기 << (요거) 
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) { //테스트 케이스만큼 반복.
			sb.append("#").append(tc).append(" "); //먼저 StringBuilder에 이후에 출력될 #tc케이스횟수 " "를 저장한다.
			int N = sc.nextInt(); //재료의 개수
			int L = sc.nextInt(); //제한 칼로리
			int ham[][] = new int[N][2]; //[N][0]에는 맛에대한 정보를 저장, [N][1]에는 칼로리에 대한 정보를 저장해준다.
			
			for(int i = 0; i<N; i++) { //N만큼 반복해 arr배열에 맛과 칼로리를 저장해준다.
				ham[i][0] = sc.nextInt(); //맛을 저장
				ham[i][1] = sc.nextInt(); //칼로리를 저장
			}
			//비트마스킹으로 범위 줘서 구하기
			//1 << i
			int max = 0; //칼로리가 L을 넘지않는 선에서의 맛의 최대값을 for문이 돌아가기전에 미리 초기화 시켜놓는다.
			for(int i = 0; i< 1<<N; i++) { //부분집합의 개수만큼 초기화 시켜준다.(2의N승개만큼이므로 쉬프트연산자를 사용하여 1을 N번만큼 <<밀어준다.)
				int mat = 0; //아래에 범위만큼 돌기전에 맛과 칼로리를 미리 초기화 시켜놓고 아래에서만 누적되게 한다.
				int cal = 0; //칼로리
				for(int j = 0; j<N; j++) {
					if((i & (1 << j)) > 0) { //해당원소가 존재하는지 검사하는 부분. 존재한다면 맛과 칼로리 추가
						mat += ham[j][0];
						cal += ham[j][1];
						if(cal > L) { //만약 칼로리가 제한칼로리보다 크면 그때의 i번째는 의미가 없으므로 break를 걸어준다.
							mat = 0; //0으로 만들어주는 이유는 아래에 break가 걸리면 j에 대한 for문이 끝나는데 아래의 max값 비교에 걸리기 때문이다.
							break;
						}
					}
				}
				max = Math.max(max, mat); //범위만큼 다 돌고나서 맛의 최대치와 비교해 더 큰값을 max에 저장해준다.
			}
			sb.append(max); //부분집합에 대해 다 돌았다면 StringBuilder에 max값을 저장해주고
			if(tc!=T) //만약 tc가 T와 같지않다면 개행문자추가, 같다면 개행문자를 추가하지않는다.
				sb.append("\n");
		}
		System.out.println(sb); //마지막으로 StringBuilder에 쌓여있는 것을 전부 출력해준다.
	}
}