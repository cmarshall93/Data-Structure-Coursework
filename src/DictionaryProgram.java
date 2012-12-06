import java.util.Date;
import java.util.Scanner;
/**
 * Entry point into the dictionary application.
 * 
 * @author Charles Marshall - marshac3
 *
 */

public class DictionaryProgram {

	//TODO change dictionaryReader and ChineseDictionary to their abstract types.

	private static DictionaryProgram instance;

	private Scanner inputScanner;
	private AbstractDictionaryReader fileReader;
	private AbstractDictionary dict;

	public static void main(String[] args){
		instance = new DictionaryProgram();
	}

	private DictionaryProgram(){
		inputScanner = new Scanner(System.in);
		dict = new ChineseDictionary();
		long startTime = (new Date().getTime());

		fileReader = new ChineseDictionaryReader();

		dict = fileReader.buildDictionary();
		long endTime = (new Date().getTime());
		long time = endTime - startTime;
		System.out.println("Time taken to build dictionary: " + time/1000 + " seconds");
		System.out.println("Welcome to the Chinese/English dictionary application!");
		System.out.println();

		boolean exit = false;
		while(!exit){
			String nextLine = inputScanner.nextLine(); 
			if(nextLine.equals("/exit")){
				exit = true;
			}
			else if(nextLine.equals("/stats")){
				String result = dict.getStats();
				System.out.println(result);
			}
			else if(nextLine.equals("/help")){
				System.out.println("List of Commands");
				System.out.println("/exit : quit the application");
				System.out.println("/stats : view statistics about the dictionary");
				System.out.println(dict.getSearchCommands());
			}
			else{
				String[] searchParams = nextLine.split(" ");
				if(searchParams.length == 0){
					System.out.println("Enter a command, type /help for a list");
				}
				else if(searchParams.length == 1){
					System.out.println("You didn't type a word to search");
				}
				else if(searchParams.length == 2){
					String result = dict.search(searchParams[0], searchParams[1]);
					System.out.println(result);
				}
				else{
					System.out.println("You can only search one word at a time");
				}
			}
		}
		System.out.println("Exiting");
		System.exit(0);
	}
}
