package 算法图解.Dijkstra;

import java.util.List;
import java.util.Queue;

public class Graph {

	/**
	 * 顶点
	 */
	private List<Vertex> vertexs;
	
	/**
	 * 边
	 */
	private int[][] edges;
	
	/**
	 * 没有访问的顶点
	 */
	private Queue<Vertex> unVisited;
	
	public Graph(List<Vertex> vertexs, int[][] edges) {
		this.vertexs = vertexs;
		this.edges = edges;
		initUnVisited();
	}
	
	/**
	 * 搜索各顶点最短路径
	 */
	public void search() {
		while(!unVisited.isEmpty()) {
			Vertex vertex = unVisited.element();
			// 顶点已经计算出最短路径，设置为“已访问”；
			vertex.setMarked(true);
			// 获取所有“未访问”的邻居
			List<Vertex> neighbors = getNeighbors(vertex);
			// 更新邻居的最短路径
			updatesDistance(vertex, neighbors);
			pop();
		}
		System.out.println("search over");
	}
	
	/**
	 * 更新所有邻居的最短路径
	 */
	private void updatesDistance(Vertex vertex, List<Vertex> neighbors) {
		for (Vertex neighbor: neighbors) {
			updateDistance(vertex, neighbor);
		}
	}
	
	/**
	 * 更新邻居的最短路径
	 */
	private void updateDistance(Vertex vertex, Vertex neighbor) {
		int distance = getDistance(vertex, neighbor) + vertex.getPath();
		if (distance < neighbor.getPath()) {
			neighbor.setPath(distance);
		}
	}
	
	/**
	 * 初始化未访问顶点集合
	 */
}
