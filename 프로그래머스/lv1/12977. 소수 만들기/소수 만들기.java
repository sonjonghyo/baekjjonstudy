class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        for(int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if(check(sum)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    static boolean check(int sum) {
        for(int i = 2; i*i <= sum; i++) {
            if(sum % i == 0)
                return false;
        }
        return true;
    }
}