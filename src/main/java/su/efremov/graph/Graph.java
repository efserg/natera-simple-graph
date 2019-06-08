package su.efremov.graph;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Graph<V> {

	Graph<V> addVertex(V vertex);

	Graph<V> addAll(Collection<? extends V> vertexes);

	Graph<V> addEdge(V from, V to);

	List<V> getPath(V from, V to);

	Set<V> getVertexes();

	boolean isConnected(V from, V to);

	boolean isDirected();

}
