import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/*
 * THis is to check if given graph is tree/ tree topology.
 * Check cycle in the graph and all node should be reachable.
 */
public class Graph {
	private int V;

	private List<Integer>[] adj;

	Graph(int v) {
		this.V = v;

		this.adj = new LinkedList[V];

		for (int i = 0; i < V; i++) {

			adj[i] = new LinkedList<>();
		}
	}

	public void add(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	private boolean isCycleInGraph(int v, boolean[] isVisited, int parent) {

		isVisited[v] = true;
		// System.out.print(v + "-->");
		Integer i;
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {

			i = it.next();

			if (!isVisited[i]) {

				if (isCycleInGraph(i, isVisited, v)) {
					return true;
				}

			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}

	public boolean isTree() {

		boolean[] isVisited = new boolean[V ];

		for (int i = 0; i < V; i++) {
			isVisited[i] = false;
		}

		for (int i = 0; i < V; i++) {
			if (!isVisited[i] && isCycleInGraph(i, isVisited, -1)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N, M;
		String[] inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		Graph g = new Graph(N + 1);

		for (int i = 0; i < M; i++) {

			String[] nodes = br.readLine().split(" ");

			g.add(Integer.parseInt(nodes[0]), Integer.parseInt(nodes[1]));
		}

		if (g.isTree()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
