package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class GraphWithAdjancencyList {
	
	private Map<Object, List<Object>> adjListMap = new HashMap<>();
	private int vertexCount;

	public GraphWithAdjancencyList(int vertextCount) {
		this.vertexCount = vertextCount;		
	}

	public void addEdge(int i, int j) {		

		if (i < 0 || j < 0) {
			return;
		}		
		
		if(adjListMap.containsKey(i)) {
			adjListMap.get(i).add(j);
		} else {
			List<Object> list = new LinkedList<>();
			list.add(j);
			adjListMap.put(i, list);
		}
		
		if(adjListMap.containsKey(j)) {
			adjListMap.get(j).add(i);
		} else {
			List<Object> list = new LinkedList<>();
			list.add(i);
			adjListMap.put(j, list);
		}		
	}

	public void removeEdge(int i, int j) {
		
		if (i < 0 || j < 0) {
			return;
		}
		if (i > vertexCount || j > vertexCount) {
			return;
		}
		if(adjListMap.containsKey(i)) {
			List<Object> list = adjListMap.get(i);
			for(Object object : list) {
				if((Integer)object == j) {
					list.remove(object);
				}
			}
		}
		
	}

	public boolean hasEdge(int i, int j) {
		// If there is an edge from vertex i to j, set adjMat[i][j] && adjMat[i][j] as
		// 0.

		if (i < 0 || j < 0) {
			return false;
		}
		if(adjListMap.isEmpty()) {
			return false;
		}
		if(adjListMap.containsKey(i)) {
			List<Object> list = adjListMap.get(i);
			for(Object object : list) {
				if((Integer)object == j) {
					return true;
				}
			}
		}
		return false;		
		
	}

	public Map<Object, List<Object>> getAdjListMap() {
		return adjListMap;
	}	

}
