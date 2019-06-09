package su.efremov.graph;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import com.google.common.collect.ImmutableSet;
import su.efremov.path.PathFinderStrategy;

public abstract class AbstractUnweightedGraph<V> implements Graph<V> {

	private Map<V, Set<V>> adjacentVertices;

	public AbstractUnweightedGraph() {
		this.adjacentVertices = new ConcurrentHashMap<>();
	}

	@Override
	public Graph<V> addVertex(V vertex) {
		adjacentVertices.putIfAbsent(vertex, new ConcurrentSkipListSet<>());
		return this;
	}

	@Override
	public Graph<V> addAll(Collection<? extends V> vertexes) {
		vertexes.forEach(this::addVertex);
		return this;
	}

	@Override
	public Graph<V> addEdge(V from, V to) {
		addVertex(from);
		addVertex(to);
		return this;
	}

	@Override
	public Iterable<V> findPath(PathFinderStrategy<V> strategy, V start, V end) {
		return strategy.findPath(this, start, end);
	}

	@Override
	public Set<V> getVertexes() {
		return adjacentVertices.keySet();
	}

	@Override
	public Set<V> getAdjacentVertices(V vertex) {
		return ImmutableSet.copyOf(adjacentVertices(vertex));
	}

	protected Set<V> adjacentVertices(V vertex) {
		return adjacentVertices.getOrDefault(vertex, ImmutableSet.of());
	}
}
