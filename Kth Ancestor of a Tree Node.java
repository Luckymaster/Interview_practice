class TreeAncestor {

 	Map<Integer, List<Integer>> ancestors;

	private static final int k = 16;

	private int[][] sptable;

	public TreeAncestor(int n, int[] parent) {
		//ancestors = new HashMap<>();
		//ancestors1 = new HashMap<>();

		sptable = new int[n + 1][k];
		for (int i = 0; i < n; i++) {
			sptable[i][0] = parent[i];
			for (int j = 1; j < k; j++) {
				sptable[i][j] = -1;
			}

		}
		for (int j = 1; j < k; j++) {
			for (int i = 0; i < parent.length; i++) {
				if(sptable[i][j-1]!=-1) {
					sptable[i][j] = sptable[sptable[i][j-1]][j-1];
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//
//			int aux = parent[i];
//			int cnt = 0;
//			while (aux != -1) {
//				if (ancestors.get(i) == null) {
//					List<Integer> tem = new ArrayList<>();
//					tem.add(aux);
//					ancestors.put(i, tem);
//				}
//				if (ancestors.get(aux) != null) {
//					List<Integer> tem1 = new ArrayList(ancestors.get(aux));
//					for (Integer p : ancestors.get(i)) {
//						tem1.add(p);
//					}
//					ancestors.put(i, tem1);
//					break;
//				} else {
//					ancestors.get(i).add(aux);
//					System.out.println("For i = " + i + " adding parent = " + aux);
//				}
//				aux = parent[aux];
//			}
//		}

	}

	public int getKthAncestor(int node, int kth) {

		for (int i = 0; i < k; i++) {

			if (((1 << i) & kth) > 0) {

				node = sptable[node][i];

			}
			if (node == -1)
				break;
		}
		return node;
	}

	// public int getKthAncestor1(int node, int k) {
	// 	if (ancestors.get(node) == null)
	// 		return -1;
	// 	List<Integer> an = ancestors.get(node);
	// 	if (an.size() > k)
	// 		return an.get(an.size() - k);
	// 	else
	// 		return -1;
	// }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
