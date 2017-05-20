package SearchTrees;

public interface IAVLTree<T> {

	public void insert(Comparable<T> element);
	public Comparable<T> remove(Comparable<T> element);
	public boolean search(Comparable<T> element);
	public void traverse();
	
	//private void inorderTraverse(Comparable<T> node);
	//private void preorderTraversal(Comparable<T> node);
	//private void postorderTraversal(Comparable<T> node);
	
}
