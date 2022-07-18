package boj.level4;

import com.sun.source.tree.BinaryTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BOJ5639 {

	static class Node {

		int n;
		Node left;
		Node right;

		Node(int n, Node left, Node right) {
			this.n = n;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		List<Integer> nodes = new ArrayList<>();
		String line;
		while ((line = in.readLine()) != null) {
			nodes.add(Integer.parseInt(line));
		}

		System.out.println(nodes);
	}
}
