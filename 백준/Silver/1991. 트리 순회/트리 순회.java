

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char data;
	Node left;
	Node right;

	public Node(char data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public static void addNode(Node node, char root, char left, char right) {
		if (node.data == root) {
			node.left = (left == '.' ? null : new Node(left, null, null));
			node.right = (right == '.' ? null : new Node(right, null, null));
		} else {
			if (node.left != null) {
				addNode(node.left, root, left, right);
			}

			if (node.right != null) {
				addNode(node.right, root, left, right);
			}
		}
	}

	public static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}

	public static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);
	}
}

public class Main {

	static Node head = new Node('A', null, null);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			char root = stk.nextToken().charAt(0);
			char left = stk.nextToken().charAt(0);
			char right = stk.nextToken().charAt(0);

			Node.addNode(head, root, left, right);
		}
		Node.preOrder(head);
		System.out.println();
		Node.inOrder(head);
		System.out.println();
		Node.postOrder(head);

	}
}
