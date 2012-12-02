import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Models the chinese/english dictionary. Holds the word maps and handles the searching of those maps.
 * 
 * @author Charles Marshall - marshac3
 *
 */

public class ChineseDictionary extends AbstractDictionary {

	private WordMap tradChineseMap;
	private WordMap simpChineseMap;
	private WordMap pinyinMap;
	private WordMap englishMap;
	private ArrayList<Character> prefixSet;

	public ChineseDictionary(){
		tradChineseMap = new WordMap();
		simpChineseMap = new WordMap();
		pinyinMap = new WordMap();
		englishMap = new WordMap();
		prefixSet = new ArrayList<Character>();

	}

	public void addTradChinese(String key, DictionaryEntry entry){
		tradChineseMap.put(key, entry);
	}

	public void addSimpleChinese(String key, DictionaryEntry entry){
		simpChineseMap.put(key, entry);
	}

	public void addPinyin(String key, DictionaryEntry entry){
		String lowerKey = key.toLowerCase();
		pinyinMap.put(lowerKey, entry);
	}

	public void addEnglish(String key, DictionaryEntry entry){
		String[] keyArray = key.split("/");
		for(int i = 0; i < keyArray.length; i++){
			englishMap.put(keyArray[i], entry);
		}
	}
	
	public void addPrefix(Character c){
		prefixSet.add(c);
	}

	public String[] search(String searchString){
		String[] array = new String[5];
		array[0] = "Traditional Chinese search : " + searchByTradChinese(searchString);
		array[1] = "Simple Chinese search : " + searchBySimpleChinese(searchString);
		array[2] = "PinYin search : " + searchByPinYin(searchString);
 		array[3] = "English search : " + searchByEnglish(searchString);
 		//array[4] = "Prefix search : " + searchByPrefix(searchString);
		return array;
	}
	
	public String getStats(){
		String result = "Dictionary Statistics";
		result += "\n Number of traditional chinese words : " + tradChineseMap.size();
		result += "\n Number of simple chinese words : " + simpChineseMap.size();
		result += "\n Number of PinYin : " + pinyinMap.size();
		result += "\n Number of english meanings : " + englishMap.size();
		result += "\n Number of prefixes : " + prefixSet.size();
		return result;
	}

	private String searchByTradChinese(String searchString){
		ArrayList<DictionaryEntry> searchResult = tradChineseMap.get(searchString);
		if(searchResult != null){
			return (searchResult.toString());
		}
		else{
			return "Entry not found";
		}
	}

	private String searchBySimpleChinese(String searchString){
		ArrayList<DictionaryEntry> searchResult = simpChineseMap.get(searchString);
		if(searchResult != null){
			return (searchResult.toString());
		}
		else{
			return "Entry not found";
		}
	}

	private String searchByPinYin(String searchString){
		ArrayList<DictionaryEntry> searchResult = pinyinMap.get(searchString);
		if(searchResult != null){
			String result = "";
			for(DictionaryEntry e: searchResult){
				result += ("\n \t " + e.toString());
			}
			return result;
		}
		return "No entries found";
	}
	
	private String searchByEnglish(String searchString){
		ArrayList<DictionaryEntry> searchResult = englishMap.get(searchString);
		if(searchResult != null){
			String resultString = "";
			for(DictionaryEntry e: searchResult){
				resultString += ("\n \t" + e.toString());
			}
			return resultString;
		}
		return "No entries not found" ;
	}
	
	/**private String searchByPrefix(String prefix){
		String result = null;
		for(String s : tradChineseMap.keySet()){
			if(s.startsWith(prefix)){
				result += "\n \t" + tradChineseMap.get(s);
			}
		}
		if(result != null){
			return result;
		}
		else{
			return "No entries found";
		}
	}*/
}
