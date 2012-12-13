package marshac3.dictionary.structure;
/**
 * Represents an entry in the dictionary. Contains the traditional chinese spelling, simple chinese spelling, 
 * pinyin and english meaning of a word.
 * 
 * @author Charles Marshall -  marshac3
 *
 */
public class DictionaryEntry {

	private String tradChinese;
	private String simpleChinese;
	private String pinyin;
	private String english;
	
	/**
	 * Constructor
	 * @param array entry read from file that has been split into four parts.
	 */
	public DictionaryEntry(String[] array){
		tradChinese = array[0];
		simpleChinese = array[1];
		pinyin = array[2];
		english = array[3];
	}
	
	/**
	 * get the traditional chinese part of the dictionary entry.
	 * @return	traditional chinese.
	 */
	public String getTradChinese(){
		return tradChinese;
	}
	
	/**
	 * get the simple chinese part of the dictionary entry.
	 * @return	simple chinese
	 */
	public String getSimpleChinese(){
		return simpleChinese;
	}
	
	/**
	 * get the pinyin part of the dictionary entry.
	 * @return	pinyin
	 */
	public String getPinYin(){
		return pinyin;
	}
	
	/**
	 * get the english part of the dictionary entry.
	 * @return	english
	 */
	public String getEnglish(){
		return english;
	}
	
	/**
	 * get this dictionary entry as a string.s
	 * 
	 * @return string representation of dictionary entry
	 */
	public String toString(){
		return (tradChinese + " : " + simpleChinese + " : " + pinyin + " : " + english);
	}
}
