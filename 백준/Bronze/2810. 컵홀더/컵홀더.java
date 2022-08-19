import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String ch = br.readLine(); //컵홀더를 저장할 변수 ch (cupholder)
		char arr[] = new char[ch.length()]; //ch단어를 하나씩 저장해줄 char형 배열
		int cnt = 0; //몇명이 놓을수있는지 세어주는 변수
		int l = 0;
		for(int i = 0; i<ch.length(); i++) {
			arr[i] = ch.charAt(i);
		}
		for(int i = 0; i<arr.length; i++) {
			// arr배열 안에있는 단어가 S 인지 L인지 보고 판단하기.
			// S이면 +1을
			// S 뒤에 LL이 오면 +2를
			// LL 뒤에 LL이오면 +1을 해준다.
			if(arr[i] == 'S') {
				cnt++;
			}else if(l == 1 && i>1 && arr[i-1] == 'L' && arr[i] == 'L') {
				cnt++;
				i++;
			}else if(l == 1 && i!=0 && i==arr.length-2 && arr[i] == 'L') {
				cnt++;
				i++;
			}else if(l == 1 && i>2 && arr[i] == 'L') {
				cnt++;
				i++;
			}else if(arr[i] == 'L') {
				cnt += 2;
				i++;
				l = 1;
			}
		}
		System.out.println(cnt);
	}

}
