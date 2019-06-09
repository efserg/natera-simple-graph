package su.efremov.graph;

import java.util.Collection;
import java.util.Set;

import su.efremov.path.PathFinderStrategy;

public interface Graph<V> {

	Graph<V> addVertex(V vertex);

	Graph<V> addAll(Collection<? extends V> vertexes);

	Graph<V> addEdge(V from, V to);

	Iterable<V> findPath(PathFinderStrategy<V> strategy, V start, V end);

	Set<V> getVertexes();

	Set<V> getAdjacentVertices(V vertex);

	boolean isDirected();

}
