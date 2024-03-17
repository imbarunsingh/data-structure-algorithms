package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DFSTraversal {

	public static void main(String[] args) {
		GraphWithAdjancencyList graphAdjancencyList = new GraphWithAdjancencyList(5);
		graphAdjancencyList.addEdge(0, 1);
		graphAdjancencyList.addEdge(0, 4);
		graphAdjancencyList.addEdge(0, 2);
		graphAdjancencyList.addEdge(4, 3);
		

		System.out.println("graphAdjancencyList:: " + graphAdjancencyList.getAdjListMap());
		
		Map<Object, Object> isTraversedMap = new HashMap<>();

		dfsTraversal(graphAdjancencyList.getAdjListMap(), 0, isTraversedMap);
	}

	private static void dfsTraversal(Map<Object, List<Object>> graphAdjancencyMap, Object rootVertex, Map<Object, Object> isTraversedMap) {
				
		isTraversedMap.put(rootVertex, true);
		
		System.out.println(rootVertex);
		
		for(Object adjacentVertex : graphAdjancencyMap.get(rootVertex)) {
			if(!isTraversedMap.containsKey(adjacentVertex)) {
				dfsTraversal(graphAdjancencyMap, adjacentVertex, isTraversedMap);
			}
		}

	}

}
