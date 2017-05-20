package Commons;

public class UsefulMethods {
	
	
	public static void swapNumbers(int[] array, int index1, int index2){
		int tmp=array[index1];
		array[index1]=array[index2];
		array[index2]=tmp;
	}
	
	public static void swapNumbers(double[] array, int index1, int index2){
		double tmp=array[index1];
		array[index1]=array[index2];
		array[index2]=tmp;
	}
	
	public static int[] createSubArray(int[] source, int start, int end){
		int[] result=new int[end-start+1];
		for(int i=1; i<=result.length; i++){
			result[i-1]=source[start];
			start++;
		}
		return result;
	}
	
	public static double[] createSubArray(double[] source, int start, int end){
		double[] result=new double[end-start+1];
		for(int i=1; i<=result.length; i++){
			result[i-1]=source[start];
			start++;
		}
		return result;
	}
	
	public static void printArray(int[] array){
		for(int number: array){
			System.out.print(number+", ");
		}
		System.out.println("");
	}
	
	public static void printArray(double[] array){
		for(double number: array){
			System.out.print(number+", ");
		}
		System.out.println("");
	}
	
	public static void printArray(int[] array, int start, int end){
		System.out.println("\n");
		for(int index=start; index<=end; index++){
			int number=array[index];
			System.out.print(number+", ");
		}
	}
	
	public static void printArray(double[] array, int start, int end){
		System.out.println("\n");
		for(int index=start; index<=end; index++){
			double number=array[index];
			System.out.print(number+", ");
		}
	}
	
	public static int[] copyArray(int array[]){
		int result[]=new int[array.length];
		for(int i=1; i<=array.length; i++){
			result[i-1]=array[i-1];
		}
		return result;
	}

}
