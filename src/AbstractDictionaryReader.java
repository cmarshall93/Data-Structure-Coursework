import java.io.BufferedReader;
import java.io.File;

/**
 * 
 * 
 * @author Charles Marshall - marshac3
 *
 */
public interface AbstractDictionaryReader {
	/**	
	 * 
	 * @return	dictionary that has been created.
	 */
	public abstract AbstractDictionary buildDictionary();
}
