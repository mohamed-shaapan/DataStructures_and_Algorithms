package SortingAlgorithms;

public class SortHandler {

	//01_BUBBLE SORT
	//************************************************************
	public static void bubbleSort(int[] array){
		SimpleSort.bubbleSort(array);
	}
	
	//02_INSERTION SORT
	//************************************************************
	public static void insertSort(int[] array){
		SimpleSort.insertSort(array);
	}
	
	//03_SELECTION SORT
	//************************************************************
	public static void selectSort(int[] array){
		SimpleSort.selectSort(array);
	}
	
	//04_MERGE SORT
	//************************************************************
	public static int[] mergeSort(int[] array){
		return MergeSort.mergeSort(array);
	}
	
	//05_QUICK SORT
	//************************************************************
	public static void quickSort(int[] array){
		QuickSort.quickSort(array);
	}
	
	
	
	
	
	
}
