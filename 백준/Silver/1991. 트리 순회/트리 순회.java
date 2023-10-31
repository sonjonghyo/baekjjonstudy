import java.util.*;
import java.io.*;

class Node {
	char data;
	Node LeftNode;
	Node RightNode;
	Node(char data) {
		this.data = data;
	}
}
class Tree {
	public Node root;
	//먼저 트리노드를 형성해 줍니다.
	public void createNode(char data, char left, char right) {
		//루트가 존재하지 않는다면 루트 생성
		if(root == null) {
			root = new Node(data);
			//왼쪽, 오른쪽 노드 생성 (. 이라면 null을 넣어 빈공간 만들기)
			root.LeftNode = left != '.' ? new Node(left) : null;
			root.RightNode = right != '.' ? new Node(right) : null;
		}else {
			//루트가 있으면 부모노드 찾아서 자식 만들어주기.
			searchNode(root, data, left, right);
		}
	}
	public void searchNode(Node n, char data, char left, char right) {
		//노드가 null이면 자식을 만들어 줄수 없음.
		if(n == null) {
			return;
		//내가 찾는 노드의 값과 일치한다면 자식 노드 생성
		}else if(n.data == data) {
			n.LeftNode = left != '.' ? new Node(left) : null;
			n.RightNode = right != '.' ? new Node(right) : null;
		//그것이 아니라면 계속 찾기.
		}else {
			searchNode(n.LeftNode, data, left, right);
			searchNode(n.RightNode, data, left, right);
		}
	}
	
	//전위 순회(가운데 -> 왼 -> 오)
	public void preorder(Node n) {
		//먼저 노드가 비어있는지 파악 후
		if(n != null) {
			//루트를 먼저 출력하고
			System.out.print(n.data);
			//왼쪽이 있다면 왼쪽으로 내려가기.
			if(n.LeftNode != null) {
				preorder(n.LeftNode);
			}
			//오른쪽이 있다면 오른쪽으로 내려가기.
			if(n.RightNode != null) {
				preorder(n.RightNode);
			}
		}
	}
	//중위 순회(왼 -> 가운데 -> 오)
	public void inorder(Node n) {
		//먼저 노드가 비어있는지 파악 후
		if(n != null) {
			//왼쪽이 있다면 왼쪽으로 내려가기.
			if(n.LeftNode != null) {
				inorder(n.LeftNode);
			}
			//왼쪽 끝까지 내려왔다면 출력.
			System.out.print(n.data);
			//오른쪽이 있다면 오른쪽으로 내려가기.
			if(n.RightNode != null) {
				inorder(n.RightNode);
			}
		}
	}
	public void postorder(Node n) {
		//먼저 노드가 비어있는지 파악 후
		if(n != null) {
			//왼쪽이 있다면 왼쪽으로 내려가기.
			if(n.LeftNode != null) {
				postorder(n.LeftNode);
			}
			//오른쪽이 있다면 오른쪽으로 내려가기.
			if(n.RightNode != null) {
				postorder(n.RightNode);
			}
			//오른쪽 끝까지 내려왔다면 출력.
			System.out.print(n.data);
		}
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Tree t = new Tree();
		
		//트리를 저장해주어야 함.
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			t.createNode(root, left, right);
		}

		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
	}
}