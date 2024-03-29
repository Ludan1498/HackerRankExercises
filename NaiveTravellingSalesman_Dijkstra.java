package RecursionPractice;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import RecursionPractice.DijkstraShortestPath;
import RecursionPractice.DijkstraShortestPath.DistanceComparator;
import RecursionPractice.Graphv2.Node;
public class NaiveTravellingSalesman_Dijkstra {
	static HashMap<Character,Integer> distance= new HashMap<Character,Integer>();
	static HashMap<Character,Character> parent = new HashMap<Character,Character>();
	static HashMap<Character,Boolean> visited = new HashMap<Character,Boolean>();
	static ArrayList<Character> path= new ArrayList<Character>();
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
		char[] vertLabels2={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','V','W','X','Y','Z','a','b','c','d'};
		Integer adjMat2[][]={{null,  74,4110, 3048, 2267, 974,  4190, 3302, 4758, 3044, 3095, 3986, 5093, 6407, 5904, 8436, 6963, 6694, 6576, 8009, 7399, 7267, 7425, 9639, 9230, 8320, 9300, 8103, 7799},
			{74,  null,  4070, 3000, 2214, 901,  4138, 3240, 4702, 2971, 3021, 3915, 5025, 6338, 5830, 8369, 6891, 6620, 6502, 7939, 7326, 7193, 7351, 9571, 9160, 8249, 9231, 8030, 7725},
			{4110, 4070, null,  1173, 1973, 3496, 892,  1816, 1417, 3674, 3778, 2997, 2877, 3905, 5057, 5442, 4991, 5151, 5316, 5596, 5728, 5811, 5857, 6675, 6466, 6061, 6523, 6165, 6164},
			{3048, 3000, 1173, null,  817,  2350, 1172, 996,  1797, 2649, 2756, 2317, 2721, 3974, 4548, 5802, 4884, 4887, 4960, 5696, 5537, 5546, 5634, 7045, 6741, 6111, 6805, 6091, 5977},
			{2267, 2214, 1973, 817,  null,  1533, 1924, 1189, 2498, 2209, 2312, 2325, 3089, 4401, 4558, 6342, 5175, 5072, 5075, 6094, 5755, 5712, 5828, 7573, 7222, 6471, 7289, 6374, 6187},
			{974,  901,  3496, 2350, 1533, null,  3417, 2411, 3936, 2114, 2175, 3014, 4142, 5450, 4956, 7491, 5990, 5725, 5615, 7040, 6430, 6304, 6459, 8685, 8268, 7348, 8338, 7131, 6832},
			{4190, 4138, 892,  1172, 1924, 3417, null,  1233, 652,  3086, 3185, 2203, 1987, 3064, 4180, 4734, 4117, 4261, 4425, 4776, 4844, 4922, 4971, 5977, 5719, 5228, 5780, 5302, 5281},
			{3302, 3240, 1816, 996,  1189, 2411, 1233, null,  1587, 1877, 1979, 1321, 1900, 3214, 3556, 5175, 4006, 3947, 3992, 4906, 4615, 4599, 4700, 6400, 6037, 5288, 6105, 5209, 5052},
			{4758, 4702, 1417, 1797, 2498, 3936, 652,  1587, null,  3286, 3374, 2178, 1576, 2491, 3884, 4088, 3601, 3818, 4029, 4180, 4356, 4469, 4497, 5331, 5084, 4645, 5143, 4761, 4787},
			{3044, 2971, 3674, 2649, 2209, 2114, 3086, 1877, 3286, null,  107,  1360, 2675, 3822, 2865, 5890, 4090, 3723, 3560, 5217, 4422, 4257, 4428, 7000, 6514, 5455, 6587, 5157, 4802},
			{3095, 3021, 3778, 2756, 2312, 2175, 3185, 1979, 3374, 107,  null,  1413, 2725, 3852, 2826, 5916, 4088, 3705, 3531, 5222, 4402, 4229, 4403, 7017, 6525, 5451, 6598, 5142, 4776},
			{3986, 3915, 2997, 2317, 2325, 3014, 2203, 1321, 2178, 1360, 1413, null,  1315, 2511, 2251, 4584, 2981, 2778, 2753, 4031, 3475, 3402, 3531, 5734, 5283, 4335, 5355, 4143, 3897},
			{5093, 5025, 2877, 2721, 3089, 4142, 1987, 1900, 1576, 2675, 2725, 1315, null,  1323, 2331, 3350, 2172, 2275, 2458, 3007, 2867, 2935, 2988, 4547, 4153, 3400, 4222, 3376, 3307},
			{6407, 6338, 3905, 3974, 4401, 5450, 3064, 3214, 2491, 3822, 3852, 2511, 1323, null,  2350, 2074, 1203, 1671, 2041, 1725, 1999, 2213, 2173, 3238, 2831, 2164, 2901, 2285, 2397},
			{5904, 5830, 5057, 4548, 4558, 4956, 4180, 3556, 3884, 2865, 2826, 2251, 2331, 2350, null,  3951, 1740, 1108, 772,  2880, 1702, 1450, 1650, 4779, 4197, 2931, 4270, 2470, 2010},
			{8436, 8369, 5442, 5802, 6342, 7491, 4734, 5175, 4088, 5890, 5916, 4584, 3350, 2074, 3951, null,  2222, 2898, 3325, 1276, 2652, 3019, 2838, 1244, 1089, 1643, 1130, 2252, 2774},
			{6963, 6891, 4991, 4884, 5175, 5990, 4117, 4006, 3601, 4090, 4088, 2981, 2172, 1203, 1740, 2222, null,  684,  1116, 1173, 796,  1041, 974,  3064, 2505, 1368, 2578, 1208, 1201},
			{6694, 6620, 5151, 4887, 5072, 5725, 4261, 3947, 3818, 3723, 3705, 2778, 2275, 1671, 1108, 2898, 684,  null,  432,  1776, 706,  664,  756,  3674, 3090, 1834, 3162, 1439, 1120},
			{6576, 6502, 5316, 4960, 5075, 5615, 4425, 3992, 4029, 3560, 3531, 2753, 2458, 2041, 772,  3325, 1116, 432,  null,  2174, 930,  699,  885,  4064, 3469, 2177, 3540, 1699, 1253},
			{8009, 7939, 5596, 5696, 6094, 7040, 4776, 4906, 4180, 5217, 5222, 4031, 3007, 1725, 2880, 1276, 1173, 1776, 2174, null,  1400, 1770, 1577, 1900, 1332, 510,  1406, 1002, 1499},
			{7399, 7326, 5728, 5537, 5755, 6430, 4844, 4615, 4356, 4422, 4402, 3475, 2867, 1999, 1702, 2652, 796,  706,  930,  1400, null,  371,  199,  3222, 2611, 1285, 2679, 769,  440},
			{7267, 7193, 5811, 5546, 5712, 6304, 4922, 4599, 4469, 4257, 4229, 3402, 2935, 2213, 1450, 3019, 1041, 664,  699,  1770, 371,  null,  220,  3583, 2970, 1638, 3037, 1071, 560},
			{7425, 7351, 5857, 5634, 5828, 6459, 4971, 4700, 4497, 4428, 4403, 3531, 2988, 2173, 1650, 2838, 974,  756,  885,  1577, 199,  220,  null,  3371, 2756, 1423, 2823, 852,  375},
			{9639, 9571, 6675, 7045, 7573, 8685, 5977, 6400, 5331, 7000, 7017, 5734, 4547, 3238, 4779, 1244, 3064, 3674, 4064, 1900, 3222, 3583, 3371, null,  620,  1952, 560,  2580, 3173},
			{9230, 9160, 6466, 6741, 7222, 8268, 5719, 6037, 5084, 6514, 6525, 5283, 4153, 2831, 4197, 1089, 2505, 3090, 3469, 1332, 2611, 2970, 2756, 620,  null,  1334, 74,  1961, 2554},
			{8320, 8249, 6061, 6111, 6471, 7348, 5228, 5288, 4645, 5455, 5451, 4335, 3400, 2164, 2931, 1643, 1368, 1834, 2177, 510,  1285, 1638, 1423, 1952, 1334, null,  1401, 648,  1231},
			{9300, 9231, 6523, 6805, 7289, 8338, 5780, 6105, 5143, 6587, 6598, 5355, 4222, 2901, 4270, 1130, 2578, 3162, 3540, 1406, 2679, 3037, 2823, 560,  74,  1401, null,  2023, 2617},
			{8103, 8030, 6165, 6091, 6374, 7131, 5302, 5209, 4761, 5157, 5142, 4143, 3376, 2285, 2470, 2252, 1208, 1439, 1699, 1002, 769,  1071, 852,  2580, 1961, 648,  2023, null,  594},
			{7799, 7725, 6164, 5977, 6187, 6832, 5281, 5052, 4787, 4802, 4776, 3897, 3307, 2397, 2010, 2774, 1201, 1120, 1253, 1499, 440,  560,  375,  3173, 2554, 1231, 2617, 594,  null}};

		resetVisited(visited,vertLabels,vertLabels[0]);
		Graph graph = new Graph(adjMat,vertLabels);
		Graph graph2 = new Graph(adjMat2,vertLabels2);

//		System.out.println(graph);
		int lowest=Integer.MAX_VALUE;
		char candidateSource='A';
		for(char src:vertLabels2) {
			resetVisited(visited,vertLabels2,src);
			int currDist=travellingSalesMan(graph2,src);
			System.out.println("==========================");
			System.out.println("Using "+ src +" as source, distance is "+currDist);
			 if(lowest>currDist) {
				 candidateSource=src;
				 lowest=currDist;
			 }
		}
		System.out.println("Starting at "+candidateSource+" has the least cost.");
		for(char a:vertLabels2) {
			visited.put(a, false);
		}
		char src='A';
		path.clear();
		int distance = travellingSalesMan(graph2,candidateSource);
		System.out.println("Path is : ");
		for(char c:path) {
			System.out.print(c+ ",");
		}
		System.out.print(candidateSource);
		System.out.println("; and it took a distance of : "+ distance);
	}


