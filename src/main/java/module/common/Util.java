package module.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Util {
	private Properties prop = new Properties();
	private String FILENAME = "connection.properties";
	private String ITEMS = "items";
	private String PRODUCT_RESPONSE="product_composite_response";
	private String PRODUCT_DESCRIPTION="general_description";
	private static Util m_instance = new Util();
	private Util(){
	}
	public static Util getInstance() {
		return m_instance;
	}

	public Properties readFile() throws IOException{
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(FILENAME).getFile());
		InputStream in = new FileInputStream(file);
		prop.load(in);
		return prop;
	}
	
	public String jsonParsor(String output){
		String prodName="";
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject) parser.parse(output);
			JSONObject prodObject = (JSONObject) jsonObject.get(PRODUCT_RESPONSE);
			JSONArray items= (JSONArray) prodObject.get(ITEMS);
			for(Object item : items){
				JSONObject itemObj = (JSONObject) item;
				prodName = (String) itemObj.get(PRODUCT_DESCRIPTION);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		return prodName;
	}
}
