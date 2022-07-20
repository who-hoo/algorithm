package boj.level4;

/*
    문제    : BOJ 이진 검색 트리
    유형    : 그래프 이론, 그래프 탐색, 트리, 재귀
	난이도   : Hard (Silver5)
	시간    : 3h
	uri    : https://www.acmicpc.net/problem/5639
    refer  :
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ5639 {

	static class Node {

		int n;
		Node left;
		Node right;

		Node(int n) {
			this.n = n;
		}

		void insert(Node node) {
			if (this.n > node.n) {
				if (this.left == null) {
					this.left = node;
				} else {
					this.left.insert(node);
				}
			} else {
				if (this.right == null) {
					this.right = node;
				} else {
					this.right.insert(node);
				}
			}
		}
	}

	static class BinaryTree {

		Node root;

		BinaryTree(Node root) {
			this.root = root;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		Node root = new Node(Integer.parseInt(in.readLine()));
		BinaryTree tree = new BinaryTree(root);
		String line;
		while ((line = in.readLine()) != null) {
			Node node = new Node(Integer.parseInt(line));
			tree.root.insert(node);
		}
		postOrder(out, root);

		out.close();
		in.close();
	}

	private static void postOrder(BufferedWriter out, Node node) throws IOException {
		if (node.left != null) {
			postOrder(out, node.left);
		}
		if (node.right != null) {
			postOrder(out, node.right);
		}
		out.write(node.n + System.lineSeparator());
	}
}
