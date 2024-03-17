package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSTraversal {

	public static void main(String[] args) {
		GraphWithAdjancencyList graphAdjancencyList = new GraphWithAdjancencyList(5);
		graphAdjancencyList.addEdge(1, 2);
		graphAdjancencyList.addEdge(2, 3);
		graphAdjancencyList.addEdge(2, 4);
		graphAdjancencyList.addEdge(2, 7);
		graphAdjancencyList.addEdge(3, 4);
		graphAdjancencyList.addEdge(3, 6);

		System.out.println("graphAdjancencyList:: " + graphAdjancencyList.getAdjListMap());

		traverseGraph(graphAdjancencyList, 1);
	}

	private static void traverseGraph(GraphWithAdjancencyList graphAdjancencyList, int baseVertex) {
		Map<Object, Object> isTraversedMap = new HashMap<>();

		Queue<Object> queue = new LinkedList<Object>();
		queue.add(baseVertex);

		while (!queue.isEmpty()) {
			Object vertex = queue.poll();

			/*
			 * if (!isTraversedMap.containsKey(vertex)) { isTraversedMap.put(vertex, true);
			 * System.out.println(vertex); }
			 */

			if (!isTraversedMap.containsKey(vertex) && graphAdjancencyList.getAdjListMap().containsKey(vertex)) {
				System.out.println(vertex);
				isTraversedMap.put(vertex, true);

				for (Object adjacentVertex : graphAdjancencyList.getAdjListMap().get(vertex)) {
					queue.add(adjacentVertex);
				}
			}
		}

	}

}
