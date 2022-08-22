import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
class Solution
{
	public static void main(String args[]) throws Exception
	{
      Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt(); //사람의 수를 입력.
			int M = sc.nextInt(); //몇초마다 붕어빵을 만들지 결정.
			int K = sc.nextInt(); //붕어빵을 몇개 만들지 결정.
			int fishbread = 0; //붕어빵 개수
			int arr[] = new int[N];
			boolean is = false; //나중에 줄수있는지 아닌지를 구별해주기위해 boolean을 만들어준다.
			for(int i = 0; i<N; i++) {
				arr[i] = sc.nextInt(); //몇초에 사람이 오는지 입력.
			}
			Arrays.sort(arr); //오름차순으로 정렬해 시간별로 세워둠.
			for(int i = 0; i<N; i++) {
				fishbread = (arr[i]/M) * K - i; //붕어빵개수를 구하는데 (내가 받으러가는 시간/몇초마다 붕어빵이 나오는지) * 나오는 붕어빵수 - 앞사람이 가져간갯수.
				if(fishbread <= 0) { //만약 붕어빵이 0이하라면 true로 만들어주어 for문을 끝내준다.(붕어빵을 가져갈수 없으므로.)
					is = true;
					break;
				}
			}
			if(is) { //만약 true라면 붕어빵을 못가져가는사람이 있음.
				System.out.println("#" + tc + " " + "Impossible"); //불가능함.
			}else {
				System.out.println("#" + tc + " " + "Possible"); //가능함
			}
        }
        sc.close();
	}
}