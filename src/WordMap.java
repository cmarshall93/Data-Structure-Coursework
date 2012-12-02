import java.util.ArrayList;
import java.util.HashMap;


public class WordMap {

	private HashMap<String, ArrayList<DictionaryEntry>> map;
	private String description;
	
	public WordMap(String desc){
		map = new HashMap<String, ArrayList<DictionaryEntry>>();
		description = desc;
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
	
	public ArrayList<DictionaryEntry> get(String key){
		return map.get(key);
	}
	
	public int size(){
		return map.size();
	}

	public String getDesc(){
		return description;
	}
}
