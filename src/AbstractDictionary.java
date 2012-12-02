
import java.util.AbstractMap;
import java.util.ArrayList;


public abstract class AbstractDictionary {
	
	private ArrayList<WordMap> wordMaps;
	
	public AbstractDictionary(){
		wordMaps = new ArrayList<WordMap>();
	}
	
	protected void addWordMap(WordMap wordMap){
		wordMaps.add(wordMap);
	}
	
}
