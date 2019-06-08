package su.efremov.graph;

public class DirectedGraph<V> extends AbstractUnweightedGraph<V> {

	@Override
	public boolean isDirected() {
		return true;
	}

	@Override
	public Graph<V> addEdge(V from, V to) {
		super.addEdge(from, to);
		getAdjacentVertices().get(from).add(to);
		return this;
	}
}
