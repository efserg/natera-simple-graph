package su.efremov.graph;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import com.google.common.collect.ImmutableList;

public class UndirectedGraphTest {

	private Graph<Integer> graph;

	@Before
	public void setup() {
		graph = new UndirectedGraph<>();
	}

	@Test
	public void shouldReturnProperlyIsDirectedValue() {
		assertThat(graph.isDirected(), is(false));
	}

	@Test
	public void shouldAddAndReturnVertex() {
		graph.addVertex(1);
		graph.addVertex(3);
		graph.addVertex(5);
		graph.addVertex(7);
		graph.addVertex(11);

		Set<Integer> vertexes = graph.getVertexes();

		assertThat(vertexes, containsInAnyOrder(1, 3, 5, 7, 11));
	}

	@Test
	public void shouldNotContainsRepetitiveVertex() {
		graph.addVertex(3);
		graph.addVertex(5);
		graph.addVertex(5);
		graph.addVertex(5);
		graph.addVertex(3);

		Set<Integer> vertexes = graph.getVertexes();

		assertThat(vertexes, containsInAnyOrder(3, 5));
	}

	@Test
	public void shouldAddAndReturnVertexInBatch() {
		graph.addAll(ImmutableList.of(13, 17, 19, 23, 29));

		Set<Integer> vertexes = graph.getVertexes();

		assertThat(vertexes, containsInAnyOrder(13, 17, 19, 23, 29));
	}

	@Test
	public void shouldCreateVertexesAndTwoDirectEdge() {
		graph.addEdge(1, 2);

		Set<Integer> vertexes = graph.getVertexes();
		assertThat(vertexes, containsInAnyOrder(1, 2));

		assertThat(graph.isConnected(1, 2), is(true));
		assertThat(graph.isConnected(2, 1), is(true));
	}

}