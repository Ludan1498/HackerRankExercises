package RecursionPractice;
import RecursionPractice.Graph;
public class GraphStronglyConnected {

	public static void main(String[] args) {
		Graph g = new Graph();
		
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addEdge('A', 'B', true);
		g.addEdge('A', 'C', true);
		g.addEdge('A', 'D', true);
		g.addEdge('B', 'C', true);
		g.addEdge('D', 'C', true);
		g.addEdge('C', 'E', true);
		g.addEdge('D', 'E', true);
		g.addEdge('D', 'B', true);
		g.addEdge('E', 'F', true);
		g.addEdge('B', 'F', true);
		g.addEdge('A', 'F', true);
		g.addEdge('C', 'F', true);
		g.addEdge('D', 'F', true);
		g.processGraph();
		System.out.println(g);
		int numofNodes =g.parents.size();
		for(char vertex:g.parents.keySet()) {
			if(g.parents.get(vertex).size()<numofNodes-1) {
				System.out.println("This node is not strongly connected: " + vertex );
			}
		}
	}

}
