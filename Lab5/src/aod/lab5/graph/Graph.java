package aod.lab5.graph;

import java.util.*;

public class Graph<T> implements GraphInterface<T> {

	private int nVertices;
	private int nEdges;

	private HashMap<T, Vertex<T>> vertices;
	private HashMap<T, ArrayList<Edge<T>>> edges;

	public Graph() {

		vertices = new HashMap<>();
		edges = new HashMap<>();

		nVertices = 0;
		nEdges = 0;
	}

	@Override
	public List<Vertex<T>> getAllVertices() {
		return new ArrayList<>(vertices.values());
	}

	@Override
	public List<Edge<T>> getEdges(T info) {
		return edges.get(info);
	}

	@Override
	public void addVertex(double x, double y, T info) {

		if (vertices.containsKey(info)) {
			return;
		}

		Vertex<T> vertex = new Vertex<>(x, y, info);

		vertices.put(info, vertex);
		edges.put(info, new ArrayList<>());

		nVertices++;
	}

	@Override
	public void addEdge(T infoA, T infoB) {

		Vertex<T> from = vertices.get(infoA);
		Vertex<T> to = vertices.get(infoB);

		if (from == null || to == null) {
			return;
		}

		Edge<T> edgeAB = new Edge<>(from, to);
		Edge<T> edgeBA = new Edge<>(to, from);

		edges.get(infoA).add(edgeAB);
		edges.get(infoB).add(edgeBA);

		nEdges++;
	}

	@Override
	public void remove(T info) {

		if (!vertices.containsKey(info)) {
			return;
		}

		List<Edge<T>> connectedEdges = new ArrayList<>(edges.get(info));

		for (Edge<T> edge : connectedEdges) {

			T neighbor = edge.getTo().getInfo();

			edges.get(neighbor).removeIf(e -> e.getTo().getInfo().equals(info));

			nEdges--;
		}

		edges.remove(info);
		vertices.remove(info);

		nVertices--;
	}

	@Override
	public int numberOfEdges() {
		return nEdges;
	}

	@Override
	public int numberOfVertices() {
		return nVertices;
	}

}
