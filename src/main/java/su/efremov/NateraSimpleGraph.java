package su.efremov;

import su.efremov.graph.DirectedGraph;
import su.efremov.graph.Graph;

public class NateraSimpleGraph {
	public static void main(String[] args) {
		Graph<Integer> integerGraph = new DirectedGraph<Integer>()
				.addEdge(1, 2)
				.addEdge(2, 3)
				.addEdge(1, 3)
				.addEdge(1, 4)
				.addEdge(4, 2);

	}
}
