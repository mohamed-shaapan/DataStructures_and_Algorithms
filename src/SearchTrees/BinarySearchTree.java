package SearchTrees;

public class BinarySearchTree {
	
	//01_ATTRIBUTES
	//**********************************************************
	private BSTNode root;
	
	//02_CONSTRUCTOR
	//**********************************************************
	public BinarySearchTree(){
		root=new BSTNode(0, null, null, null);
	}
	
	//03_METHODS
	//**********************************************************
	public void insert(int key){
		if(root==null){
			root=new BSTNode(key, null, null, null);
		}else{
			insertImplementation(key, root);
		}
	}
	
	private void insertImplementation(int key, BSTNode node){
		if(key<=node.getKey()){
			//add to left recursively
			if(node.getLeftChild()!=null){
				insertImplementation(key, node.getLeftChild());
			}else{
				BSTNode tmp=new BSTNode(key, node, null, null);
				node.setLeftChild(tmp);
			}
		}
		if(key>node.getKey()){
			//add to right recursively
			if(node.getRightChild()!=null){
				insertImplementation(key, node.getRightChild());
			}else{
				BSTNode tmp=new BSTNode(key, node, null, null);
				node.setRightChild(tmp);
			}
		}
	}
	//**********************************************************
	public void remove(int value){
		
	}
	
	//**********************************************************
	public boolean search(int key){
		return searchImplementation(key, root);
	}
	
	private boolean searchImplementation(int key, BSTNode node){
		if(node.getKey()==key){
			return true;
		}
		//search to left recursively
		if(key<node.getKey()){
			if(node.getLeftChild()!=null){
				return searchImplementation(key, node.getLeftChild());
			}else{
				return false;
			}
		}
		//search to right recursively
		if(key>node.getKey()){
			if(node.getRightChild()!=null){
				return searchImplementation(key, node.getRightChild());
			}else{
				return false;
			}
		}
		return false;
	}
	
	//**********************************************************
	public void printTree(){
		printTreeImplementation(root);
	}
	
	private void printTreeImplementation(BSTNode node){
		System.out.println(node.getKey());
		if(node.getLeftChild()!=null){
			printTreeImplementation(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			printTreeImplementation(node.getRightChild());
		}
	}
	
	
	public BSTNode getRoot(){
		return this.root;
	}

}
