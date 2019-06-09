package su.efremov.graph;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

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
		graph.addVertex(1)
				.addVertex(2)
				.addVertex(3)
				.addVertex(5)
				.addVertex(8);

		Set<Integer> vertexes = graph.getVertexes();

		assertThat(vertexes, containsInAnyOrder(1, 2, 3, 5, 8));
	}

	@Test
	public void shouldNotContainsRepetitiveVertex() {
		graph.addVertex(1)
				.addVertex(2)
				.addVertex(1)
				.addVertex(2)
				.addVertex(1);

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

	@Test
	public void shouldReturnAdjacentVertices() {
		graph.addEdge(1, 11)
				.addEdge(1, 12)
				.addEdge(1, 13)
				.addEdge(1, 14);

		assertThat(graph.getAdjacentVertices(1), containsInAnyOrder(11, 12, 13, 14));
		assertThat(graph.getAdjacentVertices(11), is(notNullValue()));
		assertThat(graph.getAdjacentVertices(11), is(emptyIterable()));
		assertThat(graph.getAdjacentVertices(12), is(notNullValue()));
		assertThat(graph.getAdjacentVertices(12), is(emptyIterable()));
		assertThat(graph.getAdjacentVertices(13), is(notNullValue()));
		assertThat(graph.getAdjacentVertices(13), is(emptyIterable()));
		assertThat(graph.getAdjacentVertices(14), is(notNullValue()));
		assertThat(graph.getAdjacentVertices(14), is(emptyIterable()));
	}

}
