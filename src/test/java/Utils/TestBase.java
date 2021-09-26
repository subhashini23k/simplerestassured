package Utils;
	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	public class TestBase {
		public static Properties Properties;
		
		public static void init(){
			Properties = new Properties();
			try {
				FileInputStream ip = new FileInputStream("C:\\Users\\lvpy9\\eclipse-workspace\\SimpleRest\\src\\test\\java\\Utils\\config.properties");
				Properties.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
			
		}	

	}


