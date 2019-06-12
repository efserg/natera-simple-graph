package su.efremov.graph;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import su.efremov.path.PathFinderStrategy;

public class WeightedDirectedGraph<V, E> implements WeightedGraph<V, E> {

	private Comparator<? super E> comparator;

	public WeightedDirectedGraph() {
	}

	public WeightedDirectedGraph(Comparator<? super E> comparator) {
		this.comparator = comparator;
	}

	@Override
	public Graph<V> addEdge(V from, V to, E edge) {
		return null;
	}

	@Override
	public Graph<V> addVertex(V vertex) {
		return null;
	}

	@Override
	public Graph<V> addAll(Collection<? extends V> vertexes) {
		return null;
	}

	@Override
	public Graph<V> addEdge(V from, V to) {
		return null;
	}

	@Override
	public Iterable<V> findPath(PathFinderStrategy<V> strategy, V start, V end) {
		return null;
	}

	@Override
	public Set<V> getVertexes() {
		return null;
	}

	@Override
	public Set<V> getAdjacentVertices(V vertex) {
		return null;
	}

	@Override
	public boolean isDirected() {
		return false;
	}
}
