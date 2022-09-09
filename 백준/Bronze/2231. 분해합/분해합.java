import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		//N부터 0까지 작아지게 for문을 돌리고
		//그 안에 while문을 돌려 %10을 이용하여 나머지는 전부 더해주고 10씩 다시 나누어 0이될때까지 계산
		//만약 N과 그 안에서 더한것들의 합이 같다면 그중에서 계속 작은 i의 값을 min에 저장후 출력.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE; //min을 먼저 가장 큰수로 저장해놓는다.
		boolean check = false; //생성자가 있었는지 없었는지 확인해주는 boolean변수.
		for(int i = N; i>=0 ; i--) { //N부터 시작하여 0까지 작아지는 for문을 만든 후
			int tmp = i; //i가 변하지 않도록 tmp라는 변수를 이용하여 while문안에서 각 자리를 더하게 구현해줄 것.
			int sum = i; //sum은 i와 각 자리수의 합을 계산해줄것.
			while(tmp!=0) { //tmp가 0이 될때까지 while문이 돌아가게 만들것입니다.
				sum = sum + tmp%10; //먼저 i의 일의자리수를 구하기 위해 %10을 사용하여 나머지를 구해준후 sum에 더해줍니다.
				tmp /= 10; //그러고 tmp를 10으로 나누어 그 나머지부분을 삭제해줍니다.
			}
			if(sum==N) { //while문이 끝나고 만약 sum의 값이 N의 값과 같다면 생성자이므로 
				if(min>i) { //만약 i가 min보다 작다면
					min = i; //그 값이 더 작은 생성자이므로 min에 저장후
					check = true; //생성자가 있으므로 true로 만들어준다.
				}
			}
		}
		if(check) { //만약 생성자가있었다면
			System.out.println(min); //min을 출력해주고			
		}else { //없었다면
			System.out.println(0); //0을 출력해준다.
		}
	}
}