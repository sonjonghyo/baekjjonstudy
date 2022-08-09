import java.util.Scanner;
public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int l = 0; //내가 쓴 문자의 길이.
	int cnt = 0; //총 몇개가 그룹단어인지 체크.
	for(int i = 0; i<N; i++) {
		String s = sc.next();
		int error = 0; //그룹단어가 아닐시 1로 바꿔주기위해 사용.
		l = s.length(); 
		if(l<3) { //만약 문자의 길이가 2이하라면 무조건 그룹단어이기때문에 cnt++를 사용.
			cnt++;
		} else {
		int arr[] = new int[l]; //길이만큼 배열 생성.
		for(int x = 0; x<l; x++) {
			arr[x]=s.charAt(x); //arr에 한글자씩 저장해줌.
		}
		for(int x= 0; x<l-1; x++) { //처음글자부터 버블정렬식으로 해주는데
			for(int y=2+x; y<=l-1;y++) { //바로 다음글자는 이전과 같아도 상관없으므로 그 다음부터라 +2를 해줌.
				if(arr[x]==arr[y]) { //만약 0번째와 2번째가 같았다면 그룹단어가 아니기때문에
					if(arr[x]==arr[y-1]) {
						break;
					}
					error = 1;  //에러가 1로 변경이되며
					break; //for문을 끝냄.
				}
			}
			if(error==1) { //위와 마찬가지.
				break;
			}
		}
		if(error==0) //에러가 없을경우 그룹단어이므로 cnt를 ++해준다.
			cnt++;
		}
	}
	System.out.println(cnt);
	sc.close();
}
}