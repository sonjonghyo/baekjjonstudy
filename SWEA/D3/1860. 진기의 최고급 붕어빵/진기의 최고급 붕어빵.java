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
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int sum = 0;
			int arr[] = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr); //오름차순으로 정렬해 시간별로 세워둠.
			int idx = 0; //arr에 있는 사람의 위치.
			loop:
			for(int i = 0; i<=arr[arr.length-1]; i++) { //중복 생각안했어.
				if(M == 0) { //0초마다만들면 계속만드는거?.. 뭔가 말이안되긴하지만 0초면 계속 더해줌.
					sum += K;
				}else if(i != 0 && i%M==0) { //1초부터는 i%M==0이 될때 즉 정해진 시간에 도달했을때 붕어빵 추가.
					sum += K;
				}
				while(arr[idx]==i) {//만약 arr[idx]가 i랑 같다면 while문 동작.				
					if(sum == 0) {
						System.out.println("#" + tc + " " + "Impossible"); //사람이왔는데 줄 붕어빵이없으므로 불가능
						break loop; //for문 바깥으로 빼버림.
					}
					sum--; //sum이 0이아니므로 붕어빵을 하나 준다.
					if(idx == arr.length-1) { //만약 idx가 마지막 즉 다줬다면
						break; //브레이크를 걸어줌. 즉 while문만 빼줌.
					}else { //아닐시엔
					idx++; //다음 사람으로 변경.
					}
				}
				if(i==arr[arr.length-1]) { //만약 시간이 다됐는데 중간에 끝나지 않았다면
					System.out.println("#" + tc + " " + "Possible"); //가능함.
				}
			}
		}
	}
}