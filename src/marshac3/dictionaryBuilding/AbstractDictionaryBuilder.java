package marshac3.dictionaryBuilding;
import java.io.BufferedReader;
import java.io.File;

import marshac3.dictionary.AbstractDictionary;

/**
 * Models an abstractDictionaryBuilder.
 * 
 * @author Charles Marshall - marshac3
 *
 */
public interface AbstractDictionaryBuilder {
	/**	
	 * 
	 * @return	dictionary that has been created.
	 */
	public abstract AbstractDictionary buildDictionary();
}
