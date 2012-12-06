import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Models the chinese/english dictionary.
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
		tradChineseMap = new WordMap("Traditional Chinese:");
		simpChineseMap = new WordMap("Simple Chinese: ");
		pinyinMap = new WordMap("PinYin: ");
		englishMap = new WordMap("English: ");
		prefixSet = new ArrayList<Character>();
		
		addWordMap(tradChineseMap);
		addWordMap(simpChineseMap);
		addWordMap(pinyinMap);
		addWordMap(englishMap);
	}

	public void addTradChinese(String key, DictionaryEntry entry){
		tradChineseMap.put(key, entry);
	}

	public void addSimpleChinese(String key, DictionaryEntry entry){
		simpChineseMap.put(key, entry);
	}

	public void addPinyin(String key, DictionaryEntry entry){
		String lowerKey = key.toLowerCase();
		lowerKey = lowerKey.replace("[", "");
		lowerKey = lowerKey.replace("]", "");
		lowerKey.trim();
		pinyinMap.put(lowerKey, entry);
	}

	public void addEnglish(String key, DictionaryEntry entry){
		String[] keyArray = key.split("/");
		for(int i = 0; i < keyArray.length; i++){
			englishMap.put(keyArray[i], entry);
		}
	}
	
	public void addPrefix(char prefix) {
		prefixSet.add(prefix);
	}

	public String getStats(){
		String result = "Dictionary Statistics";
		for(int i = 0; i < getWordMapsSize(); i++){
			result += "\nNumber of " + getWordMap(i).getDesc() + " words : " + getWordMap(i).size();
		}
		result += "\nNumer of prefixs : " + prefixSet.size();
		return result;
	}

	@Override
	public String search(String dictToSearch, String searchString) {
		/*String[] array = new String[getWordMapsSize() + 1];
		for(int i = 0; i < getWordMapsSize(); i++){
			array[i] = "Search by " + getWordMap(i).getDesc() + getWordMap(i).search(searchString);
		}
		array[getWordMapsSize()] = "Search by prefix: " + searchByPrefix(searchString);
		return array;*/
		String result = "";
		if(dictToSearch.equals("/trad")){
			result = tradChineseMap.search(searchString);
		}
		else if(dictToSearch.equals("/simp")){
			result = simpChineseMap.search(searchString);
		}
		else if(dictToSearch.equals("/pin")){
			result = pinyinMap.search(searchString);
		}
		else if(dictToSearch.equals("/eng")){
			result = englishMap.search(searchString);
		}
		else if(dictToSearch.equals("/pre")){
			result = searchByPrefix(searchString);
		}
		else{
			result = "Command not recognised";
		}
		return result;
	}

	private String searchByPrefix(String prefix){
		String result = "";
		for(DictionaryEntry de : tradChineseMap.getValues()){
			String s = de.getTradChinese();
			if(s.startsWith(prefix)){
				result += "\n \t" + tradChineseMap.get(s);
			}
		}
		if(result != ""){
			return result;
		}
		else{
			return "No entries found";
		}
	}
	
	public String getSearchCommands(){
		String s = "/trad : search traditional chinese";
		s += "\n/simp : search simple chinese";
		s += "\n/pin :  search pinyin";
		s += "\n/eng : search english defeniton.";
		s += "\n/pre : search prefix";
		s += "\nFor example : \"/eng sorrow\" will search for english definitions matching sorrow";
		return s;
	}
}
