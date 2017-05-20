package Graphs;

import java.util.LinkedList;

public class Node {
	
	//01_ATTRIBUTES
	//*************************************************
	private String key;
	private String value;
	private LinkedList<Edge> adjacency;
	boolean visited;
	
	
	//02_CONSTRUCTOR
	//*************************************************
	public Node(String key, String value){
		adjacency=new LinkedList<>();
		this.key=key;
		this.value=value;
		visited=false;
	}


	//03_METHODS
	//*************************************************
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public LinkedList<Edge> getAdjacency() {
		return adjacency;
	}


	public void addAdjacent(Node toNode, int edgeWeight){
		Edge tmp=new Edge(this, toNode, edgeWeight);
		adjacency.addLast(tmp);
	}
	
	
	
	
	
	
	
	
	

}
