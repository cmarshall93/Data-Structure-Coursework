import java.util.Date;
import java.util.Scanner;


public class DictionaryProgram {

	private static DictionaryProgram instance;

	private Scanner inputScanner;
	private DictionaryReader fileReader;
	private Dictionary dict;

	public static void main(String[] args){
		instance = new DictionaryProgram();
	}

	private DictionaryProgram(){
		inputScanner = new Scanner(System.in);
		dict = new Dictionary();
		long startTime = (new Date().getTime());
		fileReader = new DictionaryReader(dict);
		long endTime = (new Date().getTime());
		long time = endTime - startTime;
		System.out.println("Time taken to build dictionary: " + time/1000 + " seconds");
		System.out.println("Welcome to the Chinese/English dictionary application!");
		System.out.println();

		boolean exit = false;
		while(!exit){
			String nextLine = inputScanner.nextLine(); 
			if(nextLine.equals("exit")){
				exit = true;
			}
			else{
				String[] results = dict.search(nextLine);
				for(int i = 0; i < results.length; i++){
					System.out.println(results[i]);
				}
			}
		}
		System.out.println("Exiting");
		System.exit(0);
	}
}
