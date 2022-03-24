package RecursionPractice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


import RecursionPractice.Graph;
public class findShortestPath {
	
	static HashMap<Character,ArrayList<Character>> parents= new HashMap<Character,ArrayList<Character>>();
	static HashMap<Character,ArrayList<Integer>> levels= new HashMap<Character,ArrayList<Integer>>();
	public static void main(String[] args) {
		Graph g = new Graph();
		
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addEdge('A', 'B', false);
		g.addEdge('A', 'C', false);
		g.addEdge('A', 'D', false);
		g.addEdge('B', 'C', false);
		g.addEdge('D', 'C', false);
		g.addEdge('C', 'E', false);
		g.addEdge('D', 'E', false);
		g.addEdge('E', 'F', false);
		g.addEdge('B', 'F', false);
		g.processGraph();
		char from='A';
		char to='F';
		findShortestPath(g,from,to,new ArrayList<Character>(),new ArrayList<Character>(),false);
		System.out.println(g);
		System.out.println("Shortest Path from " + to + " to  " + from + " is ");

		for(ArrayList<Character> path:paths) {
			
			for(char c:path) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
static ArrayList<ArrayList<Character>> paths = new ArrayList<ArrayList<Character>>();
	private static void findShortestPath(Graph g, char src,char dest,ArrayList<Character> currpath,ArrayList<Character> visited,boolean found) {
		if(currpath.contains(src)) {return;}
		if(!currpath.contains(dest)) {currpath.add(dest);}
		for(char parent:g.parents.get(dest)) {
			if(currpath.contains(src)) {return;}
			if(!visited.contains(parent)) {
			currpath.add(parent);
			visited.add(parent);
			System.out.println("Adding parent "+ parent+" for node "+ dest);
			if(parent==src) {
			paths.add(currpath);
			found=true;
			return;
			}
			else {
				if(currpath.contains(src)) {return;}
				findShortestPath(g,src,parent,currpath,visited,false);
			}
			}
		}
		
	}
	
	private static void calculatePaths(Graph g,Character head) {
		int i=1;
		ArrayList<Character> frontier = new ArrayList<Character>();
		ArrayList<Character> next = new ArrayList<Character>();
		frontier.add(head);
		while(!frontier.isEmpty()) {
			next.clear();
			for(char vertex : frontier) {
				for(char connectedNodes : g.map.get(vertex)) {
					if(!levels.containsKey(connectedNodes)) {
						levels.put(connectedNodes, new ArrayList<Integer>());
						if(!parents.containsKey(connectedNodes)) {
						parents.put(connectedNodes, new ArrayList<Character>());
						parents.get(connectedNodes).add(vertex);}
						else {
							parents.get(connectedNodes).add(vertex);
						}
					}
					next.add(connectedNodes);
					frontier = next;
					i++;
				}
			}
		}
	}

}
