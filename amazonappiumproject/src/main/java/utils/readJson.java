package utils;

import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.amazon.helper.Helper;

/*
this class will read json properties based on the key passed in the method
 
*/
public class readJson extends Helper {

	public String readJsonData(String data)
	{
	JSONParser parser = new JSONParser();
	try {
		logger.info("Reading data from Json file");
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/data.json");
		Object obj = parser.parse(new FileReader(appDir));
		JSONObject jsonObject = (JSONObject) obj;		
		return (String) jsonObject.get(data);
	}
	catch(Exception e)
	{
		logger.error("Couldnt read data from json due to :"+e.getMessage());
		return null;
	}

}
}
