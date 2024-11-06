package com.crm.generic.fileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONUtility {

	public String getDataFromJSONFile(String key) throws IOException, Throwable {
		
		FileReader f=new FileReader("./ConfigAppData/commonData.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(f);
		JSONObject jsonObj=(JSONObject) obj;
		String value = jsonObj.get(key).toString();
		return value;
	}
}
