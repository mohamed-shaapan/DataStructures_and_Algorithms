package PerfectHashing;

import java.util.LinkedList;
import java.util.Random;

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
		
		// hash function parameters
		m=dataSet.length;
		p = generateNextPrime(2 * m);
		//System.out.println("prime : "+p);
		//System.out.println("error : "+(176047*p));
		
		// initialize hash table
		primaryTable=new QSPHashMap[m];
		givenDataSet=dataSet;
		
		// construct hash table
		
		obtainHashFunction();
		storeEntries();

	}
	
	
	//03_INTERFACE METHODS
	//*************************************************
	public String get(int key) {
		int index=runHashFunction(key);
		//System.out.println("index : "+index);
		//System.out.println("size : "+primaryTable.length);
		if((index>=primaryTable.length)||(index<0)||(primaryTable[index]==null)){
			//System.out.println("success");
			return null;
		}
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
		//return Math.abs(index);
	}
	
	private void generateHashFunction() {
		// m = givenDataSet.length;
		// p=generateNextPrime(m);
		Random rand = new Random();
		a = rand.nextInt(p)+1;
		//a = 100*a*a-60*a+300;
		
		b = rand.nextInt(p)+1;
		//b = 100*b*b-60*b+300;
	}

	//****************************
	private void obtainHashFunction(){
		//00_try different combinations of hash functions
		boolean hashFunctionFound = false;
		while (hashFunctionFound == false) {
			//01_generate new hash function
			generateHashFunction();
			//02_determine the # of collisions for this hash function
			int maxAllowedCollisions=2*m-1;
			int maxDetectedCollisions=0;
			Integer[] testTable=new Integer[m];
			for(Entry element:givenDataSet){
				int index=runHashFunction(element.getKey());
				if(index<0){
					maxDetectedCollisions=maxAllowedCollisions+1;
					break;
				}
				//System.out.println(index);
				if(testTable[index]==null){
					testTable[index]=0;
				}else {
					testTable[index]++;
					if(testTable[index]>maxDetectedCollisions){
						maxDetectedCollisions=testTable[index];
					}
					if(maxDetectedCollisions>maxAllowedCollisions){
						break;
					}
				}
			}
			//03_decide if hash function is good or not
			if(maxDetectedCollisions<maxAllowedCollisions){
				hashFunctionFound=true;
			}
		}
		System.out.println("SUCCESS");
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
	
	
	private int generateNextPrime(int start) {
		int result = start + 1;

		while (true) {
			result += 1;
			boolean primeFound = true;
			for (int i = 2; i < result; i++) {
				if (result % i == 0) {
					primeFound = false;
					break;
				}
			}
			if (primeFound == true) {
				break;
			}
		}

		return result;

	}
	
	
	
	
}
