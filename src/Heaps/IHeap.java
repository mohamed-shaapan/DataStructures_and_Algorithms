package Heaps;

public interface IHeap<T> {
	
	public void insert(Comparable<T> element);
	public Comparable<T> extract();
	public Comparable<T> remove(Comparable<T> element);
	public boolean search(Comparable<T> element);
	
	public Comparable<T> peek();
	public Comparable<T> pop();
	public Iterable<T> iterator();
	public Iterable<T> clear();
	
	public Iterable<T> heapSort();
	
	//private void maxHeapify();
	//private void buildMaxHeap();
	//private void siftUp();
	
}
