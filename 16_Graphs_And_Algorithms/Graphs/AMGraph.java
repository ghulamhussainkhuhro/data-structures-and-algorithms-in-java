package Graphs;

class AMGraph {
	private int[][] adjacencyMatrix;
	private int vertices;

	// Constructor to initialize the graph with a specified number of vertices
	public AMGraph(int vertices) {
		this.vertices = vertices;
		adjacencyMatrix = new int[vertices][vertices]; // Initialize matrix with 0s
	}

	// Method to add an undirected edge between two vertices
	public void addEdge(int source, int destination) {
		adjacencyMatrix[source][destination] = 1; // Set the edge from source to destination
		adjacencyMatrix[destination][source] = 1; // Set the edge from destination to source (since undirected)
	}

	// Method to print the adjacency matrix
	public void printGraph() {
		System.out.println("Adjacency Matrix:");
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				System.out.print(adjacencyMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AMGraph graph = new AMGraph(4); // Create a graph with 4 vertices
		graph.addEdge(0, 1); // Add edge between vertex 0 and 1
		graph.addEdge(0, 2); // Add edge between vertex 0 and 2
		graph.addEdge(1, 2); // Add edge between vertex 1 and 2
		graph.addEdge(2, 3); // Add edge between vertex 2 and 3

		graph.printGraph(); // Display the adjacency matrix of the graph
	}
}
