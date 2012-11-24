
public class DictionaryProgram {

	private static DictionaryProgram instance;
	
	public void main(String[] args){
		instance = new DictionaryProgram();
	}
	
	private DictionaryProgram(){
		System.out.println("Welcome to the Chinese to English dictionary application!");
	}
}
