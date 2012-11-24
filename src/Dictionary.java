import java.util.HashMap;


public class Dictionary {

	private HashMap<String, DictionaryEntry> tradChineseMap;
	private HashMap<String, DictionaryEntry> simpChineseMap;
	private HashMap<String, DictionaryEntry> pinyinMap;
	private HashMap<String, DictionaryEntry> englishMap;
	
	public Dictionary(){
		tradChineseMap = new HashMap<String, DictionaryEntry>();
		simpChineseMap = new HashMap<String, DictionaryEntry>();
		pinyinMap = new HashMap<String, DictionaryEntry>();
		englishMap = new HashMap<String, DictionaryEntry>();
	}
	
	public void addTradChinese(String key, DictionaryEntry entry){
		tradChineseMap.put(key, entry);
	}
	
	public void addSimpleChinese(String key, DictionaryEntry entry){
		simpChineseMap.put(key, entry);
	}
	
	public void addPinyin(String key, DictionaryEntry entry){	
		pinyinMap.put(key, entry);
	}
	
	public void addEnglish(String key, DictionaryEntry entry){
		englishMap.put(key, entry);
	}
}
