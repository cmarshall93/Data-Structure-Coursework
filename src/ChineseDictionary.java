import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
	private int prefixes;

	/**
	 * Constructor. Sets up relevant wordMaps and adds them to the wordMap collection.
	 */
	public ChineseDictionary(){
		tradChineseMap = new WordMap("Traditional Chinese:");
		simpChineseMap = new WordMap("Simple Chinese: ");
		pinyinMap = new WordMap("PinYin: ");
		englishMap = new WordMap("English: ");
		prefixes = 0;
		
		addWordMap(tradChineseMap);
		addWordMap(simpChineseMap);
		addWordMap(pinyinMap);
		addWordMap(englishMap);
	}

	/**
	 * Add an entry to the traditional Chinese wordMap.
	 * 
	 * @param key	key, word that the user searches by.
	 * @param entry		dictionaryEntry associated with the key.
	 */
	public void addTradChinese(String key, DictionaryEntry entry){
		tradChineseMap.put(key, entry);
	}
	
	/**
	 * Add an entry to the simple Chinese wordMap.
	 * 
	 * @param key	key, word that the user searches by.
	 * @param entry		dictionaryEntry associated with the key.
	 */
	public void addSimpleChinese(String key, DictionaryEntry entry){
		simpChineseMap.put(key, entry);
	}

	/**
	 * Add an entry to the PinYin wordMap.
	 * 
	 * @param key	key, word that the user searches by.
	 * @param entry		dictionaryEntry associated with the key.
	 */
	public void addPinyin(String key, DictionaryEntry entry){
		String lowerKey = key.toLowerCase();
		lowerKey = lowerKey.replace("[", "");
		lowerKey = lowerKey.replace("]", "");
		lowerKey.trim();
		pinyinMap.put(lowerKey, entry);
	}

	/**
	 * Add an entry to the english wordMap.
	 * 
	 * @param key	key, word that the user searches by.
	 * @param entry		dictionaryEntry associated with the key.
	 */
	public void addEnglish(String key, DictionaryEntry entry){
		/*
		 * For each word in the english section of the entry, create a new string.
		 */
		String[] keyArray = key.split("/");
		for(int i = 0; i < keyArray.length; i++){
			englishMap.put(keyArray[i], entry);
		}
	}

	@Override
	public String getStats(){
		String result = "Dictionary Statistics";
		for(int i = 0; i < getWordMapsSize(); i++){
			result += "\nNumber of " + getWordMap(i).getDesc() + " words : " + getWordMap(i).size();
		}
		result += "\nNumer of prefixes : " + prefixes;
		return result;
	}
/**
	 * Counts the number of traditional Chinese prefixes. This is method is broken and is only 
	 * included to provide an insight of how I was going to implement this requirement.
	 */
	public void countPrefixes(){
		//create a new ArrayList containing all the traditional chinese keys.
		ArrayList<String> keyList= tradChineseMap.getKeys();
		//sort the list of keys alphabetically.
		Collections.sort(keyList);
		//create a temporary HashSet to keep track of all the prefixes already found
		HashSet<String> prefixSet = new HashSet<String>();
		/*
		 *Go through every key. 
		 */
		for(int i = 0; i < keyList.size(); i++){
			boolean finished = false;
			String pre = keyList.get(i);
			/*
			 * Go through every element that appears after the current and check to see
			 * if the current element is a prefix to them. A prefix can only be a prefix to 
			 * words that appear it in the alphabet. When a word is reached that the current 
			 * element is not a prefix of, then the secondary loop is exited.
			 */
			for(int n = i;n < keyList.size() && !finished; n++){
				String word = keyList.get(n);
				//check word starts with prefix and prefix has not already been found
				if(word.startsWith(pre) && !prefixSet.contains(pre)){
					prefixes++;//increase number of prefixes identified.
					prefixSet.add(pre);
				}
				else{
					finished = true;
				}
			}
		}
	}

	/**
	 * Search the dicionary for the given word/phrase
	 * 
	 * @param dictToSearch the dictionary command to choose which wordmap is being searched
	 * @param searchString	the string that is being searched for
	 * @return the result of the search
	 */
	@Override
	public String search(String dictToSearch, String searchString) {
		String result = "";
		if(dictToSearch.equals("/trad")){				//check command
			result = tradChineseMap.search(searchString);
		}
		else if(dictToSearch.equals("/simp")){			//check command
			result = simpChineseMap.search(searchString);
		}
		else if(dictToSearch.equals("/pin")){			//check command
			result = pinyinMap.search(searchString);
		}
		else if(dictToSearch.equals("/eng")){			//check command
			result = englishMap.search(searchString);
		}	
		else if(dictToSearch.equals("/pre")){			//check command
			result = searchByPrefix(searchString);
		}
		else{
			result = "Command not recognised";
		}
		return result;
	}

	/**
	 * Searches the traditional Chinese wordMap for the given prefix.
	 * 
	 * @param prefix	prefix to search by.
	 * @return			result of search.
	 */
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
	
	/**
	 * Return a list of commands related to this dictionary.
	 * 
	 * @return list of commands
	 */
	@Override
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
