package SortingAlgorithms;

public class SearchHandler {
	
	
	//01_Linear Search
	//************************************************************
	public static int linearSearch(int[] array, int number){
		for(int index=1; index<=array.length; index++){
			if(array[index-1]==number){
				return index-1;
			}
		}
		return -1;
	}
	
	
	//02_Binary Search
	//************************************************************
	public static int binarySearch(int[] array, int number){
		return binarySearchImplement(array, number, 0, array.length-1);
	}
	
	private static int binarySearchImplement(int[] array, int number, int start, int end){
		//Base Case
		if(start==end){
			if(array[start]==number){
				return start;
			}
			return -1;
		}
		//Recursive Step
		int center=((end+start)/2);
		if(number>=array[center+1]){
			return binarySearchImplement(array, number, center+1, end);
		}else{
			return binarySearchImplement(array, number, start, center);
		}
	}

}
