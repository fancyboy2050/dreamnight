package com.dreamnight.mvc.editor;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyEditorSupport;

public class PhoneNumberEditor extends PropertyEditorSupport{

	private final static Logger logger = LoggerFactory.getLogger(PhoneNumberEditor.class);
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		logger.info("---------------------------------------PhoneNumberEditor setAsText doing! text : "+text);
		logger.info("---------------------------------------PhoneNumberEditor setAsText doing! value : "+getValue());
		if(!StringUtils.isBlank(text)){
			setValue("just test!");
		}
	}

	@Override
	public String getAsText() {
		return super.getAsText();
	}
}
