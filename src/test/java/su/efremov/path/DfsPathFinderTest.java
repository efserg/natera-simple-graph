package su.efremov.path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static su.efremov.path.GraphBuilder.buildPetersenGraph;
import static su.efremov.path.GraphBuilder.buildWagnerGraph;

import org.junit.Test;
import su.efremov.graph.Graph;
import su.efremov.graph.UndirectedGraph;

public class DfsPathFinderTest {

	private final DfsPathFinder<Integer> DFS_STRATEGY = new DfsPathFinder<>();

	@Test
	public void shouldFoundPathInUndirectedGraph() {
		Graph<Integer> undirectedPetersenGraph = buildPetersenGraph(new UndirectedGraph<>());
		Iterable<Integer> path = undirectedPetersenGraph.findPath(DFS_STRATEGY, 1, 4);
		assertThat(path, is(notNullValue()));
		assertThat(path, not(emptyIterable()));
	}

	@Test
	public void shouldNotFoundPathInUndirectedDisconnectedGraph() {
		Graph<Integer> undirectedPetersenGraph = buildPetersenGraph(new UndirectedGraph<>());
		Graph<Integer> disconnectedGraph = buildWagnerGraph(undirectedPetersenGraph);

		Iterable<Integer> path = disconnectedGraph.findPath(DFS_STRATEGY, 1, 11);
		assertThat(path, is(notNullValue()));
		assertThat(path, is(emptyIterable()));
	}

	@Test
	public void shouldFoundPathInUndirectedConnectedGraph() {
		/*
		             Only one way from Peterson to Wagner graph

		  node 1                  node 10      node 11
		     * --- PetersenGraph --- * ========== * --- WagnerGraph --- *

		 */

		Graph<Integer> undirectedPetersenGraph = buildPetersenGraph(new UndirectedGraph<>());
		Graph<Integer> disconnectedGraph = buildWagnerGraph(undirectedPetersenGraph);
		Graph<Integer> connectedGraph = disconnectedGraph.addEdge(10, 11);
		Iterable<Integer> path = connectedGraph.findPath(DFS_STRATEGY, 1, 18);
		assertThat(path, is(notNullValue()));
		assertThat(path, hasItems(10, 11));
	}

}