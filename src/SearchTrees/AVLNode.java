package SearchTrees;

public class AVLNode {
	
	//01_ATTRIBUTES
	//**********************************************************
	private int key;
	private AVLNode parent;
	private AVLNode leftChild;
	private AVLNode rightChild;
	private int balanceFactor; //balanced=0, leftSkew=+1, rightSkew=-1
	
	
	//02_CONSTRUCTOR
	//**********************************************************
	public AVLNode(int key, AVLNode parent, AVLNode leftChild, AVLNode rightChild){
		this.key=key;
		this.parent=parent;
		this.leftChild=leftChild;
		this.rightChild=rightChild;
		balanceFactor=0;
	}

	//03_METHODS
	//**********************************************************
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public AVLNode getParent() {
		return parent;
	}

	public void setParent(AVLNode parent) {
		this.parent = parent;
	}

	public AVLNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(AVLNode leftChild) {
		this.leftChild = leftChild;
	}

	public AVLNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(AVLNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public void setBalanceFactor(int balanceFactor){
		this.balanceFactor=balanceFactor;
	}
	public int getBalanceFactor(){
		return balanceFactor;
	}
	
	public void updateBalanceFactor(int newSkew){
		balanceFactor+=newSkew;
		/*if(newSkew==1){
		if(balanceFactor==0){
			balanceFactor=1;
		}
		if(balanceFactor==-1){
				balanceFactor=0;
			}
			
		}
		if(newSkew==-1){
			if(balanceFactor==0){
				balanceFactor=-1;
			}
			if(balanceFactor==1){
				balanceFactor=0;
			}
		}*/

	}
	

	

}
