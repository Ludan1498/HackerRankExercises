package RecursionPractice;
import java.util.*;
import java.util.Map.Entry;

import RecursionPractice.Graph;
public class DijkstraShortestPath {
	public static HashMap<Character,Integer> distance= new HashMap<Character,Integer>();
	static HashMap<Character,Character> parent = new HashMap<Character,Character>();
	public static void main(String[] args) {
	Integer adjMat[][]= 
				{ { null, 4, null, null, null, null, null, 8, null },
				{ 4, null, 8, null, null, null, null, 11, null },
				{ null, 8, null, 7, null, 4, null, null, 2 },
				{ null, null, 7, null, 9, 14, null, null, null },
				{ null, null, null, 9, null, 10, null, null, null },
				{ null, null, 4, 14, 10, null, 2, null, null },
				{ null, null, null, null, null, 2, null, 1, 6 },
				{ 8, 11, null, null, null, null, 1, null, 7 },
				{ null, null, 2, null, null, null, 6, 7, null } };
	char[] vertLabels= {'A','B','C','D','E','F','G','H','I'};
	Graph graph = new Graph(adjMat,vertLabels);
	System.out.println(graph);
//	graph.addVertex('A');
//	graph.addVertex('B');
//	graph.addVertex('C');
//	graph.addVertex('D');
//	graph.addVertex('E');
//	graph.addVertex('F');
//	graph.addEdge('A', 'B', false, 1);
//	graph.addEdge('A', 'C', false, 2);
//	graph.addEdge('B', 'D', false, 1);
//	graph.addEdge('C', 'D', false, 7);
//	graph.addEdge('C', 'E', false, 2);
//	graph.addEdge('E', 'D', false, 1);
//	graph.addEdge('D', 'F', false, 1);
//	shortestPath(graph,'A');
	dijkstraAlgorithm(graph,'A');
	System.out.println("Distances : ");
	for(char node:distance.keySet()) {
		System.out.println(node+" : "+ distance.get(node));
	}
	System.out.println("parents");
	for(char node:parent.keySet()) {
		System.out.println(node+" : "+ parent.get(node));
	}

	}
	public static class DistanceComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.toWeight-o2.toWeight;
		}
	}
	static class Node{
		public Node(char src, int i) {
			vertexValue=src;
			toWeight=i;
		}
		char vertexValue;
		int toWeight;
	}
	public  static void dijkstraAlgorithm(Graph graph, char src) {
		for(char vertex:graph.map.keySet()) {
		parent.put(vertex, null);
		distance.put(vertex, Integer.MAX_VALUE);
		}
		distance.replace(src, 0);
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new DistanceComparator());
		pq.add(new Node(src,0));
		while(!pq.isEmpty()) {
		Node root = pq.poll();
//		System.out.println("Now processing root: "+ root.vertexValue);
		for(char neighbour:graph.map.get(root.vertexValue).keySet()) {
//			System.out.println("Now processing Neighbour of  "+ root.vertexValue+ " distance from "+ src+" to "+root.vertexValue+ " and "+root.vertexValue+ " to "+  neighbour+" are calculated");
			int altDistance = distance.get(root.vertexValue)+graph.map.get(root.vertexValue).get(neighbour);
			if(altDistance<distance.get(neighbour)) {
//				System.out.println("New path to "+neighbour+ " is discovered, going through "+ root.vertexValue);
				distance.replace(neighbour, altDistance);
				parent.replace(neighbour, root.vertexValue);
				pq.add(new Node(neighbour,altDistance));
//				System.out.println(neighbour+" is added to the queue to be traversed");
			}
		}
		}
	}
}
