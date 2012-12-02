import java.util.ArrayList;
import java.util.HashMap;


public class WordMap {

	private HashMap<String, ArrayList<DictionaryEntry>> map;

	public WordMap(){
		map = new HashMap<String, ArrayList<DictionaryEntry>>();
	}

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
	
	public ArrayList<DictionaryEntry> get(String key){
		return map.get(key);
	}
	
	public int size(){
		return map.size();
	}

}
