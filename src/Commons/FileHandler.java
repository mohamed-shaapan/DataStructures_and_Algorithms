package Commons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

	public static void main(String args[]){
		
		try {
			openFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}


	public static double[] openFile() throws FileNotFoundException{
		
		String fileName="TestCase_Rep.txt";
		
		File srcFile=new File(fileName);
		ArrayList<Double> tmp=new ArrayList<Double>();
		//open file
		Scanner fileReader=new Scanner(srcFile);
		//read from file
		while(fileReader.hasNext()){
			double number=fileReader.nextDouble();
			tmp.add(new Double(number));
			//System.out.println(number);
		}
		//close file
		fileReader.close();	
		
		double[] result=new double[tmp.size()];
		for(int i=1; i<=result.length; i++){
			result[i-1]=tmp.get(i-1);
		}
		
		//for(double number:result){
		//	System.out.println(number);
		//}
		
		return result;
		
	}
	
	
	public static void writeData(double[] data) throws FileNotFoundException{
		File file=new File("result.txt");
		//open file
		PrintWriter fileWriter=new PrintWriter(file);
		//write to file
		for(double number:data){
			fileWriter.println(number);
		}
		//close file
		fileWriter.close();
	}



}
