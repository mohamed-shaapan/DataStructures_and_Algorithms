package SortingAlgorithms;

import Commons.UsefulMethods;

public class SimpleSort {

	//01_BUBBLE SORT
	//************************************************************
	public static void bubbleSort(int[] array){
		for(int size=array.length-1; size>=2; size--){
			for(int index=1; index<=size; index++){
				if(array[index-1]>array[index]){
					UsefulMethods.swapNumbers(array, index-1, index);
				}
			}
		}
	}
	
	//02_INSERTION SORT
	//************************************************************
	public static void insertSort(int[] array){
		for(int size=2; size<=array.length; size++){
			for(int index=size; index>=2; index--){
				if(array[index-1]<array[index-2]){
					UsefulMethods.swapNumbers(array, index-1, index-2);
				}else{
					break;
				}
			}
		}
	}
	
	
	//03_SELECTION SORT
	//************************************************************
	public static void selectSort(int[] array){
		for(int size=array.length; size>=2; size--){
			int maxIndex[]={1};
			for(int index=2; index<=size; index++){
				if(array[index-1]>array[maxIndex[0]-1]){
					maxIndex[0]=index;
				}
			}
			UsefulMethods.swapNumbers(array, size-1, maxIndex[0]-1);
		}
	}
	
	
}
