package Testing;

import java.io.IOException;

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
		String tesFileLocation="test_cases\\test_04.txt";
		//runQuadHashTest(tesFileLocation);
		runLinearHashTest(tesFileLocation);

	}

	
	//************************************************************
	//************************************************************
	private static void runQuadHashTest(String tesFileLocation) throws IOException {

		int[] data = FileHandler.readFile(tesFileLocation);

		Entry[] keyValuePair = generateKeyValuePair(data);
		QSPHashMap hashTable = new QSPHashMap(keyValuePair);

		
		String lookup=hashTable.get(-22);
		System.out.println(lookup);
		
	}

	//************************************************************
	//************************************************************
	private static void runLinearHashTest(String tesFileLocation) throws IOException {

		int[] data = FileHandler.readFile(tesFileLocation);

		Entry[] keyValuePair = generateKeyValuePair(data);
		LSPHashMap hashTable = new LSPHashMap(keyValuePair);

		String lookup=hashTable.get(22);
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
