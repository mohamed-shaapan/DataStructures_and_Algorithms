package Testing;

import java.io.IOException;
import java.util.Random;

import Commons.FileHandler;
import PerfectHashing.Entry;
import PerfectHashing.LSPHashMap;
import PerfectHashing.QSPHashMap;

public class HashTester {

	public static void main(String args[]) throws IOException {

		/*while(true){
			Random rand = new Random();
			int num= rand.nextInt(100)+1;
			System.out.println(num);
		}*/
		
		//runQuadHashTest();
		runLinearHashTest();

	}

	
	//************************************************************
	//************************************************************
	private static void runQuadHashTest() throws IOException {

		int[] data = FileHandler.readFile("test_cases\\test_02.txt");

		Entry[] keyValuePair = generateKeyValuePair(data);
		QSPHashMap hashTable = new QSPHashMap(keyValuePair);

		
		String lookup=hashTable.get(22);
		System.out.println(lookup);
		
	}

	//************************************************************
	//************************************************************
	private static void runLinearHashTest() throws IOException {

		int[] data = FileHandler.readFile("test_cases\\test_03.txt");

		Entry[] keyValuePair = generateKeyValuePair(data);
		LSPHashMap hashTable = new LSPHashMap(keyValuePair);

		String lookup=hashTable.get(-15);
		System.out.println(lookup);
		
	}

	
	
	//************************************************************
	//************************************************************
	private static Entry[] generateKeyValuePair(int[] data) {
		Entry result[] = new Entry[data.length];

		for (int i = 1; i <= data.length; i++) {
			int key = data[i - 1];
			String value = key + "";
			result[i - 1] = new Entry(key, value);
		}

		return result;
	}

}
