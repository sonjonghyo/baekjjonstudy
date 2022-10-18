import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next(); //알파벳 문자를 입력으로 받아줌.
		int arr[] = new int[26]; //알파벳의 개수 a~z까지 개수를 담아줄 배열을 만들어준다.
		word = word.toLowerCase(); //word의 모든 단어를 소문자로 만들어주는 함수를 
		for(int i = 0; i<word.length(); i++) { //word의 길이만큼 for문을 돌려주겠다.
			arr[(word.charAt(i)-'a')]++; //배열에 word안의 i번째 단어에 'a'를 빼주어 아스키코드값 0부터 시작하게 만들어준다. 
		}
		int max = 0; //최대값을 설정해줌.
		int idx = 0; //최대값의 인덱스를 찾아줌.
		int cnt = 0; //최대값의 개수.
		for(int i = 0; i<26; i++) { //알파벳의 개수만큼 for문을 돌려 최대값을 찾아줌.
			if(arr[i] > max) { //만약 현재의 최대값보다 arr[i]의 값이 더 크다면(알파벳이 더 많이 나왔다면)
				max = arr[i]; //max에 arr[i]를 넣어줌.
				idx = i; //몇번째인지 idx에 넣어준다.
			}
		}
		for(int i = 0; i<26; i++) { //최대값과 같은 것의 개수가 몇개인지 확인.
			if(arr[i] == max) //값이 max와 같다면
				cnt++; //cnt를 추가시켜줌.
		}
		if(cnt==1) { //최대값이 1개라면
			char result = (char)(65+idx); //대문자A의 아스키코드값은 65이므로 65+idx를 해주어 소문자로 저장시켜줌.
			System.out.println(result); //결과 출력
		}else { //최대값이 1개가아닌 여러개라면
			System.out.println("?"); //?를 출력하게 해준다.
		}
		sc.close();
	}
}