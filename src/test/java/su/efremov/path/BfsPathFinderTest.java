package su.efremov.path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static su.efremov.path.GraphBuilder.buildWagnerGraph;

import org.junit.Test;
import com.google.common.collect.ImmutableList;
import su.efremov.graph.DirectedGraph;
import su.efremov.graph.Graph;

public class BfsPathFinderTest {

	private final BfsPathFinder<Integer> BFS_STRATEGY = new BfsPathFinder<>();

	@Test
	public void shouldFoundShortestPathInDirectedGraph() {
		Graph<Integer> directedWagnerGraph = buildWagnerGraph(new DirectedGraph<>());
		Iterable<Integer> path = directedWagnerGraph.findPath(BFS_STRATEGY, 11, 16);
		assertThat(path, is(notNullValue()));
		assertThat(path, hasItems(11, 16));
		assertThat(ImmutableList.copyOf(path), hasSize(3));
	}

}