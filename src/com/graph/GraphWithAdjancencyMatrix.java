package com.graph;

public class GraphWithAdjancencyMatrix {

	private int adjMatrix[][];
	private int vertexCount;

	public GraphWithAdjancencyMatrix(int vertextCount) {
		this.vertexCount = vertextCount;
		adjMatrix = new int[vertextCount][vertextCount];
	}

	public void addEdge(int i, int j) {
		// If there is an edge from vertex i to j, mark adjMat[i][j] as 1.
		// If there is no edge from vertex i to j, mark adjMat[i][j] as 0.

		if (i < 0 || j < 0) {
			return;
		}
		if (i > vertexCount || j > vertexCount) {
			return;
		}
		adjMatrix[i][j] = 1;
		adjMatrix[j][i] = 1;
	}

	public void removeEdge(int i, int j) {
		// If there is an edge from vertex i to j, set adjMat[i][j] && adjMat[i][j] as
		// 0.

		if (i < 0 || j < 0) {
			return;
		}
		if (i > vertexCount || j > vertexCount) {
			return;
		}
		adjMatrix[i][j] = 0;
		adjMatrix[j][i] = 0;
	}

	public boolean hasEdge(int i, int j) {
		// If there is an edge from vertex i to j, set adjMat[i][j] && adjMat[i][j] as
		// 0.

		if (i < 0 || j < 0) {
			return false;
		}
		if (i > vertexCount || j > vertexCount) {
			return false;
		}
		if (adjMatrix[i][j] == 1) {
			return true;
		}
		return false;
	}

}
