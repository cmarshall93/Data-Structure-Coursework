import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads the csv file and builds a Dictionary object from the entries in the file.
 * 
 * @author Charles Marshall - marshac3
 *
 */

public class ChineseDictionaryReader implements AbstractDictionaryReader {

	private File dictFile;
	private BufferedReader reader;

	public ChineseDictionaryReader(){
		dictFile = new File("cedict_ts_u8.csv");
		try {
			reader = new BufferedReader(new FileReader(dictFile));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find dictionary file");
		}
	}

	public AbstractDictionary buildDictionary() {
		ChineseDictionary dict = new ChineseDictionary();
		System.out.println("Reading dictionary file and building dictionary ");
		String line;
		try {
			int i = 0;
			while((line = reader.readLine()) != null){
				String[] array = line.split("\t"); //split the line into separate parts based on where a 'TAB' is
				if(array.length == 4){
					DictionaryEntry entry = new DictionaryEntry(array);
					dict.addTradChinese(entry.getTradChinese(), entry);
					dict.addSimpleChinese(entry.getSimpleChinese(), entry);
					dict.addPinyin(entry.getPinYin(), entry);
					dict.addEnglish(entry.getEnglish(), entry);
					dict.addPrefix(entry.getTradChinese().charAt(0));
				}
				else{
					System.out.println("Entry on line " + i + " does not have four parts, skipping entry.");
				}
				i++;
			}
		} catch (IOException e) {
		}
		System.out.println("Finished reading file and bulding dictionary");
		return dict;
	}

}
