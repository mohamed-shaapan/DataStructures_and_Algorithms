package SearchTrees;

public class AVLTree {
	
	//01_ATTRIBUTES
	//**********************************************************
	private AVLNode root;
	
	//02_CONSTRUCTOR
	//**********************************************************
	public AVLTree(){
		
	}
	

	//01_INSERTION NEW NODE
	//**********************************************************
	//**********************************************************
	public void insert(int key){
		if(root==null){
			root=new AVLNode(key, null, null, null);
		}else{
			AVLNode node=BSTRecursiveInsertion(key, root);
			balanceNodeRecursive(node);
		}
	}
	
	//BINARY SEARCH TREE INSERTION
	//*************************************************************
	private AVLNode BSTRecursiveInsertion(int key, AVLNode node){
		if(key<=node.getKey()){
			//add to left recursively
			node.updateBalanceFactor(1);
			if(node.getLeftChild()!=null){
				BSTRecursiveInsertion(key, node.getLeftChild());
			}else{
				AVLNode tmp=new AVLNode(key, node, null, null);
				node.setLeftChild(tmp);
				return tmp;
			}
		}
		if(key>node.getKey()){
			//add to right recursively
			node.updateBalanceFactor(-1);
			if(node.getRightChild()!=null){
				BSTRecursiveInsertion(key, node.getRightChild());
			}else{
				AVLNode tmp=new AVLNode(key, node, null, null);
				node.setRightChild(tmp);
				return tmp;
			}
		}
		return null;
	}
	
	
	//NODE BALANCING
	//*********************************************************
	private void balanceNodeRecursive(AVLNode node){
		if(node==null){
			return;
		}
		balanceSingleNode(node);
		balanceNodeRecursive(node.getParent());
	}
	
	private void balanceSingleNode(AVLNode node){
		//01_LEFT SKEWED NODE
		if(node.getBalanceFactor()>1){
			if(node.getLeftChild().getBalanceFactor()==1){
				rightRotation(node);
				return;
			}
			if(node.getLeftChild().getBalanceFactor()==-1){
				leftRightRotation(node);
				return;
			}
			if(node.getLeftChild().getBalanceFactor()==0){
				node.updateBalanceFactor(1);
				return;
			}
		}
		//02_RIGHT SKEWED NODE
		if(node.getBalanceFactor()<-1){
			if(node.getRightChild().getBalanceFactor()==1){
				rightLeftRotation(node);
				return;
			}
			if(node.getRightChild().getBalanceFactor()==-1){
				leftRotation(node);
				return;
			}
			if(node.getRightChild().getBalanceFactor()==-1){
				node.updateBalanceFactor(1);
				return;
			}
		}
	}
	
	//ROTATIONS
	//**********************************************************
	private void leftRotation(AVLNode node){
		AVLNode parent=node.getParent();
		AVLNode rightChild=node.getRightChild();
		AVLNode rightChildLeftChild=rightChild.getLeftChild();
		//changing pointers
		rightChild.setParent(parent);
		rightChild.setLeftChild(node);
		node.setParent(rightChild);
		try{//leaf error
			node.setRightChild(rightChildLeftChild);
			rightChildLeftChild.setParent(node);
		}catch(Exception ex){}
		//updating balance factors
		rightChild.setBalanceFactor(0);
		node.setBalanceFactor(0);
		
	}
	private void rightRotation(AVLNode node){
		AVLNode parent=node.getParent();
		AVLNode leftChild=node.getLeftChild();
		AVLNode leftChildRightChild=leftChild.getRightChild();
		//changing pointers
		leftChild.setParent(parent);
		leftChild.setRightChild(node);
		node.setParent(leftChild);
		try{//leaf error
			node.setLeftChild(leftChildRightChild);
			leftChildRightChild.setParent(node);
		}catch(Exception ex){}
		//updating balance factors
		leftChild.setBalanceFactor(0);
		node.setBalanceFactor(0);
		
	}
	private void leftRightRotation(AVLNode node){
		AVLNode leftChild=node.getLeftChild();
		leftRotation(leftChild);
		rightRotation(node);
		
	}
	private void rightLeftRotation(AVLNode node){
		AVLNode rightChild=node.getRightChild();
		rightRotation(rightChild);
		leftRotation(node);
		
	}
	
	//********************************************************
	//********************************************************
	public boolean search(int key){
		return searchImplementation(key, root);
	}
	
	private boolean searchImplementation(int key, AVLNode node){
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
	
	private void printTreeImplementation(AVLNode node){
		System.out.println(node.getKey());
		if(node.getLeftChild()!=null){
			printTreeImplementation(node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			printTreeImplementation(node.getRightChild());
		}
	}
	
	

}
