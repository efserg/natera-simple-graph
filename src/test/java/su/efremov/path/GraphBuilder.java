package su.efremov.path;

import su.efremov.graph.Graph;

public class GraphBuilder {

	/*
	 * https://en.wikipedia.org/wiki/Wagner_graph
	 * */
	public static Graph<Integer> buildWagnerGraph(Graph<Integer> graph) {
		return graph.addEdge(11, 12)
				.addEdge(11, 15)
				.addEdge(12, 13)
				.addEdge(12, 16)
				.addEdge(13, 14)
				.addEdge(13, 17)
				.addEdge(14, 15)
				.addEdge(14, 18)
				.addEdge(15, 16)
				.addEdge(16, 17)
				.addEdge(17, 18)
				.addEdge(18, 11);
	}

	/*
	 * https://en.wikipedia.org/wiki/Petersen_graph
	 * */
	public static Graph<Integer> buildPetersenGraph(Graph<Integer> graph) {
		return graph.addEdge(1, 2)
				.addEdge(1, 6)
				.addEdge(2, 7)
				.addEdge(2, 3)
				.addEdge(3, 8)
				.addEdge(3, 4)
				.addEdge(4, 9)
				.addEdge(4, 5)
				.addEdge(5, 10)
				.addEdge(5, 1)
				.addEdge(6, 8)
				.addEdge(6, 9)
				.addEdge(7, 9)
				.addEdge(7, 10)
				.addEdge(8, 10);
	}

}