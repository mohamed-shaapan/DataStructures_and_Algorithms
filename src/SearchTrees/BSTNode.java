package SearchTrees;

public class BSTNode {
	
	//01_ATTRIBUTES
	//**********************************************************
	private int key;
	private BSTNode parent;
	private BSTNode leftChild;
	private BSTNode rightChild;
	
	
	//02_CONSTRUCTOR
	//**********************************************************
	public BSTNode(int key, BSTNode parent, BSTNode leftChild, BSTNode rightChild){
		this.key=key;
		this.parent=parent;
		this.leftChild=leftChild;
		this.rightChild=rightChild;
	}

	//03_METHODS
	//**********************************************************
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public BSTNode getParent() {
		return parent;
	}

	public void setParent(BSTNode parent) {
		this.parent = parent;
	}

	public BSTNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}

	public BSTNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}
	

	

}
