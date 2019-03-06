import java.util.ArrayList;

public class Graph {
	ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	
	public void printVertices() {
		for(Vertex v : vertices) {
			System.out.println(v.id + ":");
			for(String t : v.tags) {
				System.out.println(t + ", ");
			}
			System.out.println();
		}
	}
	
}
