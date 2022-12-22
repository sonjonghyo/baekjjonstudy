import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	//Comparator를 이용해서 풀수있음.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //도현이네 반 학생의 수
		String nameScore[][] = new String[N][4];
		//이름과 점수를 국,영,수 점수를 저장해줄 String배열입니다.
		//0번째에는 이름 1~3번째에는 차례대로 국, 영, 수 점수가 들어갑니다.
		//국어점수는 내림차순 영어점수는 오름차순 수학점수는 내림차순
		//다 같을시에 이름 사전 순.(오름차순)
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nameScore[i][0] = st.nextToken(); //이름을 저장.
			nameScore[i][1] = st.nextToken(); //국어 점수를 저장.
			nameScore[i][2] = st.nextToken(); //영어 점수를 저장.
			nameScore[i][3] = st.nextToken(); //수학 점수를 저장.
		}
		Arrays.sort(nameScore, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[1].equals(o2[1])) { //먼저 국어 점수가 같은지 확인해 줍니다.
					if(o1[2].equals(o2[2])) { //그 다음 영어 점수가 같은지 확인해 줍니다.
						if(o1[3].equals(o2[3])) { //그 다음 수학 점수가 같은지 확인해 줍니다.
							return o1[0].compareTo(o2[0]); //만약 다 같을시엔? 이름순으로 오름차순 정렬해줍니다.
						}
						return Integer.parseInt(o2[3])-Integer.parseInt(o1[3]); //만약 수학점수에서 다르다면 내림차순
					}
					return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]); //영어 점수에서 다르다면 오름차순.
				}
				return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]); //국어점수에서 다르다면 내림차순 정렬을 해줍니다.
			}
		});
		
		for(int i = 0; i < N; i++) { //다 정렬이 되었으므로 순서대로 출력해주면 됩니다.
			System.out.println(nameScore[i][0]);
		}
	}
}