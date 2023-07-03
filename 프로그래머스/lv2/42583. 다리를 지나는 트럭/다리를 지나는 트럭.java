import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        	int answer = 1;
        Queue<Integer> ing_truck = new LinkedList<>();
        Queue<Integer> finish_truck = new LinkedList<>();
        List<Integer> time = new ArrayList<>();
        int ing_weight = 0;
        int cnt = truck_weights.length-1;
        
        while(true) {
            if(finish_truck.size() == truck_weights.length) {
                break;
            }
            if(cnt >= 0 && ing_weight + truck_weights[cnt] <= weight) {
                ing_truck.add(truck_weights[cnt]);
                ing_weight += truck_weights[cnt];
                time.add(0);
                cnt--;
            }
            for(int i = 0; i < time.size(); i++) {
                time.set(i, time.get(i) + 1);
            }
            if(time.size() != 0 && time.get(0) == bridge_length) {
            	time.remove(0);
            	finish_truck.add(ing_truck.peek());
            	ing_weight -= ing_truck.poll();
            }
            answer++;
        }
        return answer;
    }
}