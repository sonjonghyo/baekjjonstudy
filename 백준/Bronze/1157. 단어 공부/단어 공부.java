import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String big = S.toUpperCase(); //모든 문자를 대문자로 만들어준다.
		int arr[] = new int[26]; //알파벳 A~Z까지 0~25번에 담음.
		for(int i = 0; i<big.length(); i++) {
			int num = big.charAt(i)-65; //대문자A의 아스키코드값이 65이므로 0~25의 수가담기게 된다. 
			arr[num]++; //A~Z까지 각 빈도수 체크.
		}
		int max = 0;
		int maxidx = 0;
		boolean check = true;
		for(int i = 0; i<arr.length; i++) {
			if(max<arr[i]) { //최대 빈도수 구하기.
				max=arr[i];
				maxidx=i; 
			}
		}
		for(int i = 0; i<arr.length; i++) {
			if(max==arr[i]) { //만약 최대빈도의 값이 나왔다면? 
				if(maxidx != i) { //최대빈도가있는 maxidx랑 현재 i를 비교해 만약 다르다면 똑같은 빈도가 있다는 뜻이므로. 
					System.out.println("?"); //?를 출력해주고
					check = false; //check 변수를 false로 만들어주고
					break; //for문을 끝내준다.
				}
			}
		}
		if(check) { //위에서 빈도수가 같은것이있었다면 false라 동작을안하지만 같은것이 없고 유일이었으면 동작.
			char result = (char)(65+maxidx); //대문제 A의 아스키코드가 65이므로 65+그 문자에 해당하는 maxidx를 더해준다.
			System.out.println(result);
		}
	}
}