import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Driver {

	private static final String inputFile1 = "input1.txt";
	private static final String inputFile2 = "input2.txt";

	public Driver() throws IOException {
		new PM(initilizePMseg(),initilizePMpage());
		
	}
	
	private static int[] initilizePMseg() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(inputFile1));
		String line = "";
		line = reader.readLine();
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(line);
		int numOfWhiteSpace = line.length() - line.replaceAll(" ", "").length();
		int[] segTable = new int[numOfWhiteSpace + 1];
		int counter = 0;
		while (m.find()) {
			segTable[counter] = Integer.parseInt(m.group());
			counter++;
		}
		return segTable;
	}
	
	private static int[] initilizePMpage() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(inputFile1));
		String line = "";
		reader.readLine();
		line = reader.readLine();
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(line);
		int numOfWhiteSpace = line.length() - line.replaceAll(" ", "").length();
		int[] pageTable = new int[numOfWhiteSpace + 1];
		int counter = 0;
		while (m.find()) {
			pageTable[counter] = Integer.parseInt(m.group());
			counter++;
		}
		return pageTable;
	}
	
	public static void main(String[] args) throws IOException {
		new Driver();
	}

}
