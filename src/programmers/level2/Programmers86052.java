package programmers.level2;

/*
    문제    : 프로그래머스 빛의 경로 사이클
    유형    :
	난이도   : Hell (Level 2)
	시간    : 5h
	uri    : https://programmers.co.kr/learn/courses/30/lessons/86052
    날짜    : 22.05.18(o)
    refer  :
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers86052 {

	static int[] dx = {0, 1, 0, -1}; // 하 우 상 좌
	static int[] dy = {1, 0, -1, 0};
	static int rowCount;
	static int colCount;

	public int[] solution(String[] grid) {
		rowCount = grid.length;
		colCount = grid[0].length();
		boolean[][][] visited = new boolean[rowCount][colCount][4];

		List<Integer> answer = new ArrayList<>();
		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				for (int dir = 0; dir < 4; dir++) {
					if (!visited[row][col][dir]) {
						answer.add(beam(grid, visited, row, col, dir));
					}
				}
			}
		}

		return answer.stream()
			.mapToInt(Integer::intValue)
			.sorted()
			.toArray();
	}

	public int beam(String[] grid, boolean[][][] visited, int startRow, int startCol,
		int direction) {
		int currentRow = startRow;
		int currentCol = startCol;
		int currentDir = direction;
		int length = 0;
		while (true) {
			if (visited[currentRow][currentCol][currentDir]) {
				break;
			}

			int nextRow = currentRow + dy[currentDir];
			int nextCol = currentCol + dx[currentDir];
			if (nextRow >= rowCount) {
				nextRow = 0;
			}
			if (nextRow < 0) {
				nextRow = rowCount - 1;
			}
			if (nextCol >= colCount) {
				nextCol = 0;
			}
			if (nextCol < 0) {
				nextCol = colCount - 1;
			}

			visited[currentRow][currentCol][currentDir] = true;
			length++;
			char c = grid[nextRow].charAt(nextCol);
			switch (c) {
				case 'L':
					currentDir = (currentDir + 1) % 4;
					break;
				case 'R':
					currentDir = (currentDir + 3) % 4;
					break;
				default:
					break;
			}
			currentRow = nextRow;
			currentCol = nextCol;
		}

		return length;
	}

	public static void main(String[] args) {
		Programmers86052 sol = new Programmers86052();
		String[][] inputs = {
			{"SL", "LR"},
			{"S"},
			{"R", "R"}
		};
		for (String[] input : inputs) {
			System.out.println(Arrays.toString(sol.solution(input)));
		}
	}
}
