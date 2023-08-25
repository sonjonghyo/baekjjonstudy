import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //앵무새의 수
		Queue<String> sentence = new LinkedList<>(); //마지막 문장을 담아줄 큐 입니다.
		Queue<String> q[] = new LinkedList[N]; //각 앵무새가 말한 문장을 담아줄 큐입니다.
		for(int i = 0; i < N; i++) {
			q[i] = new LinkedList<String>();
		}
		for(int i = 0; i < N; i++) {
			String s = br.readLine(); //문장 먼저 받아온 후
			String split[] = s.split(" "); //띄어쓰기를 기준으로 나눠 주자.
			for(int j = 0; j < split.length; j++) {
				q[i].add(split[j]);
			}
		}
		String cseteram = br.readLine(); //마지막 문장을 받아오자.
		String split[] = cseteram.split(" ");
		for(int i = 0; i < split.length; i++) {
			sentence.add(split[i]);
		}
		boolean flag = false; //앵무새들이 제대로 발음할 수 있었는지 확인하게 해주는 boolean 변수입니다.
		while(!sentence.isEmpty()) { //마지막 문장이 전부 비기 전까지는 계속 굴리자.
			String word = sentence.poll();
			flag = false;
			for(int i = 0; i < N; i++) {
				if(!q[i].isEmpty() && q[i].peek().equals(word)) { //만약 내가 뽑을 단어가 현재의 단어와 같다면?(비어있는 순간 에러를 띄우므로 처음 if문에 비어있는지 체크)
					q[i].poll(); //해당 앵무새가 말한 단어 빼주고
					flag = true; //말했으니 true로 변경해준다.
					break; //for문 끝내기
				}
			}
			if(!flag) { //만약 말 하지 못했다면?
				break; //while문을 끝내줘.
			}
		}
		for(int i = 0; i < N; i++) {
			if(!q[i].isEmpty()) {
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("Possible");
		}else {
			System.out.println("Impossible");
		}
	}
}