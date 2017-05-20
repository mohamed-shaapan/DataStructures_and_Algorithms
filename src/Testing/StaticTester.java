package Testing;

import Commons.UsefulMethods;
import SortingAlgorithms.SortHandler;

public class StaticTester {

	public static void main(String args[]) {
		/*
		 * //01_BUBBLE SORT int[] array1={100, 30, 10, 111, 75, 99, 3, 23, 17,
		 * 18}; SortHandler.bubbleSort(array1); //02_INSERTION SORT int[]
		 * array2={100, 30, 10, 111, 75, 99, 3, 23, 17, 18};
		 * SortHandler.insertSort(array2); //03_SELECTION SORT int[]
		 * array3={100, 30, 10, 111, 75, 99, 3, 23, 17, 18};
		 * SortHandler.selectSort(array3);
		 */
		// 04_MERGE SORT
		int[] array4 = { 100, 30, 10, 111, 75, 99, 3, 23, 17, 18 };
		array4 = SortHandler.mergeSort(array4);
		/*
		 * //05_QUICK SORT int[] array5={100, 30, 10, 111, 75, 99, 3, 23, 17,
		 * 18}; SortHandler.quickSort(array5);
		 */

		// ***********************************************************
		UsefulMethods.printArray(array4);

	}

}
