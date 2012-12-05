
import java.util.AbstractMap;
import java.util.ArrayList;


public abstract class AbstractDictionary {
	
	private ArrayList<WordMap> wordMaps;
	
	public AbstractDictionary(){
		wordMaps = new ArrayList<WordMap>();
	}
	
	public abstract String[] search(String searchString);
	
	public abstract String getStats();
	
	protected void addWordMap(WordMap wordMap){
		wordMaps.add(wordMap);
	}
	
	protected WordMap getWordMap(int i){
		return wordMaps.get(i);
	}
	
	protected int getWordMapsSize(){
		return wordMaps.size();
	}
	
}