	private static void resetVisited(HashMap<Character, Boolean> visited2, char[] vertLabels, char src) {
		visited.clear();
		visited.put(src,true);
		for(char curr:vertLabels) {
			if(curr!=src) {
				visited2.put(curr,false);
			}
		}
	}


	private static int travellingSalesMan(Graph graph, char currDest) {
		char nextDest,dup=currDest;
		int totalDistance = 0;
		dijkstraAlgorithm(graph,currDest);
		do {
//			System.out.println("currently at "+currDest);
				nextDest=nearestNeighbour(graph,currDest);
//				System.out.println("Next Dest of "+currDest+ " is "+ nextDest);
				totalDistance+=distance.get(nextDest);
				dijkstraAlgorithm(graph,nextDest);
				path.add(currDest);
				totalDistance+=distance.get(nextDest);
				visited.replace(currDest, true);
				currDest=nextDest;
		}while(!tripComplete());
		totalDistance+=distance.get(dup);
		return totalDistance;
	}
	private static char nearestNeighbour(Graph graph, char currDest) {
		char ret=currDest;
		int currlowestval=Integer.MAX_VALUE;
		for(char currnode:distance.keySet()) {
			if(currnode!=currDest&&!visited.get(currnode)) {
//				System.out.println(currnode+ " is being processed");
				if(distance.get(currnode)<currlowestval) {
//					System.out.println(currnode+ " is closer");

//					System.out.print("cOmparing "+ distance.get(currnode)+ " and "+currlowestval);
					ret=currnode;
					currlowestval=distance.get(currnode);
				}
			}
			else {
//				System.out.println(currnode+ " has already been visited.. skipping");
			}
		}
//		System.out.println("Nearest: "+ret);
		return ret;
	}

	static boolean tripComplete() {
		for(char b:visited.keySet()) {
			if(visited.get(b)==false) {
				return false;
			}
		}
		return true;
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
