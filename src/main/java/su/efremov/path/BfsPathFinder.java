package su.efremov.path;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import su.efremov.graph.Graph;

public class BfsPathFinder<V> implements PathFinderStrategy<V> {
	private Map<V, V> connectedVertexes;
	private Set<V> visitedVertexes;
	private Graph<V> graph;

	@Override
	public Iterable<V> findPath(final Graph<V> graph, final V start, final V end) {
		this.graph = graph;
		this.connectedVertexes = new HashMap<>();
		this.visitedVertexes = new HashSet<>();
		bfs(start);
		return path(start, end);
	}

	private void bfs(final V start) {
		final Queue<V> queue = new LinkedList<>();

		queue.add(start);

		while (!queue.isEmpty()) {
			final V next = queue.poll();
			visitedVertexes.add(next);
			graph.getAdjacentVertices(next).stream()
					.filter(v -> !visitedVertexes.contains(v))
					.forEachOrdered(v -> {
						connectedVertexes.put(v, next);
						visitedVertexes.add(v);
						queue.add(v);
					});
		}

	}

	@SuppressWarnings("Duplicates")
	private Iterable<V> path(final V start, final V end) {
		if (!visitedVertexes.contains(end))
			return ImmutableList.of(start);
		LinkedList<V> path = new LinkedList<>();
		V next = end;
		while (!start.equals(next)) {
			path.addFirst(next);
			next = connectedVertexes.get(next);
		}
		path.addFirst(start);
		return ImmutableList.copyOf(path);
	}

}
