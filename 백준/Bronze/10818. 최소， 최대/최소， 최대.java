import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //원소의 개수
		int arr[] = new int[N]; //원소를 담을 배열.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		qs(arr,0,arr.length-1); //퀵정렬로 배열 정렬하기.
		System.out.print(arr[0] + " " + arr[N-1]);
	}

	private static void qs(int[] arr, int start, int end) {
		int part = partition(arr,start,end);
		if(start < part-1)
			qs(arr,start,part-1);
		if(end > part)
			qs(arr,part,end);
		
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot=arr[(start+end)/2]; //피봇 설정.(위치 상관없음. 보기 편하게 가운데로.)
		while(start <= end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			if(start<=end) {
				swap(arr,start,end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
}