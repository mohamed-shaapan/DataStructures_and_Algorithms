package Testing;

import java.io.FileNotFoundException;

import Commons.FileHandler;
import Commons.UsefulMethods;
import Heaps.BinaryHeap;
import SearchTrees.AVLTree;
import SearchTrees.BinarySearchTree;

public class DynamicTester {

	public static void main(String args[]) {
		binarySearchTreeTest();
		// AVLTreeTest();
		// heapSortTest();

		// long startTime = System.currentTimeMillis();
		// long endTime = System.currentTimeMillis();
		// long totalTime=endTime-startTime;
		// System.out.println(arg0);
	}

	// BINARY HEAPS TESTS
	// *****************************************************
	@SuppressWarnings("unused")
	private static void heapSortTest() {
		double[] sample1 = { 100, 30, 10, 111, 75, 99, 3, 23, 17, 999, 22, 15, 24, 7 };
		// int[] sample2={32, 14, 452, 994321, 3333, 789, 294};
		// int[] sample3={87, 73, 9384, 11446, 1357, 246, 3, 88, 11, -500};
		// int[] sample4={100, 30, 10, 111, 75};
		double[] data = new double[1];
		try {
			data = FileHandler.openFile();
		} catch (FileNotFoundException e) {
		}
		System.out.println("Loaded!!!!!!!!");

		BinaryHeap heap = new BinaryHeap(data);
		// 01_BUILD MAX HEAP
		double[] result = heap.buildMaxHeap();
		// 02_INSERT OPERATION
		// result=heap.maxHeapInsert(19);
		// 03_DEQUEUE OPERATION
		// double max=heap.heapExtractMax();
		// 04_HEAP SORT OPERATION

		long startTime = System.currentTimeMillis();
		result = heap.heapSort();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;

		System.out.println(totalTime);
		UsefulMethods.printArray(result);
		/*
		 * try { FileReader.writeData(data); } catch (FileNotFoundException e) {
		 * }
		 */

	}

	// BINARY SEARCH TREE TESTS
	// *****************************************************
	private static void binarySearchTreeTest() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(8);
		tree.insert(17);
		tree.insert(25);
		tree.insert(1);
		tree.insert(111);
		tree.insert(7);
		tree.insert(51);
		tree.insert(92);
		tree.insert(31);
		tree.insert(66);
		tree.insert(41);

		tree.printTree();
		System.out.println(tree.search(66));
	}

	// AVL TREE TESTS
	// *****************************************************
	@SuppressWarnings("unused")
	private static void AVLTreeTest() {
		AVLTree tree = new AVLTree();
		tree.insert(8);
		tree.insert(17);
		tree.insert(25);
		tree.insert(1);
		tree.insert(111);
		tree.insert(7);
		tree.insert(51);
		tree.insert(92);
		tree.insert(31);
		tree.insert(66);
		tree.insert(41);

		tree.printTree();
		System.out.println(tree.search(66));
	}

}
