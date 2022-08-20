import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[1001][1001]; // 색종이가 놓이는 평면.
		int result[] = new int[N];  //마지막 색종이의 넓이를 저장하기 위한 배열.
		int len[] = new int[N * 4]; //내가 입력한 x,y의 길이와 확장된 x,y의 길이를 저장하기 위해 N*4크기인 배열 생성.
		int sum = 0; //넓이 저장해줄 변수.
		int idx = 0; //result의 인덱스를 변경해줄 변수
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()); //x축 시작지점
			int j = Integer.parseInt(st.nextToken()); //y축 시작지점
			int xlen = Integer.parseInt(st.nextToken()) + i; //x축 끝나는 지점
			int ylen = Integer.parseInt(st.nextToken()) + j; //y축 끝나는 지점.
			for (int l = tc * 4; l <= 4 * tc; l++) { //배열에 위 지점들을 모두 저장시킴.
				len[l] = i;
				len[l + 1] = j;
				len[l + 2] = xlen;
				len[l + 3] = ylen;
			}
			for (int x = i; x < xlen; x++) { //먼저 전체 색종이가 놓이는 평면에서 내가 놓은부분은 전부 1로 만들어준다.
				for (int y = j; y < ylen; y++) {
					if (arr[x][y] == 0) {
						arr[x][y]++;
					}
				}
			}
		}
		for (int a = len.length - 1; a >= 0; a = a - 4) { //가장 마지막에 놓아준 색종이부터 하나하나씩 제거해준다.
			sum = 0; //sum은 색종이를 하나 뗄때마다 초기화 시켜준다.
			for (int x = len[a - 3]; x < len[a - 1]; x++) { //x축의 길이
				for (int y = len[a - 2]; y < len[a]; y++) { //y축의 길이
					if(arr[x][y] == 1) { //만약 내가 놓은 구간이 1이라면
						sum++; //1칸 추가시키고
						arr[x][y] = 0; //내가 썼으므로 내 뒤에있는 색종이는 가려지므로 0으로 만들어준다.
					}
				}
			}
			result[idx++] = sum; //2중 for문이 끝나고 result배열에 sum을 저장해준다.
		}
		for(int a = result.length-1; a>=0; a--) { //result배열의 끝부분부터 출력해야하니 result의 길이-1부터 0까지 for문을 사용한다.
			System.out.println(result[a]);
		}
	}
}
