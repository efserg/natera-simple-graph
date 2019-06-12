package su.efremov.graph;

public interface WeightedGraph<V, E> extends Graph<V> {

	Graph<V> addEdge(V from, V to, E edge);

}
