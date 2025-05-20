package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	/**
	 * This method will capture the current System date in
	 * required format and return yo caller
	 * @return
	 */
	public String getSystemDate() {
		Date d= new Date();
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String dateinformat=f.format(d);
		return dateinformat;
	}
}
