import java.io.*;
import java.util.*;

public class Main {
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int cmparr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cmparr[i] = Integer.parseInt(st.nextToken());
		}
		compare(arr, cmparr);
		quickSort(arr,cmparr, 0, N-1);
		System.out.println(answer);
	}
	private static void quickSort(int[] arr, int[] cmparr, int left, int right) {
		if(answer == 1)
			return;
		if(left < right) {
			int part = partition(arr,cmparr , left, right);
			quickSort(arr, cmparr, left, part -1);
			quickSort(arr, cmparr, part + 1, right);			
		}
	}
	private static int partition(int[] arr,int cmparr[], int left, int right) {
		if(answer == 1)
			return -1;
		//피봇값 설정
		int pivot = arr[right];
		int l = left;
		int r = right;
		
		//겹치는 순간 끝내주기.
		while(l < r) {
			//피봇값 보다 왼쪽값이 더 작으면 비교안해도 되니 다음거로 이동.
			while(l < r && arr[l] < pivot) l++;
			//피봇값 보다 오른쪽 값이 더 크면 비교안해도 되니 다음거로 이동.
			while(l < r && arr[r] >= pivot) r--;
			
			//위의 두개를 이용해 두개를 바꿔준다.
			swap(arr, l, r);
			compare(arr, cmparr);
			if(answer == 1)
				return -1;
		}
		//가장 큰 수가있는 r과 가장 끝에 있는 right를 바꿔줌.
		swap(arr, r, right);
		compare(arr,cmparr);
		
		//r번째를 기준으로 분할하기.
		return r;
	}
	private static void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
	private static void compare(int[] arr, int[] cmparr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != cmparr[i]) { //두개를 비교했을때 같지 않으면 끝내주고
				return;
			}
		}
		//전부다 같을시 answer를 1로 만들어 준다.
		answer = 1; 	
	}	
}