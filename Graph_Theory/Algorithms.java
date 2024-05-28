package ThanhThuy_Graph_Theory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Algorithms {
	ArrayList<Boolean> chuaXet = new ArrayList<Boolean>();
	int distances[];
	private int numberofvertices;
	public static final int MAX_VALUE = 9999;

	ArrayList<ArrayList<Integer>> mtk = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> danhSachKe = new ArrayList<ArrayList<Integer>>();

	Vertex vertex;

	Algorithms(Vertex v, ArrayList<ArrayList<Integer>> mtk) {
		this.mtk = mtk;
		this.vertex = v;
		numberofvertices = mtk.size();

		distances = new int[numberofvertices];

		for (int i = 0; i < mtk.size(); i++) {
			danhSachKe.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < danhSachKe.size(); i++) {
			for (int j = 0; j < mtk.size(); j++) {
				if (ke(mtk, i, j) == true)
					danhSachKe.get(i).add(j);
			}
		}
		for (int i = 0; i < mtk.size(); i++) {
			chuaXet.add(true);
		}
	}

	public ArrayList<Boolean> getChuaXet() {
		return chuaXet;
	}

	public int[] getDistances() {
		return distances;
	}

	public boolean ke(ArrayList<ArrayList<Integer>> mtk, int x, int y) {
		if (x < mtk.size() && y < mtk.size() && mtk.get(x).get(y) != null && mtk.get(y).get(x) != null) {
			if (mtk.get(x).get(y) == 1)
				return true;
			if (mtk.get(y).get(x) == 1)
				return true;
		}
		return false;
	}

	public String DFS(int n) {
		String a = "";
		Stack<Integer> stack = new Stack<>();
		stack.push(n);
		chuaXet.set(n, false);
		while (!stack.empty()) {
			int p = stack.pop();
			a += (p + 1 + " ");
			for (int u : danhSachKe.get(p)) {
				if (chuaXet.get(u)) {
					stack.push(u);
					chuaXet.set(u, false);
				}
			}
		}
		return a;
	}

	public String BFS(int n) {
		String r = "";
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		chuaXet.set(n, false);
		while (!queue.isEmpty()) {
			int p = queue.poll();
			r += (p + 1 + " ");
			for (int u : danhSachKe.get(p)) {
				if (chuaXet.get(u)) {
					queue.add(u);
					chuaXet.set(u, false);

				}
			}
		}
		return r;
	}

	public boolean BellmanFordEvaluation(int source, ArrayList<Edge> edges) {

		for (int node = 0; node < numberofvertices; node++) {
			distances[node] = MAX_VALUE;
		}
		distances[source] = 0;

		for (int i = 0; i < numberofvertices - 1; i++) {
			for (Edge e : edges) {
				int u = e.getDiemdau1().index;
				int v = e.getDiemdau2().index;
				int w = Integer.parseInt(e.getWeight());

				if (distances[u] != Integer.MAX_VALUE && distances[v] > distances[u] + w) {
					distances[v] = distances[u] + w;
				}

			}
		}
 
		for (Edge e : edges) {
			int u = e.getDiemdau1().index;
			int v = e.getDiemdau2().index;
			int w = Integer.parseInt(e.getWeight());
			if (distances[u] != Integer.MAX_VALUE && distances[v] > distances[u] + w) {
				return true;
			}
		}
		return false;
	}
}
