package Graphs;

public class Edge {

	//01_ATTRIBUTES
	//*************************************************
	private Node fromNode;
	private Node toNode;
	private int weight;
	
	
	//02_CONSTRUCTOR
	//*************************************************
	public Edge(Node fromNode, Node toNode, int weight){
		this.fromNode=fromNode;
		this.toNode=toNode;
		this.weight=weight;
	}


	//03_METHODS
	//*************************************************
	public Node getFromNode() {
		return fromNode;
	}


	public void setFromNode(Node fromNode) {
		this.fromNode = fromNode;
	}


	public Node getToNode() {
		return toNode;
	}


	public void setToNode(Node toNode) {
		this.toNode = toNode;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
