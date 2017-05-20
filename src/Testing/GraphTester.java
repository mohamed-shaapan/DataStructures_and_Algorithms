package Testing;

import Graphs.Graph;
import Graphs.Node;

public class GraphTester {

	// RUN TEST
	// ********************************************
	public static void main(String blah[]) {

		// 01_construct graph
		Graph graph = new Graph();
		constrcutGraph2(graph);

		// 02_implement algorithms
		// graph.bfsTraversal(graph.getNode("a"));
		// graph.runDijkstra("a", "c");
		graph.runBellmanFord("a", "c");

	}

	// HELPING METHODS
	// ********************************************
	@SuppressWarnings("unused")
	private static void constrcutGraph1(Graph graph) {
		// this construction is to test traversal algorithms

		// 01_create nodes
		Node a = new Node("a", "a");
		Node b = new Node("b", "b");
		Node c = new Node("c", "c");
		Node d = new Node("d", "d");
		Node e = new Node("e", "e");
		Node f = new Node("f", "f");
		Node g = new Node("g", "g");

		// 02_connect nodes
		a.addAdjacent(c, 1);
		a.addAdjacent(d, 1);
		a.addAdjacent(g, 1);
		b.addAdjacent(e, 1);
		c.addAdjacent(c, 1);
		d.addAdjacent(d, 1);
		d.addAdjacent(e, 1);
		d.addAdjacent(f, 1);
		e.addAdjacent(g, 1);
		f.addAdjacent(b, 1);
		g.addAdjacent(b, 1);

		// 03_add nodes to graph
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(c);
		graph.addNode(d);
		graph.addNode(e);
		graph.addNode(f);
		graph.addNode(g);
	}

	private static void constrcutGraph2(Graph graph) {
		// this construction is to test Dijkstra algorithm

		// 01_create nodes
		Node a = new Node("a", "a");
		Node b = new Node("b", "b");
		Node c = new Node("c", "c");
		Node d = new Node("d", "d");
		Node e = new Node("e", "e");

		// 02_connect nodes
		a.addAdjacent(b, 6);
		a.addAdjacent(d, 1);
		b.addAdjacent(a, 6);
		b.addAdjacent(d, 2);
		b.addAdjacent(e, 2);
		b.addAdjacent(c, 5);
		c.addAdjacent(b, 5);
		c.addAdjacent(e, 5);
		d.addAdjacent(a, 1);
		d.addAdjacent(b, 2);
		d.addAdjacent(e, 1);
		e.addAdjacent(d, 1);
		e.addAdjacent(b, 2);
		e.addAdjacent(c, 5);

		// 03_add nodes to graph
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(c);
		graph.addNode(d);
		graph.addNode(e);
	}

}
