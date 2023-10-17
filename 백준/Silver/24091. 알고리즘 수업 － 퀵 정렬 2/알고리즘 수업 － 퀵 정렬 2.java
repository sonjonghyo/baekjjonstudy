import java.io.*;
import java.util.*;

public class Main {
	static int answer = 0;
	static int N, K;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(arr, 0, N-1);
		if(cnt < K) {
			System.out.println(-1);
		}else {
			for(int i = 0; i < N; i++) {		
				System.out.print(arr[i] + " ");
			}
		}
	}
	private static void quickSort(int[] arr, int left, int right) {
		if(cnt == K)
			return;
		if(left < right) {
			int part = partition(arr, left, right);
			if(part == -1)
				return;
			quickSort(arr, left, part -1);
			quickSort(arr, part + 1, right);			
		}
	}
	private static int partition(int[] arr, int left, int right) {
		//피봇값 설정
		int pivot = arr[right];
		int i = left - 1;
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr,i,j);
				cnt++;
				if(cnt == K) {
					return -1;
				}
			}
		}
		if(i + 1 != right) {
			swap(arr, i + 1, right);
			cnt++;
			if(cnt == K) {
				return -1;
			}
		}
		return i + 1;
	}
	private static void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}