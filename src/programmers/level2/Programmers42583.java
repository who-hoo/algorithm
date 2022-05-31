package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

public class Programmers42583 {

	public static void main(String[] args) {
		Programmers42583 sol = new Programmers42583();
		int[] bridge_length = new int[]{2, 100, 100};
		int[] weight = new int[]{10, 100, 100};
		int[][] truck_weights = new int[][]{
			{7, 4, 5, 6},
			{10},
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
		};
		for (int i = 0; i < 3; i++) {
			System.out.println(sol.solution(
				bridge_length[i],
				weight[i],
				truck_weights[i]
			));
		}
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		List<Integer> trucks = Arrays.stream(truck_weights).boxed().collect(Collectors.toList());
		Queue<Integer> waitingQueue = new LinkedList<>(trucks);
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) {
			bridge.offer(0);
		}
		int answer = 0;
		while (true) {
			answer++;
			bridge.poll();
			if (isAvailable(weight, bridge_length, waitingQueue, bridge)) {
				bridge.offer(Optional.ofNullable(waitingQueue.poll()).orElse(0));
			} else {
				bridge.offer(0);
			}
			System.out.println("answer = " + answer);
			System.out.println("bridge = " + bridge);
			System.out.println("waitingQueue = " + waitingQueue);
			if (waitingQueue.isEmpty() && bridge.isEmpty()) {
				break;
			}
		}
		return answer;
	}

	private boolean isAvailable(int weight, int bridge_length,
		Queue<Integer> waitingQueue, Queue<Integer> bridge) {
		int nextTruckWeight = Optional.ofNullable(waitingQueue.peek()).orElse(0);
		int currentBridgeWeight = bridge.stream().mapToInt(Integer::intValue).sum();
		return nextTruckWeight + currentBridgeWeight <= weight && bridge.size() <= bridge_length - 1;
	}
}
