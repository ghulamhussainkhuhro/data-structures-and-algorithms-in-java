package Graphs;

class Node {
	int vertex;
	Node next;

	public Node(int vertex) {
		this.vertex = vertex;
		this.next = null;
	}
}

class Graph {
	private Node[] adjacencyList;
	private int vertices;

	public Graph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new Node[vertices];
	}

	public void addEdge(int source, int destination) {
		Node node = new Node(destination);
		node.next = adjacencyList[source];
		adjacencyList[source] = node;

		// Since it's an undirected graph
		node = new Node(source);
		node.next = adjacencyList[destination];
		adjacencyList[destination] = node;
	}

	public void printGraph() {
		for (int i = 0; i < vertices; i++) {
			System.out.print("Vertex " + i + ":");
			Node temp = adjacencyList[i];
			while (temp != null) {
				System.out.print(" -> " + temp.vertex);
				temp = temp.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);

		graph.printGraph();
	}
}
