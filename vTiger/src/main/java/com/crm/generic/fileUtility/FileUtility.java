package com.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertyFile(String key) throws Throwable {

		FileInputStream fisP = new FileInputStream("./src/test/resources/commonData.properties");
		Properties p = new Properties();
		p.load(fisP);
		String value = p.getProperty(key);
		return value;

	}

}
