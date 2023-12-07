class Solution {
    public int[] solution(long[] numbers) {
        int answer[] = new int[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			//먼저 수를 2진수로 변환해준다.
			String S = Long.toBinaryString(numbers[i]);
			//2진수의 길이는 늘 2의n승 -1 개여야하므로 먼저 길이를 계산해서 앞에 추가시켜준다.
			int cnt = 0;
			while((int)Math.pow(2, cnt)-1 < S.length()) {
				cnt++;
			}
			//2의 n승-1개로 만들어주기 위한 while문 입니다.
			while((int)Math.pow(2, cnt)- 1 != S.length()) {
				S = "0" + S;
			}
			//만약 이진트리가 된다면 1로 저장해주자.
			if(search(S)) {
				answer[i] = 1;
			}
		}
        return answer;
    }
    private static boolean search(String s) {
		//되는지 체크해줄 변수입니다.
		boolean check = true;
		//가운데 지점을 먼저 구하자.
		int mid = (s.length()-1)/2;
		//왼쪽 오른쪽 나눠서 이진문자열 가지고 있기.(중간을 기점으로 왼쪽, 오른쪽)
		String left = s.substring(0,mid);
		String right = s.substring(mid+1);
		//중간지점이 0인데 그 아래가 1이면 걔는 될수가 없다.
		if(s.charAt(mid) == '0' && (left.charAt((left.length()-1) / 2) == '1' || right.charAt((right.length()-1) / 2) == '1')) {
			return false;
		}
		//남은 수가 1개가 될때까지 계속 돌려야 함.
		if(left.length() > 1) {
			//먼저 왼쪽 체크하기.
			check = search(left);
			//그 다음 오른쪽 체크하자.(왼쪽이 전부 되어야 오른쪽 체크가능)
			if(check) {
				check = search(right);
			}
		}
		return check;
	}
}