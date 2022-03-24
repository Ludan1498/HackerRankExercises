package RecursionPractice;
import java.util.*;
import java.util.Map.Entry;
import RecursionPractice.Graph;
public class PermutationsUsingGraphs {
	static ArrayList<String> permutations = new ArrayList<String>();
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addEdge('A', 'B', true);
		g.addEdge('A', 'C', true);
		g.addEdge('A', 'D', true);
		g.addEdge('A', 'E', true);
		g.addEdge('B', 'C', true);
		g.addEdge('B', 'D', true);
		g.addEdge('B', 'E', true);
		g.addEdge('C', 'D', true);
		g.addEdge('C', 'E', true);
		g.addEdge('D', 'E', true);
		System.out.println(g);
		permutate(g);
for(String s:permutations) {
	System.out.println(s);
}

	}

//	private static void permutate(Graph g) {
//		 permutateAux2(g,new ArrayList<Character>(),new StringBuilder());
//	}
//	private static void permutateAux(graph g,ArrayList<Character> visited,StringBuilder currPermutation) {
//		for(Entry<Character, ArrayList<Character>> node:g.vertices.entrySet()) {
//			visited.add(node.getKey());
//			currPermutation.append(node.getKey());
//			for (Character v: node.getValue()) {
//				currPermutation.append();
//			}
//		}
//	}
	private static void permutate(Graph g) {
		for(Character src :  g.map.keySet()) {
			
			for (Character dest:g.map.get(src)) {
				System.out.println(src + " " + dest);
//				permutateAux(src,dest,g,new ArrayList<Character>(),new StringBuilder(), new Stack<Character>(),new ArrayList<String>());
			}
			}
		}
		
	
	
	private static void permutateAux(Character src,Character dest,Graph g,ArrayList<Character> visited,StringBuilder currPermutation,Stack<Character> currstack,ArrayList<String> visitedEdges) {
		
		currPermutation.append(src);//path
		visited.add(src);
		currstack.push(src);
		for(Character node:g.map.get(src)) {
			if(!(visited.contains(node)&&node==dest&&!(visitedEdges.contains(Character.toString(currstack.peek())+Character.toString(node)))))
			for(Character leaves:g.map.get(node))
			if(!(visited.contains(node)&&node==dest&&!(visitedEdges.contains(Character.toString(currstack.peek())+Character.toString(node))))) {
			visited.add(node);
//			for(String v:visitedEdges) {
//				System.out.println(v);
//			}
//			System.out.println("Prev char is "+ Character.toString(currstack.peek())+" Current char is "+ Character.toString(node));
			currPermutation.append(node);
			visitedEdges.add(Character.toString(currstack.peek())+Character.toString(node));
			currstack.add(node);
		}
		}
		currPermutation.append(dest);
		permutations.add(currPermutation.toString());
	
}
	private static void permutateAux2(Character src,Character dest,Character next,Graph g,ArrayList<Character> visited,StringBuilder currPermutation,Stack<Character> currstack,ArrayList<String> visitedEdges) {
		if(visitedEdges.size()<(g.getVertexCount()+1)*(g.getVertexCount()-1)) {
		return;
	}
	else if(currPermutation.length()==g.map.size()-1)
	{
		currPermutation.append(dest);
		permutations.add(currPermutation.toString());
		return;
	}
	else if(currPermutation.length()<g.map.size()) {
		if()
	}
}
	}
