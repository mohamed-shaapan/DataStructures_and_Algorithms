package Heaps;

import Commons.UsefulMethods;

public class BinaryHeap {
	
	
	//01_ATTRIBUTES
	//***************************************************
	private int heapCapacity;
	private int dataLength;
	private double heapData[];
	
	//02_CONSTRUCTOR
	//***************************************************
	public BinaryHeap(double[] array){
		this.heapData=new double[array.length];
		for(int i=1; i<=array.length; i++){
			this.heapData[i-1]=array[i-1];
		}
		this.heapCapacity=this.heapData.length;
		this.dataLength=array.length;	
	}
	
	public BinaryHeap(int capacity){
		
	}

	
	//INSERT TOP BOTTOM
	//****************************************
	private void maxHeapify(double[] array, int index){
		//add element from Top Bottom
		int leftChildIndex=(2*index)+1;
		int rightChildIndex=(2*index)+2;
		int largestChildIndex=dataLength;
		//Obtain index of largest child
		if(leftChildIndex<dataLength){
			largestChildIndex=leftChildIndex;
		}
		if(rightChildIndex<dataLength){
			if(array[rightChildIndex]>array[leftChildIndex]){
				largestChildIndex=rightChildIndex;
			}
		}
		//perform recursive insertion
		if(largestChildIndex<dataLength){
			if(array[largestChildIndex]>array[index]){
				UsefulMethods.swapNumbers(array, index, largestChildIndex);
				maxHeapify(array, largestChildIndex);
			}
		}
	}
	
	//GENERATE HEAP
	//****************************************
	public double[] buildMaxHeap(){
		//generate heap array
		int start=(heapData.length/2)-1;
		for(int index=start; index>=0; index--){
			maxHeapify(heapData, index);
		}
		return heapData;
	}
	
	//SORT HEAP
	//****************************************************************
	public double[] heapSort(){
		double[] result=UsefulMethods.createSubArray(heapData, 0, dataLength-1);
		int tmp=dataLength;
		for(int i=tmp; i>=2; i--){
			UsefulMethods.swapNumbers(result, 0, dataLength-1);
			dataLength--;
			maxHeapify(result, 0);
		}
		dataLength=tmp;
		return result;
	}

	
	//****************************************************************
	//PRIORITY QUEUE INSERT OPERATION
	public double[] maxHeapInsert(int element){
		if(dataLength==heapCapacity){
			increaseDataSize();
		}
		heapData[dataLength]=element;
		siftUp(dataLength);
		dataLength++;
		return heapData;
	}
	private void siftUp(int index){
		if(index==0){
			return;
		}else{
			int parentIndex=(index-1)/2;
			if(heapData[index]>heapData[parentIndex]){
				UsefulMethods.swapNumbers(heapData, index, parentIndex);
				siftUp(parentIndex);
			}
		}
	}
	//****************************************************************
	//PRIORITY QUEUE DEQUEUE OPERATION
	public double heapExtractMax(){
		double max=heapData[0];
		UsefulMethods.swapNumbers(heapData, 0, dataLength-1);
		heapData[dataLength-1]=0;
		if(dataLength!=1){
			dataLength--;
		}
		maxHeapify(heapData, 0);
		return max;
	}
	
	//******************************************************************
	private void increaseDataSize(){
		double tmp[]=new double[heapCapacity*2];
		for(int i=1; i<=heapCapacity; i++){
			tmp[i-1]=heapData[i-1];
		}
		heapData=tmp;
		heapCapacity=tmp.length;
	}
	public double[] getData(){
		return this.heapData;
	}
	
	
	
	
	
	
	
	

	
}
