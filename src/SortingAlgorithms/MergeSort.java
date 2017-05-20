package SortingAlgorithms;

import Commons.UsefulMethods;

public class MergeSort {
	
	//01_MAIN BODY
	//************************************************************
	public static int[] mergeSort(int[] array){
		//Base Case
		if(array.length==1){
			return array;
		}
		//Recursive Step
		int center=(array.length/2)-1;
		int[] leftHalf=mergeSort(UsefulMethods.createSubArray(array, 0, center));
		int[] rightHalf=mergeSort(UsefulMethods.createSubArray(array, center+1, array.length-1));
		return joinParts(leftHalf, rightHalf);
	}
	
	//02_JOIN PARTS
	//***********************************************************
	private static int[] joinParts(int[] leftPart, int[] rightPart){
		int[] result=new int[leftPart.length+rightPart.length];
		int pointer1=1; int pointer2=1; int pointer=1;
		//*******************
		while((pointer1<=leftPart.length)&&(pointer2<=rightPart.length)){
			if(leftPart[pointer1-1]<=rightPart[pointer2-1]){
				result[pointer-1]=leftPart[pointer1-1];
				pointer1++;
			}else{
				result[pointer-1]=rightPart[pointer2-1];
				pointer2++;
			}
			pointer++;
		}
		//*******************
		if(pointer1<=leftPart.length){
			for(int index=pointer1; index<=leftPart.length; index++){
				result[pointer-1]=leftPart[index-1];
				pointer++;
			}
		}
		if(pointer2<=rightPart.length){
			for(int index=pointer2; index<=rightPart.length; index++){
				result[pointer-1]=rightPart[index-1];
				pointer++;
			}
		}
		return result;
	}
	

}
