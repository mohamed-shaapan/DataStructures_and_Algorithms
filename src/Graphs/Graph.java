package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	
	//01_ATTRIBUTES
	//*************************************************
	private HashMap<String, Node> vertices;
	
	
	//02_CONSTRUCTOR
	//*************************************************
	public Graph(){
		vertices=new HashMap<String, Node>();
	}
	
	//03_METHODS
	//*************************************************
	public void addNode(Node node){
		vertices.put(node.getKey(), node);
	}
	
	public Node getNode(String nodeName){
		return vertices.get(nodeName);
	}
	

	//BREADTH-FIRST TRAVERSAL**************************************
	public void bfsTraversal(Node node){
		
		HashMap<String, Node> visitedNodes=new HashMap<>();
		LinkedList<Node> queue=new LinkedList<>();
		queue.addLast(node);
		visitedNodes.put(node.getKey(), node);
		
		while(!queue.isEmpty()){
			//printQueue(new ArrayList<Node>(queue));
			//pop first vertex
			Node tmp=queue.removeFirst();
			System.out.println(""+tmp.getValue());
			//add vertex adjacent nodes
			ArrayList<Edge> adjacentNodes=new ArrayList<>(tmp.getAdjacency());
			for(Edge adjacent: adjacentNodes){
				boolean visited=visitedNodes.containsKey(adjacent.getToNode().getKey());
				if(visited==false){
					queue.addLast(adjacent.getToNode());
					visitedNodes.put(adjacent.getToNode().getKey(), adjacent.getToNode());
				}
				
			}
		}
		
	}
	
	//***************************************************************
	//***************************************************************
	public void runDijkstra(String fromNode, String toNode){
		runDijkstra(vertices.get(fromNode), vertices.get(toNode));
	}
	
	
	private void runDijkstra(Node fromNode, Node toNode){
		ArrayList<Node> graphNodes=new ArrayList<>(vertices.values());
		//01_create lists for visited and unvisited nodes
		HashMap<String, Node> visitedNodes=new HashMap<>();
		HashMap<String, Node> unvisitedNodes=new HashMap<>();
		for(Node node: graphNodes){
			unvisitedNodes.put(node.getKey(), node);
		}
		
		//02_initialize result table
		int numberOfNodes=vertices.size();
		String[] vertexList=new String[numberOfNodes];
		int[] overallWeight=new int[numberOfNodes];
		String[] previousVertex=new String[numberOfNodes];
		HashMap<String, Integer> nodeIndex=new HashMap<>();
		for(int i=1; i<=numberOfNodes; i++){
			vertexList[i-1]=graphNodes.get(i-1).getKey();
			overallWeight[i-1]=Integer.MAX_VALUE;
			previousVertex[i-1]="-1";
			nodeIndex.put(graphNodes.get(i-1).getKey(), i-1);
		}
		
		//System.out.println(nodeIndex.get("a"));
		
		//03_run algorithm
		Node currentNode=fromNode;
		while(!unvisitedNodes.isEmpty()){
			System.out.println("current node : "+currentNode.getKey());
			for(Edge e:currentNode.getAdjacency()){
				Node v=e.getToNode();
				if(visitedNodes.containsKey(v.getKey())){
					continue;
				}
				int currentNodeIndex=nodeIndex.get(currentNode.getKey());
				int adjacentNodeIndex=nodeIndex.get(v.getKey());
				int tmpWeight=overallWeight[currentNodeIndex]+e.getWeight();
				if(tmpWeight<overallWeight[adjacentNodeIndex]){
					overallWeight[adjacentNodeIndex]=tmpWeight;
					previousVertex[adjacentNodeIndex]=currentNode.getKey();
				}
			}
			//update entries
			visitedNodes.put(currentNode.getKey(), currentNode);
			unvisitedNodes.remove(currentNode.getKey());
			//get next unvisited vertex with smallest overall weight
			int minValue=Integer.MAX_VALUE;
			int resultIndex=-1;
			for(int i=1; i<=overallWeight.length; i++){
				String nodeKey=vertexList[i-1];
				if(visitedNodes.containsKey(nodeKey)){
					continue;
				}
				if(overallWeight[i-1]<minValue){
					minValue=overallWeight[i-1];
					resultIndex=i-1;
				}	
			}
			//String nextNodeKey
			if(resultIndex==-1){
				continue;
			}
			currentNode=vertices.get(vertexList[resultIndex]);
		}
		
		//print result
		ArrayList<String> result=new ArrayList<>();
		result.add(toNode.getKey());
		int targetNodeIndex=nodeIndex.get(toNode.getKey());
		String parent=previousVertex[targetNodeIndex];
		result.add(parent);
		
		while(!parent.equalsIgnoreCase(fromNode.getKey())){
			int parentIndex=nodeIndex.get(parent);
			parent=previousVertex[parentIndex];
			result.add(parent);
		}
		
		System.out.println(result.toString());
		
		
	}
	
	//***************************************************************
	//***************************************************************
	public void runBellmanFord(String fromNode, String toNode){
		runBellmanFord(vertices.get(fromNode), vertices.get(toNode));
	} 
	
	private void runBellmanFord(Node fromNode, Node toNode){
		ArrayList<Node> graphNodes=new ArrayList<>(vertices.values());
		
		//01_initialize iteration table
		int numberOfNodes=vertices.size();
		String[] vertexList=new String[numberOfNodes];
		int[] overallWeight=new int[numberOfNodes];
		String[] previousVertex=new String[numberOfNodes];
		HashMap<String, Integer> nodeIndex=new HashMap<>();
		for(int i=1; i<=numberOfNodes; i++){
			vertexList[i-1]=graphNodes.get(i-1).getKey();
			overallWeight[i-1]=Integer.MAX_VALUE;
			previousVertex[i-1]="-1";
			nodeIndex.put(graphNodes.get(i-1).getKey(), i-1);
		}
		
		//02_run n-1 iterations
		for(int iteration=1; iteration<=numberOfNodes; iteration++){
			for(int index=1; index<=numberOfNodes; index++){
				Node currentNode=vertices.get(vertexList[index-1]);
				for(Edge edge:currentNode.getAdjacency()){
					Node adjacent=edge.getToNode();
					
					int currentNodeIndex=nodeIndex.get(currentNode.getKey());
					int adjacentNodeIndex=nodeIndex.get(adjacent.getKey());
					
					int tmpWeight=overallWeight[currentNodeIndex]+edge.getWeight();
					if(tmpWeight<overallWeight[adjacentNodeIndex]){
						overallWeight[adjacentNodeIndex]=tmpWeight;
						previousVertex[adjacentNodeIndex]=currentNode.getKey();
					}
				}
			}
		}

		//03_print result
		ArrayList<String> result=new ArrayList<>();
		result.add(toNode.getKey());
		int targetNodeIndex=nodeIndex.get(toNode.getKey());
		String parent=previousVertex[targetNodeIndex];
		result.add(parent);
		
		while(!parent.equalsIgnoreCase(fromNode.getKey())){
			int parentIndex=nodeIndex.get(parent);
			parent=previousVertex[parentIndex];
			result.add(parent);
		}
		
		System.out.println(result.toString());
		
		
	}
	
	
	
	
	
	
	
	/*
	private void printQueue(ArrayList<Node> queue){
		System.out.print("\t");
		for(Node tmp:queue){
			System.out.print(tmp.getKey()+", ");
		}
		System.out.println("");
		
	}*/
	
	
	
	

	
	
	
	
	
	
}
