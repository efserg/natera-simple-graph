package su.efremov.path;

import su.efremov.graph.Graph;

public interface PathFinderStrategy<V> {
	Iterable<V> findPath(Graph<V> graph, V start, V end);
}
