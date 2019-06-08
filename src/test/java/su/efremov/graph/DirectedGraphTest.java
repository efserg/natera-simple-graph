package su.efremov.graph;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import com.google.common.collect.ImmutableList;

public class DirectedGraphTest {

	private Graph<Integer> graph;

	@Before
	public void setup() {
		graph = new DirectedGraph<>();
	}

	@Test
	public void shouldReturnProperlyIsDirectedValue() {
		assertThat(graph.isDirected(), is(true));
	}

	@Test
	public void shouldAddAndReturnVertex() {
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(5);
		graph.addVertex(8);

		Set<Integer> vertexes = graph.getVertexes();

		assertThat(vertexes, containsInAnyOrder(1, 2, 3, 5, 8));
	}

	@Test
	public void shouldNotContainsRepetitiveVertex() {
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(1);

		Set<Integer> vertexes = graph.getVertexes();

		assertThat(vertexes, containsInAnyOrder(1, 2));
	}

	@Test
	public void shouldAddAndReturnVertexInBatch() {
		graph.addAll(ImmutableList.of(3, 14, 15, 9, 26));

		Set<Integer> vertexes = graph.getVertexes();

		assertThat(vertexes, containsInAnyOrder(3, 14, 15, 9, 26));
	}

	@Test
	public void shouldCreateVertexesAndOneDirectEdge() {
		graph.addEdge(1, 2);

		Set<Integer> vertexes = graph.getVertexes();
		assertThat(vertexes, containsInAnyOrder(1, 2));

		assertThat(graph.isConnected(1, 2), is(true));
		assertThat(graph.isConnected(2, 1), is(false));
	}
}