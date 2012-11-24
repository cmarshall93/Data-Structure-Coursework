
public class DictionaryProgram {

	private static DictionaryProgram instance;
	
	private DictionaryReader fileReader;
	private Dictionary dict;
	
	public static void main(String[] args){
		instance = new DictionaryProgram();
	}
	
	private DictionaryProgram(){
		dict = new Dictionary();
		fileReader = new DictionaryReader(dict);
		System.out.println("Welcome to the Chinese to English dictionary application!");
		System.out.println();
	}
}
