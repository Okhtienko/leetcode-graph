package easy.task_1791;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		final int[][] edges = {{1, 2},{2, 3},{4, 2}};
		System.out.println(findCenter(edges));
	}

	public static int findCenter(final int[][] edges) {
		final Map<Integer, Integer> connections = countEdgeConnections(edges);
		return connections.entrySet()
					.stream()
					.filter(entry -> entry.getValue().equals(edges.length))
					.findFirst()
					.map(Map.Entry::getKey)
					.orElse(-1);
	}

	public static Map<Integer, Integer> countEdgeConnections(final int[][] edges) {
		Map<Integer, Integer> connections = new HashMap<>();
		for (int[] edge : edges) {
			for (int vertex : edge) {
				connections.put(vertex, connections.getOrDefault(vertex, 0) + 1);
			}
		}
		return connections;
	}
}
