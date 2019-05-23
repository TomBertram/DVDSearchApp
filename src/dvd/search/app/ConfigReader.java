import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ConfigReader {
 String result = "";
 InputStream inputStream;
 public String getPropValues() throws IOException {
 try {
 Properties prop = new Properties();
 String propFileName = "config.properties";
 inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 if (inputStream != null) {
 prop.load(inputStream);
 } else {
 throw new FileNotFoundException("property file '" + propFileName + "' not found.");
 }
 // get the property value and print it out
 String db = prop.getProperty("database");
 String version = prop.getProperty("version");
 String date = prop.getProperty("date_published");
 String lang = prop.getProperty("lang");
 result = "Properties list = " + db + ", " + version + ", " + date + ", " + lang;
 System.out.println(result);
 } catch (IOException ex) {
 System.out.println("Exception: " + ex);
 }
 return result;
 }
}