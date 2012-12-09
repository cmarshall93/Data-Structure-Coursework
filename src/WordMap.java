import java.util.ArrayList;
import java.util.HashMap;

/**
 * Models a map between search words and their respective dictionaryEntry's
 * 
 * @author Charles Marshall - marshac3
 *
 */
public class WordMap {

	private HashMap<String, ArrayList<DictionaryEntry>> map;
	private String description;
	
	/**
	 * Constructor
	 * @param desc	description of the wordMap.
	 */
	public WordMap(String desc){
		map = new HashMap<String, ArrayList<DictionaryEntry>>();
		description = desc;
	}

	/**
	 * Adds a key, dictionary entry pair to the wordMap.
	 * 
	 * @param key	search entry to be used as a key to obtain the relevant dictionary entries.
	 * @param entry	dictionaryEntry to be associated with the given key.
	 */
	public void put(String key, DictionaryEntry entry){
		if(map.containsKey(key)){
			ArrayList<DictionaryEntry> entryArray = map.remove(key);
			entryArray.add(entry);
			map.put(key, entryArray);
		}else{
			ArrayList<DictionaryEntry> entryArray = new ArrayList<DictionaryEntry>();
			entryArray.add(entry);
			map.put(key, entryArray);
		}
	}
	
	/**
	 * Searches the wordMap for dictionary entires based on the key given.
	 * 
	 * @param searchString	key that is to be searched for.
	 * @return	results of search.
	 */
	public String search(String searchString){
		ArrayList<DictionaryEntry> searchResult = map.get(searchString);
		if(searchResult != null){
			String resultString = "";
			for(DictionaryEntry e: searchResult){
				resultString += ("\n \t" + e.toString());
			}
			return resultString;
		}
		return "No entries not found" ;
	}
	
	/**
	 * Returns an array list of all the dictionary entries associated with the given key.
	 * 
	 * @param key	key to use to retreive results.
	 * @return	list of all dictionary entries related to the given key.
	 */
	public ArrayList<DictionaryEntry> get(String key){
		return map.get(key);
	}
	
	/**
	 * Returns all of the dictionary entries currently in the wordMap.
	 * 
	 * @return	all the dictionary entries in the wordMap.
	 */
	public ArrayList<DictionaryEntry> getValues(){
		ArrayList<DictionaryEntry> values = new ArrayList<DictionaryEntry>();
		for(ArrayList<DictionaryEntry> a: map.values()){
			values.addAll(a);
		}
		return values;
	}
	
	/**
	 * Returns the number of keys in the wordMap. 
	 * 
	 * @return size of the hashmap used to store the entries.
	 */
	public int size(){
		return map.size();
	}

	/**
	 * Returns the description of the wordMap.
	 * 
	 * @return	description of the wordMap.
	 */
	public String getDesc(){
		return description;
	}
}
