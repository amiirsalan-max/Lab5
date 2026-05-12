package aod.lab5.test;

import aod.lab5.graph.Graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

	@Test
	void testAddVertex() {

		Graph<String> graph = new Graph<>();

		graph.addVertex(100, 100, "A");

		assertEquals(1, graph.numberOfVertices());
	}

	@Test
	void testDuplicateVertex() {

		Graph<String> graph = new Graph<>();

		graph.addVertex(100, 100, "A");
		graph.addVertex(200, 200, "A");

		assertEquals(1, graph.numberOfVertices());
	}

	@Test
	void testAddEdge() {

		Graph<String> graph = new Graph<>();

		graph.addVertex(0, 0, "A");
		graph.addVertex(1, 1, "B");

		graph.addEdge("A", "B");

		assertEquals(1, graph.numberOfEdges());
	}

	@Test
	void testAddEdgeWithoutVertices() {

		Graph<String> graph = new Graph<>();

		graph.addEdge("A", "B");

		assertEquals(0, graph.numberOfEdges());
	}

	@Test
	void testRemoveVertex() {

		Graph<String> graph = new Graph<>();

		graph.addVertex(0, 0, "A");
		graph.addVertex(1, 1, "B");

		graph.addEdge("A", "B");

		graph.remove("A");

		assertEquals(1, graph.numberOfVertices());
		assertEquals(0, graph.numberOfEdges());
	}

	@Test
	void testRemoveNonExistingVertex() {

		Graph<String> graph = new Graph<>();

		graph.remove("X");

		assertEquals(0, graph.numberOfVertices());
	}

	@Test
	void testEmptyGraphVertices() {

		Graph<String> graph = new Graph<>();

		assertEquals(0, graph.numberOfVertices());
	}

	@Test
	void testNumberOfVerticesAfterAdd() {

		Graph<String> graph = new Graph<>();

		graph.addVertex(0, 0, "A");
		graph.addVertex(1, 1, "B");

		assertEquals(2, graph.numberOfVertices());
	}

	@Test
	void testEmptyGraphEdges() {

		Graph<String> graph = new Graph<>();

		assertEquals(0, graph.numberOfEdges());
	}

	@Test
	void testNumberOfEdgesAfterAdd() {

		Graph<String> graph = new Graph<>();

		graph.addVertex(0, 0, "A");
		graph.addVertex(1, 1, "B");

		graph.addEdge("A", "B");

		assertEquals(1, graph.numberOfEdges());
	}

	@Test
	void testGetAllVertices() {

		Graph<String> graph = new Graph<>();

		graph.addVertex(0, 0, "A");
		graph.addVertex(1, 1, "B");

		assertEquals(2, graph.getAllVertices().size());
	}

	@Test
	void testGetAllVerticesEmpty() {

		Graph<String> graph = new Graph<>();

		assertTrue(graph.getAllVertices().isEmpty());
	}

	@Test
	void testGetEdges() {

		Graph<String> graph = new Graph<>();

		graph.addVertex(0, 0, "A");
		graph.addVertex(1, 1, "B");

		graph.addEdge("A", "B");

		assertEquals(1, graph.getEdges("A").size());
	}

	@Test
	void testGetEdgesEmpty() {

		Graph<String> graph = new Graph<>();

		graph.addVertex(0, 0, "A");

		assertEquals(0, graph.getEdges("A").size());
	}
}