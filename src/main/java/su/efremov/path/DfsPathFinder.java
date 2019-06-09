package su.efremov.path;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import su.efremov.graph.Graph;

public class DfsPathFinder<V> implements PathFinderStrategy<V> {
	private Map<V, V> connectedVertexes;
	private Set<V> visitedVertexes;
	private Graph<V> graph;

	@Override
	public Iterable<V> findPath(final Graph<V> graph, final V start, final V end) {
		this.graph = graph;
		this.connectedVertexes = new HashMap<>();
		this.visitedVertexes = new HashSet<>();
		dfs(start);
		return path(start, end);
	}

	private Iterable<V> path(final V start, final V end) {
		if (!visitedVertexes.contains(end))
			return ImmutableList.of();
		LinkedList<V> path = new LinkedList<>();
		V next = end;
		while (!start.equals(next)) {
			path.addFirst(next);
			next = connectedVertexes.get(next);
		}
		return ImmutableList.copyOf(path);
	}

	private void dfs(final V start) {
		visitedVertexes.add(start);
		graph.getAdjacentVertices(start).stream()
				.filter(o -> !visitedVertexes.contains(o))
				.forEach(vertex -> {
					connectedVertexes.put(vertex, start);
					dfs(vertex);
				});
	}

}
