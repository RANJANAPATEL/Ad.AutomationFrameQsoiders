package genericUtility;

	import java.util.Random;
	import java.text.SimpleDateFormat;
	import java.util.Date;



	/**
	 * This class consist of generic methods related to Java
	 * @author ranjanapatel
	 *
	 */

	public class JavaUtility {
		
		/**
		 * This method will generate a randon number for evevry run and return it the value
		 * @return
		 */

		public int getRandomNumber() {
		Random ran = new Random();	
				
		int r = ran.nextInt(10000);
			return r;
			

		}
		
		
		public String getSystemDate() {
			Date d = new Date();
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
				String date = formatter.format(d);
				return date;
		}


}
