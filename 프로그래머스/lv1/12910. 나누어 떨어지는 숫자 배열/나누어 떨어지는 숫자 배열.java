import java.util.*;

class Solution {
    public List solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}
		if(list.size() == 0) {
			list.add(-1);			
		}else {
			Collections.sort(list);
		}
        return list;
    }
}