import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
	static int arr[];
	static int cx = 0;
	static int cy = 0;
	static int result = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<Integer> li = new ArrayList<>();
		int sum = 0;
		int cnt = 0;
		loop:
		while(true) { //10000까지의 수가 있으므로 총 개수가 10000개가 될때까지 while문을 돌림.
			for(int i = 1; ; i++) {
				sum += i;
				li.add(sum);
				cnt++;
				if(sum>=10000000) {
					break loop;
				}
			}
		}
		arr = new int[cnt]; //누적합에 대한 배열 생성.
		for(int i = 0; i<arr.length; i++) { 
			arr[i] = li.get(i); //각 인덱스의 번호+1한것이 y축 시작위치. 누적합은 (i+1,1)의 위치에 있는 값이다.
		}
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int px = 0;
			int py = 0;
			int qx = 0;
			int qy = 0;
			int p = sc.nextInt();
			int q = sc.nextInt();
			check(p);
			px = cx;
			py = cy;
			check(q);
			qx = cx;
			qy = cy;
			starsum(px,py,qx,qy);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void check(int a) {
		int x = 0;
		int y = 0;
		int cur = 0; //현재 위치를 담아내기 위함.
		for(int i = 0; i<arr.length; i++) {
			if(a <= arr[i]) {
				cur = i;
				break;
			}
		}
		if(cur==0) {
			x = 1;
			y = 1;
		}else {
			int value = arr[cur-1]+1;//시작 위치의 값
			x= 1;
			y= cur+1;
			for(int i = 0; i < cur ; i++) {
				if(value==a) {
					break;
				}
				x++; //x축 하나 증가
				y--; //y축 하나 감소
				value++; //값 하나 증가시켜줌.,
			}
		}
		cx = x;
		cy = y;			
	}
	public static void starsum(int px, int py, int qx, int qy) {
		int resultx = px+qx;
		int resulty = py+qy;
		int leftnum = resulty+(resultx-1); //y축 처음 위치.
		int rightnum = 0;
		for(int i = 1; i <= leftnum; i++) {
			rightnum += i;
		}
		result = rightnum - (leftnum-resultx);
		sb.append(result);
	}
}