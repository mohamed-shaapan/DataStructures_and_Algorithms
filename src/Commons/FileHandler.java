package Commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

	public static void main(String args[]) throws IOException {

		long startTime = System.currentTimeMillis();

		readFile("test_cases\\test_00.txt");

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime + " milli-seconds");

	}

	
	//BUFFERED READER
	//************************************************************
	public static int[] readFile(String fileDirectory) throws IOException {

		ArrayList<Integer> tmp = new ArrayList<Integer>();
		BufferedReader reader = null;

		// open file
		File file = new File(fileDirectory);
		reader = new BufferedReader(new FileReader(file));
		// read from file
		String line;
		while ((line = reader.readLine()) != null) {
			String lineValues[] = line.split(",");
			for (String value : lineValues) {
				int number = Integer.parseInt(value);
				tmp.add(number);
			}
		}
		// close file
		reader.close();

		// convert to array
		int[] result = new int[tmp.size()];
		for (int i = 1; i <= result.length; i++) {
			result[i - 1] = tmp.get(i - 1);
		}

		return result;

	}

	
	//SCANNER READER
	//****************************************************************
	public static int[] readFile2(String fileDirectory) throws FileNotFoundException {

		File srcFile = new File(fileDirectory);
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		// open file
		Scanner fileReader = new Scanner(srcFile);
		// read from file
		while (fileReader.hasNext()) {
			String line = fileReader.nextLine();
			String lineValues[] = line.split(",");
			for (String value : lineValues) {
				int number = Integer.parseInt(value);
				tmp.add(number);
			}
		}
		// close file
		fileReader.close();

		int[] result = new int[tmp.size()];
		for (int i = 1; i <= result.length; i++) {
			result[i - 1] = tmp.get(i - 1);
		}

		return result;

	}

	public static void writeData(double[] data) throws FileNotFoundException {
		File file = new File("result.txt");
		// open file
		PrintWriter fileWriter = new PrintWriter(file);
		// write to file
		for (double number : data) {
			fileWriter.println(number);
		}
		// close file
		fileWriter.close();
	}

	// ****************************************************************
	// dismiss for now
	public static double[] openFile(String fileDirectory) throws FileNotFoundException {

		// String fileName="TestCase_Rep.txt";

		File srcFile = new File(fileDirectory);
		ArrayList<Double> tmp = new ArrayList<Double>();
		// open file
		Scanner fileReader = new Scanner(srcFile);
		// read from file
		while (fileReader.hasNext()) {
			double number = fileReader.nextDouble();
			tmp.add(new Double(number));
			// System.out.println(number);
		}
		// close file
		fileReader.close();

		double[] result = new double[tmp.size()];
		for (int i = 1; i <= result.length; i++) {
			result[i - 1] = tmp.get(i - 1);
		}

		// for(double number:result){
		// System.out.println(number);
		// }

		return result;

	}

}
