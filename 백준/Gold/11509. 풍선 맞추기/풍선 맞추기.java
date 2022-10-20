import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner를 사용할시 N이 최대 100만까지 가능하므로 백만개의 입력을 가지고있어 메모리를 많이 먹게됩니다.
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //풍선의 개수
		int arr[] = new int[1000001]; //높이는 1~100만까지 가능
		int cnt = 0; //총 사용한 화살의 개수.
		st = new StringTokenizer(br.readLine()); //배열안에 넣어줄 화살의 높이를 입력.
		for(int i = 0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken()); //입력을 받아오고
			if(arr[a]==0) { //만약 현재 위치가 0이라면
				arr[a-1]++; //한칸 아래에 1을 추가해주고(내 위치를 터트리고 내 아래로 화살이 간것.)
				cnt++; //화살을 1개 쏘아준다.
			}else { //1이상이라면?
				arr[a-1] += 1; //내 아래위치에 화살을 하나 증가시켜줌
				arr[a] -= 1; //나의 위치에 있는 화살 하나감소.(풍선 하나 터침).
			}
		}		
		System.out.println(cnt); //이때 총 더해진 cnt가 화살의 개수이다.
		br.close();
	}
}