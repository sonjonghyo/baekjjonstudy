import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//수고비를 받을 사람을 선출하는 방식.
		//우선 받은 투표에서 5%미만은 칩받을 스태프 후보에서 제외
		int X = Integer.parseInt(br.readLine()); //참가자들의 수(총 투표수)
		int N = Integer.parseInt(br.readLine()); //참가한 스태프의 수
		String staffName[] = new String[10]; //참가한 스태프 수가 최대 10명이므로 10 저장.
		float score[][] = new float[10][14]; //실수를 가진 점수집합.
		//먼저 2차원 배열에 스태프 이름, 값에 대해 저장하고 나서 알파벳순으로 먼저 정렬해주기.
		String StaffArr[][] = new String[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String vote = st.nextToken();
			StaffArr[i][0] = name; //이름을 i,0에 저장
			StaffArr[i][1] = vote; //투표율을 i,1에 저장(나중에 뽑을때 parseInt사용.)
		}
		Arrays.sort(StaffArr, new Comparator<String[]>() { //정렬해주기.

			@Override
			public int compare(String[] o1, String[] o2) {
				  if(o1[0].toString().contentEquals(o2[0].toString()))
	                    return o1[1].toString().compareTo(o2[1].toString());
	                else
	                    return o1[0].toString().compareTo(o2[0].toString());
			}
			
		});
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			float turnout = 0.0f; //투표율
			int vote = Integer.parseInt(StaffArr[i][1]);
			turnout = vote/(float)X;
			if(turnout < 0.05) { //만약 투표율이 5%미만이라면?
				continue; //다음.
			}else { //5%이상이라면
				staffName[cnt] = StaffArr[i][0]; //스태프의 이름을 저장.
				for(int a = 0; a < 14; a++) { //투표율 저장.
					score[cnt][a] = vote/(a+1);
				}
				cnt++;
			}
		}
		int chip[] = new int[cnt];
		for(int i = 0; i < 14; i++) {
			float max = 0; //최대값을 0으로 초기화시켜줍니다.
			int maxj = 0;
			int maxk = 0;
			for(int j = 0; j < cnt; j++) {
				for(int k = 0; k < 14; k++) {
					if(score[j][k] == 0) { //0이면 다음
						continue;
					}else {
						if(score[j][k] > max) {
							max = score[j][k];
							maxj = j;
							maxk = k;
							break;
						}else {
							break;
						}
					}
				}
			}
			score[maxj][maxk] = 0;
			chip[maxj]++;
		}
		for(int i = 0; i < cnt; i++) {
			sb.append(staffName[i]).append(" ").append(chip[i]);
			if(i != cnt-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}