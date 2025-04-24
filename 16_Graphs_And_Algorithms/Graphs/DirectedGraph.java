package Graphs;

//Reuse the same Node and Graph classes from above, 
//but remove the undirected edge logic in addEdge method.

class DirectedGraph {
	private Node[] adjacencyList;
	private int vertices;

	public DirectedGraph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new Node[vertices];
	}

	public void addEdge(int source, int destination) {
		Node node = new Node(destination);
		node.next = adjacencyList[source];
		adjacencyList[source] = node;
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
		DirectedGraph graph = new DirectedGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);

		graph.printGraph();
	}
}
