package su.efremov.graph;

import java.util.Collection;
import java.util.Set;

public interface Graph<V> {

	Graph<V> addVertex(V vertex);

	Graph<V> addAll(Collection<? extends V> vertexes);

	Graph<V> addEdge(V from, V to);

	Iterable<V> findPath(V from, V to);

	Set<V> getVertexes();

	Set<V> getAdjacentVertices(V vertex);

	boolean isConnected(V from, V to);

	boolean isDirected();

}
