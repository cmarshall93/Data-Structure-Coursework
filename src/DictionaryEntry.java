
public class DictionaryEntry {

	private String tradChinese;
	private String simpleChinese;
	private String pinyin;
	private String english;
	
	public DictionaryEntry(String[] array){
		tradChinese = array[0];
		simpleChinese = array[1];
		pinyin = array[2];
		english = array[3];
	}
	
	public String getTradChinese(){
		return tradChinese;
	}
	
	public String getSimpleChinese(){
		return simpleChinese;
	}
	
	public String getPinYin(){
		return pinyin;
	}
	
	public String getEnglish(){
		return english;
	}
	
	public String toString(){
		return (tradChinese + " : " + simpleChinese + " : " + pinyin + " : " + english);
	}
}
