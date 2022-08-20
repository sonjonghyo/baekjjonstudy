import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine());
		int cake[] = new int[L]; //케이크의 길이만큼 배열생성
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N]; //방청객의 수만큼 배열생성
		int mi[] = new int[N]; //내가 가장많이가져갈거같은 사람을 구하기 위해 두수의 차가 가장 큰사람을 구할것.
		int max = 0; //가장 많이 가져가는 사람의 번호
		int imax = 0; //내가 가장 많이 가져갈거라고 생각하는 사람의 번호.
		int di = 0;
		int idi = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken()); //케이크를 가져갈 시작위치
			int l = Integer.parseInt(st.nextToken()); //케이크를 가져갈 마지막위치.
			mi[i] = l-f; //내가 원래 가져갈수있는 케이크의 수를 mi배열에 저장.
			for(int j = f-1; j<=l-1; j++) { //내가 가져갈수 있는 케이크를 구하기위해 f-1부터 l-1까지 for문 사용(f-1와 l-1은 실제배열은 0부터 시작하므로 사용)
				if(cake[j] == 0) { //만약 케이크를 가져간사람이없다면
					arr[i]++;  //내가 한조각을 가져갈수 있으므로 +1을 해주고
					cake[j]++; //다른사람은 못가져가므로 케이크를 +1을 해준다.
				}
			}
		}
		for(int i = 0; i<N; i++) { //제일많이 케이크를 가져간사람을 구하기 위해 for문 사용.
			if(arr[i]>max) { //케이크를 제일 많이 가져갔다면
				max = arr[i]; //max에 가장많이 가져간 개수를 저장하고
				di = i; //그 위치를 di에 저장해준다.
			}
			if(mi[i]>imax) { //위와같은데 이것은 가장많이 가져갈거라고 생각한 것.
				imax = mi[i];
				idi = i;
			}
		}
		System.out.println(idi+1); //가장 많이 가져갈거라 생각한사람.
		System.out.println(di+1); //실제로 가장 많이 가져간 사람.
	}
}
