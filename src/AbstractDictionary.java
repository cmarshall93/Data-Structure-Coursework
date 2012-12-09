
import java.util.AbstractMap;
import java.util.ArrayList;
/**
 * Models a dictionary, which is a collection of wordMaps.
 * 
 * 
 * @author Charles Marshall - marshac3
 *
 */
public abstract class AbstractDictionary {
	
	private ArrayList<WordMap> wordMaps;
	/**
	 * Constructor
	 */
	public AbstractDictionary(){
		wordMaps = new ArrayList<WordMap>();
	}
	
	/**
	 * 
	 * @param dictToSearch	The dictionary(represented as a command) that is to be searched .
	 * @param searchString	Word that is being searched for.
	 * @return		Results of the search.
	 */
	public abstract String search(String dictToSearch, String searchString);
	
	/**
	 * 
	 * @return		return the commands that can be used to search the dictionary.
	 */
	public abstract String getSearchCommands();
	
	/**
	 * 
	 * @return 	Statistics of the dictionary.
	 */
	public abstract String getStats();
	
	/**
	 * 
	 * @param wordMap	wordMap to be added to the collection of wordMaps.
	 */
	protected void addWordMap(WordMap wordMap){
		wordMaps.add(wordMap);
	}
	
	/**
	 * 
	 * @param i The index of the the wordMap collection to return.
	 * @return	wordMap at specified index.
	 */
	protected WordMap getWordMap(int i){
		return wordMaps.get(i);
	}
	
	/**
	 * 
	 * @return		size of the the wordMap collection.
	 */
	protected int getWordMapsSize(){
		return wordMaps.size();
	}
	
}
