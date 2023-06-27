import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String number[] = new String[numbers.length];
        for(int i = 0; i < number.length; i++) {
            number[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(number, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if(number[0].equals("0")) {
            return "0";
        }
        for(String s : number) {
            answer += s;
        }
        
        return answer;
    }
}