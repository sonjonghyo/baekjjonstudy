import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String ch = br.readLine(); //컵홀더를 저장할 변수 ch (cupholder)
		char arr[] = new char[ch.length()]; //ch단어를 하나씩 저장해줄 char형 배열
		int cnt = 0; //몇명이 놓을수있는지 세어주는 변수
		int l = 0; //LL이 처음 나오면 1로 변경해주기.
		for(int i = 0; i<ch.length(); i++) {
			arr[i] = ch.charAt(i);
		}
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == 'S') { //S를 만날때는 무조건 놓을수있으므로 1개 추가된다.
				cnt++; 
			}else if(l == 1 && i>1 && arr[i-1] == 'L' && arr[i] == 'L') { 
                //만약 i>1보다 크고(예외조건) 현재 나 이전에 L이 있었다면
                //나는 놓을수있는게 1개뿐임.
				cnt++;
				i++;
			}else if(l == 1 && arr[i] == 'L') {
                //만약 l이 1이고(이미 앞에 LL이 한번 나왔다는것.)
                //뒤에 L이 또 나오면 cnt는 한번만 추가해줄수있음.
				cnt++;
				i++;
			}else if(arr[i] == 'L') {
                //처음 LL을 만나면 2명 전부 놓을수 있음.
                //따라서 cnt에 2를 더해주고
                //l을 1로만들어 더이상 다른 LL은 2를 못더하게 만들어 주었다.
                //위의 else if식과 이 식에서 i++을 해준이유는 L은 어짜피 LL한쌍이므로 한번더 건너뛰기위해서이다.
				cnt += 2;
				i++;
				l = 1;
			}
		}
		System.out.println(cnt);
	}
}
