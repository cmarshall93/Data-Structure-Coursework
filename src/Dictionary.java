import java.util.ArrayList;
import java.util.HashMap;


public class Dictionary {

	private HashMap<String, DictionaryEntry> tradChineseMap;
	private HashMap<String, DictionaryEntry> simpChineseMap;
	private HashMap<String, ArrayList<DictionaryEntry>> pinyinMap;
	private HashMap<String, ArrayList<DictionaryEntry>> englishMap;

	public Dictionary(){
		tradChineseMap = new HashMap<String, DictionaryEntry>();
		simpChineseMap = new HashMap<String, DictionaryEntry>();
		pinyinMap = new HashMap<String, ArrayList<DictionaryEntry>>();
		englishMap = new HashMap<String, ArrayList<DictionaryEntry>>();
	}

	public void addTradChinese(String key, DictionaryEntry entry){
		tradChineseMap.put(key, entry);
	}

	public void addSimpleChinese(String key, DictionaryEntry entry){
		simpChineseMap.put(key, entry);
	}

	public void addPinyin(String key, DictionaryEntry entry){
		String lowerKey = key.toLowerCase();
		if(pinyinMap.containsKey(lowerKey)){
			ArrayList<DictionaryEntry> entryArray = pinyinMap.remove(lowerKey);
			entryArray.add(entry);
			pinyinMap.put(lowerKey, entryArray);
		}else{
			ArrayList<DictionaryEntry> entryArray = new ArrayList<DictionaryEntry>();
			entryArray.add(entry);
			pinyinMap.put(lowerKey, entryArray);
		}

	}

	public void addEnglish(String key, DictionaryEntry entry){
		String[] keyArray = key.split("/");
		for(int i = 0; i < keyArray.length; i++){
			if(englishMap.containsKey(keyArray[i])){
				ArrayList<DictionaryEntry> entryArray = englishMap.remove(keyArray[i]);
				entryArray.add(entry);
				englishMap.put(keyArray[i], entryArray);
			}
			else{
				ArrayList<DictionaryEntry> entryArray = new ArrayList<DictionaryEntry>();
				entryArray.add(entry);
				englishMap.put(keyArray[i], entryArray);
			}
		}
	}

	public String[] search(String searchString){
		String[] array = new String[4];
		array[0] = "Traditional Chinese search : " + searchByTradChinese(searchString);
		array[1] = "Simple Chinese search : " + searchBySimpleChinese(searchString);
		array[2] = "PinYin search : " + searchByPinYin(searchString);
 		array[3] = "English search : " + searchByEnglish(searchString);
		return array;
	}

	private String searchByTradChinese(String searchString){
		DictionaryEntry searchResult = tradChineseMap.get(searchString);
		if(searchResult != null){
			return (searchResult.toString());
		}
		else{
			return "Entry not found";
		}
	}

	private String searchBySimpleChinese(String searchString){
		DictionaryEntry searchResult = simpChineseMap.get(searchString);
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
}
