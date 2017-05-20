package PerfectHashing;

public class Entry {
	
	//01_ATTRIBUTES
	//*************************************************
	private int key;
	private String value;
	
	
	//02_CONSTRUCTOR
	//*************************************************
	public Entry(){
		
	}
	
	public Entry(int key, String value){
		this.key=key;
		this.value=value;
	}


	//03_METHODS
	//*************************************************
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
