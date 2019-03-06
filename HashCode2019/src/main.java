import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileReader input = new FileReader("b_lovely_landscapes.txt");
		BufferedReader reader = new BufferedReader(input);
		int numberOfLines = Integer.parseInt(reader.readLine());
		Scanner scan;
		Graph g = new Graph();
		SortedMap<String,Integer> sortedKeys = new TreeMap<String,Integer>();
		for(int i=0; i<numberOfLines; i++) {
			scan = new Scanner(reader.readLine());
			Vertex v = new Vertex();
			v.orientation = scan.next();
			v.tagNo = scan.nextInt();
			v.id = i;
			if(v.orientation.equals("H")) {
				while(scan.hasNext()) {
					v.tags.add(scan.next());
				}
				//g.vertices.add(v);
			}
			sortedKeys.put(v.tags.get(0), i);
			scan.close();
		}
		
		System.out.println("Ordered list:");
		while(sortedKeys.size() > 0) {
			String key = sortedKeys.firstKey();
			System.out.println(sortedKeys.get(key));
			sortedKeys.remove(key);
		}
		
		/*
		for(Vertex v : g.vertices) {
			for(Vertex w : g.vertices) {
				v.edges[w.id] = getWeight(v.tags, w.tags);
			}
		}
		
		for(Vertex v : g.vertices) {
			System.out.println(v.id + " : ");
			for(int i=0; i<v.edges.length; i++) {
				System.out.print(v.edges[i] + ", ");
			}
		}
		*/
		reader.close();
		input.close();
	}
	
	public static int getWeight(ArrayList<String> a1, ArrayList<String> a2) {
		int common = 0;
		for(String s : a1) {
			if(a2.contains(s)) {
				common++;
			}
		}
		int diff1 = a1.size()-common;
		int diff2 = a2.size()-common;
		int smallDiff = Math.min(diff1, diff2);
		return Math.min(common, smallDiff);
	}
}
