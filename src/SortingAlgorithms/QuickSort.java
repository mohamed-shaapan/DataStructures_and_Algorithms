package SortingAlgorithms;

import Commons.UsefulMethods;

public class QuickSort {
	
	
	//01_MAIN BODY
	//************************************************************
	public static void quickSort(int[] array){
		quickSortImplementation(array, 0, array.length-1);
	}

	
	private static void quickSortImplementation(int[] array, int start, int end){
		if(start>=end){
			return;
		}
		int pivotIndex=(start+end)/2;
		pivotIndex=partitionAboutPivot(array, array[pivotIndex], start, end);
		//CommonMethods.printArray(array, start, end);
		quickSortImplementation(array, pivotIndex+1, end);
		quickSortImplementation(array, start, pivotIndex);
		
	}
	
	//02_PARTITION ARRAY ABOUT PIVOT
	//***********************************************************
	private static int partitionAboutPivot(int[] array, int pivotValue, int start, int end){
		int pointer1=start; int pointer2=end;
		while(pointer2>pointer1){
			boolean test1=(array[pointer1]>=pivotValue);
			boolean test2=(array[pointer2]<=pivotValue);
			//condition 1
			if(test1&&test2){
				UsefulMethods.swapNumbers(array, pointer1, pointer2);
				if(array[pointer1]<pivotValue){
					pointer1++;
				}
				if(array[pointer2]>pivotValue){
					pointer2--;
				}
				continue;
			}
			//condition 2
			if(test1==true){
				pointer2--;
				continue;
			}
			//condition 3
			if(test2==true){
				pointer1++;
				continue;
			}
			//condition 4
			pointer1++;
			pointer2--;
		}
		return pointer1;
		
	}
	
	
	
	
	
}
