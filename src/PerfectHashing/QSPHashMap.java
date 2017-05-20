package PerfectHashing;


//QSP stands for Quadratic-Space Perfect HashMap
public class QSPHashMap {

	//01_ATTRIBUTES
	//*************************************************
	private Entry dataTable[];
	private Entry givenDataSet[];
	private int a,b,p,m; //Hash Function = ((ax+b)mod p)mod m
	

	//02_CONSTRUCTOR
	//*************************************************
	public QSPHashMap(Entry dataSet[]){
		m=dataSet.length*dataSet.length;
		dataTable=new Entry[m];
		this.givenDataSet=dataSet;
		
		obtainHashFunction();
		storeEntries();
		
	}

	//03_INTERFACE METHODS
	//*************************************************
	public String get(int key) {
		int index=runHashFunction(key);
		Entry result=dataTable[index];
		if(result==null){
			return null;
		}
		return result.getValue();
	}
	
	//04_INTERNAL METHODS
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
			int numOfCollisions=0;
			Integer[] indexTable=new Integer[m];
			for(Entry element:givenDataSet){
				int index=runHashFunction(element.getKey());
				if(indexTable[index]==null){
					indexTable[index]=index;
				}else{
					numOfCollisions=1;
					break;
				}
			}
			//03_decide if hash function is good or not
			if(numOfCollisions==0){
				break;
			}
		}
	}
	
	//****************************
	private void storeEntries(){
		for(Entry element:givenDataSet){
			int index=runHashFunction(element.getKey());
			dataTable[index]=element;
		}
	}
	
	
	
	
	
	
	
}
