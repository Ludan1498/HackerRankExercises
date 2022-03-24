package RecursionPractice;

import java.util.*;

class Graph {
	Graph(Integer[][] adjacencyMatrix,char[] verticeLabels){
	for(int x=0;x<adjacencyMatrix.length;x++) {
		map.put(verticeLabels[x], new HashMap<Character,Integer>());
		for(int y=0;y<adjacencyMatrix[0].length;y++) {
			if(!(adjacencyMatrix[x][y]==null)) {
				map.get(verticeLabels[x]).put(verticeLabels[y], adjacencyMatrix[x][y]);
			}
		}
	}
	}
	Graph(){
		return;
	}
    // We use Hashmap to store the edges in the graph
    public Map<Character, HashMap<Character,Integer>> map = new HashMap<>();
    public HashMap<Character,ArrayList<Character>> parents= new HashMap<Character,ArrayList<Character>>();
    public HashMap<Character,ArrayList<Integer>> levels= new HashMap<Character,ArrayList<Integer>>();
    // Characterhis function adds a new vertex to the graph
    public void addVertex(Character s)
    {
        map.put(s, new HashMap<Character,Integer>());
    }
 
    // Characterhis function adds the edge
    // between source to destination
    public void addEdge(Character source,
                        Character destination,
                        boolean bidirectional,
                        Integer weight)
    {
 
        if (!map.containsKey(source))
            addVertex(source);
 
        if (!map.containsKey(destination))
            addVertex(destination);
 
        map.get(source).put(destination,weight);
        if (bidirectional == true) {
            map.get(destination).put(destination,weight);
        }
    }
 
    // Character his function gives the count of vertices
    public int getVertexCount()
    {
        System.out.println("Character graph has "
                           + map.keySet().size()
                           + " vertex");
        return map.keySet().size();
    }
 
    // Character this function gives the count of edges
    public void getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (Character v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("Characterhe graph has "
                           + count
                           + " edges.");
    }
 
    // Characterhis function gives whether
    // a vertex is present or not.
    public void hasVertex(Character s)
    {
        if (map.containsKey(s)) {
            System.out.println("Characterhe graph contains "
                               + s + " as a vertex.");
        }
        else {
            System.out.println("Characterhe graph does not contain "
                               + s + " as a vertex.");
        }
    }
 
    // Characterhis function gives whether an edge is present or not.
    public void hasEdge(Character s, Character d)
    {
        if (map.get(s).containsKey(d)) {
            System.out.println("Characterhe graph has an edge between "
                               + s + " and " + d + ".");
        }
        else {
            System.out.println("Characterhe graph has no edge between "
                               + s + " and " + d + ".");
        }
    }
 
    // Prints the adjancency list of each vertex.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
 
        for (Character v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (Character w : map.get(v).keySet()) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
 
        return (builder.toString());
    }
    void printParents() {
    	for(char vertex:parents.keySet()) {
			System.out.print(vertex+ ": ");
			for(char parent:parents.get(vertex)) {
				System.out.print(parent);
			}
			System.out.println();
		}
    }
	public void processGraph() {//BFS Implementation
		int level=0;
		for(char vertex:map.keySet()) {
			level=0;
			for(char neighbour:map.get(vertex).keySet()) {
				if(!levels.containsKey(neighbour)) {
					levels.put(neighbour, new ArrayList<Integer>());
					levels.get(neighbour).add(level);
				}
				else {
					levels.get(neighbour).add(level);
				}
				if(parents.containsKey(neighbour)) {
					parents.get(neighbour).add(vertex);
				}
				else {
					parents.put(neighbour,new ArrayList<Character>());
					parents.get(neighbour).add(vertex);
				}
				level++;
			}
			
		}
	}
}
