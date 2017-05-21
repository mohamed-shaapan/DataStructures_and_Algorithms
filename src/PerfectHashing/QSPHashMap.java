package PerfectHashing;

import java.util.Random;

//QSP stands for Quadratic-Space Perfect HashMap
public class QSPHashMap {

	// 01_ATTRIBUTES
	// *************************************************
	private Entry dataTable[];
	private Entry givenDataSet[];
	private int a, b, p, m; // Hash Function = ((ax+b)mod p)mod m

	// 02_CONSTRUCTOR
	// *************************************************
	public QSPHashMap(Entry dataSet[]) {
		// hash function parameters
		m = dataSet.length * dataSet.length;
		p = generateNextPrime(2 * m);

		//System.out.println(m);
		// initialize hash table
		dataTable = new Entry[m];
		this.givenDataSet = dataSet;

		// construct hash table
		obtainHashFunction();
		storeEntries();

	}

	// 03_INTERFACE METHODS
	// *************************************************
	public String get(int key) {
		int index = runHashFunction(key);
		if((index>=dataTable.length)||(index<0)){
			return null;
		}
		Entry result = dataTable[index];
		if (result == null) {
			return null;
		}
		return result.getValue();
	}

	// 04_INTERNAL METHODS
	// *************************************************
	private int runHashFunction(int key) {
		int index = ((a * key + b) % p) % m;
		return index;
	}

	private void generateHashFunction() {
		// m = givenDataSet.length;
		// p=generateNextPrime(m);
		Random rand = new Random();
		a = rand.nextInt(p)+1;
		a = Math.abs(a);
		//a = 100*a*a-60*a+300;
		
		b = rand.nextInt(p)+1;
		b = Math.abs(b);
		//b = 100*b*b-60*b+300;
	}
	
	@SuppressWarnings("unused")
	private void printHashFunction(){
		System.out.println("/**************************");
		System.out.println("m : "+m);
		System.out.println("p : "+p);
		System.out.println("a : "+a);
		System.out.println("b : "+b);
		
	}

	// ****************************
	private void obtainHashFunction() {
		// 00_try different combinations of hash functions
		boolean hashFunctionFound = false;
		while (hashFunctionFound == false) {
			// 01_generate new hash function
			generateHashFunction();
			//printHashFunction();
			// 02_determine the # of collisions for this hash function
			int numOfCollisions = 0;
			Integer[][] testTable = new Integer[m][2];
			//first column indicates number of collisions
			//second column gives the value of the stored key
			for (Entry element : givenDataSet) {
				int index = runHashFunction(element.getKey());
				//System.out.println(index);
				if (testTable[index][0] == null) {
					testTable[index][0] = 0;
					testTable[index][1] = element.getKey();
				} else {
					if(testTable[index][1]==element.getKey()){
						continue;
					}
					numOfCollisions+=1;
					break;
					/*testTable[index][0]+=1;
					if(testTable[index][0]>numOfCollisions){
						numOfCollisions=testTable[index][0];
					}*/
				}
			}
			// 03_decide if hash function is good or not
			if (numOfCollisions < 1) {
				hashFunctionFound=true;
			}
		}
		
		//printHashFunction();
		//System.out.println("SUCCESS");
		

	}

	// ****************************
	private void storeEntries() {
		for (Entry element : givenDataSet) {
			int index = runHashFunction(element.getKey());
			dataTable[index] = element;
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
