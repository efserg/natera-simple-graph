package su.efremov;

import su.efremov.graph.Graph;
import su.efremov.graph.UndirectedGraph;
import su.efremov.path.DfsPathFinder;

public class NateraSimpleGraph {
	public static void main(String[] args) {
		Graph<Integer> integerGraph = new UndirectedGraph<Integer>()
				.addEdge(0, 1)
				.addEdge(0, 2)
				.addEdge(0, 5)
				.addEdge(1, 2)
				.addEdge(2, 3)
				.addEdge(2, 4)
				.addEdge(3, 4)
				.addEdge(3, 5);
		Iterable<Integer> path = integerGraph.findPath(new DfsPathFinder<>(), 0, 5);
		System.out.println();
	}
}
