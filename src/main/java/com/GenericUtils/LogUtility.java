package com.GenericUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtility {
	
	Logger logs=LogManager.getLogger(LogUtility.class);
	
	public void Info(String Message) {
		logs.info(Message);
	}
	
	public void Error(String Message) {
		logs.error(Message);
	}
	
	public void trace(String Message) {
		logs.trace(Message);
	}
	
	public void warn(String Message) {
		logs.warn(Message);
	}
	
}

