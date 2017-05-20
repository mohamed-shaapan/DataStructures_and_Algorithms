package HashTables;


public class HashTable {

	//01_ATTRIBUTES
	//*************************************************
	private Entry data[];
	private int dataSize;
	
	
	//02_CONSTRUCTOR
	//*************************************************
	public HashTable(int length){
		data=new Entry[length];
	}
	
	
	//03_PRIVATE METHODS
	//*************************************************
	private int runHashFunction(int key){
		//LOGIC GOES HERE
		return 0;
	}
	
	
	//04_INTERFACE METHODS
	//*************************************************
	public boolean put(int key, String value){
		int index=runHashFunction(key);
		Entry tmp=new Entry(key, value);
		data[index]=tmp;
		dataSize++;
		return true;
	}
	
	public String get(int key){
		int index=runHashFunction(key);
		Entry result=data[index];
		if(result==null){
			return null;
		}
		return result.getValue();
	}
	
	public String remove(int key){
		int index=runHashFunction(key);
		Entry result=data[index];
		if(result==null){
			return null;
		}
		data[index]=null;
		return result.getValue();
	}
	
	public int size(){
		return dataSize;
	}
	
	
	
	
	
	
	
	
}
