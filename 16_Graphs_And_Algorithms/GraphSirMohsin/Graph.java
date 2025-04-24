package GraphSirMohsin;

class Graph {
	int size;
	String[] vertices;
	boolean[][] a; // adjacency matrix

	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
	}

	public void add(String v, String w) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		for (int i = 1; i < size; i++)
			buf.append("," + vertex(i));
		return buf + "}";
	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++)
			if (a[i][j])
				buf.append(vertices[j]);
		return buf + "";
	}

	public void printAdjacency() {
		System.out.println("Adjacency Matrix:");
		System.out.print("  ");
		for (String vertex : vertices) {
			System.out.print(vertex + " ");
		}
		System.out.println();

		for (int i = 0; i < size; i++) {
			System.out.print(vertices[i] + " ");
			for (int j = 0; j < size; j++) {
				System.out.print((a[i][j] ? 1 : 0) + " ");
			}
			System.out.println();
		}
	}

	// Main method for testing
	public static void main(String[] args) {
		// Example vertices
		String[] vertices = { "A", "B", "C", "D" };

		// Creating a graph
		Graph graph = new Graph(vertices);

		// Adding edges
		graph.add("A", "B");
		graph.add("A", "C");
		graph.add("B", "D");
		graph.add("C", "D");

		// Printing the graph
		System.out.println("Graph Representation: " + graph);

		// Printing the adjacency matrix
		graph.printAdjacency();
	}
}