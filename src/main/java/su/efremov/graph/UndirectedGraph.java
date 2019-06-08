package su.efremov.graph;

public class UndirectedGraph<V> extends AbstractUnweightedGraph<V> {

	@Override
	public boolean isDirected() {
		return false;
	}

	@Override
	public Graph<V> addEdge(V from, V to) {
		super.addEdge(from, to);
		getAdjacentVertices().get(from).add(to);
		getAdjacentVertices().get(to).add(from);
		return this;
	}
}
