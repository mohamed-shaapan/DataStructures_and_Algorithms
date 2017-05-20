package PerfectHashing;

import java.util.LinkedList;

//LSP stands for Linear-Space Perfect HashMap
public class LSPHashMap {
	
	//01_ATTRIBUTES
	//*************************************************
	private QSPHashMap primaryTable[];
	private Entry givenDataSet[];
	private int a,b,p,m; //Hash Function = ((ax+b)mod p)mod m
	
	
	//02_CONSTRUCTOR
	//*************************************************
	public LSPHashMap(Entry dataSet[]){
		m=dataSet.length;
		primaryTable=new QSPHashMap[m];
		this.givenDataSet=dataSet;
		obtainHashFunction();
		storeEntries();
	}
	
	
	//03_INTERFACE METHODS
	//*************************************************
	public String get(int key) {
		int index=runHashFunction(key);
		String result=primaryTable[index].get(key);
		if(result==null){
			return null;
		}
		return result;
	}
	
	
	//04_PRIVATE METHODS
	//*************************************************
	private int runHashFunction(int key){
		int index=((a*key+b)%p)%m;
		return index;
	}

	//****************************
	private void obtainHashFunction(){
		//00_try different combinations of hash functions
		for(int hashFunction=1; hashFunction<=100; hashFunction++){
			//01_generate new hash function
			a=1; b=2; p=23;
			//02_determine the # of collisions for this hash function
			boolean isGoodFunction=true;
			int maxAllowedCollisions=(m*m)/2;
			Integer[] indexTable=new Integer[m];
			for(Entry element:givenDataSet){
				int index=runHashFunction(element.getKey());
				if(indexTable[index]==null){
					indexTable[index]=0;
				}else {
					indexTable[index]++;
					if(indexTable[index]>maxAllowedCollisions){
						isGoodFunction=false;
						break;
					}
				}
			}
			//03_decide if hash function is good or not
			if(isGoodFunction==true){
				break;
			}
		}
	}
	
	//****************************
	private void storeEntries(){
		
		@SuppressWarnings("unchecked")
		LinkedList<Entry> tmpData[]=new LinkedList[m];
		for(Entry element:givenDataSet){
			int index=runHashFunction(element.getKey());
			if(tmpData[index]==null){
				tmpData[index]=new LinkedList<Entry>();
			}
			tmpData[index].addLast(element);
		}
		for(int i=1; i<=m; i++){
			LinkedList<Entry> cell=tmpData[i-1];
			if(cell==null){
				continue;
			}
			Entry[] cellArray=cell.toArray(new Entry[cell.size()]);
			primaryTable[i-1]=new QSPHashMap(cellArray);
		}
		
	}
	
	
	
	
}
