package com.dreamnight.mvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.dreamnight.mvc.editor.DateTimeEditor;

public class BaseController {

	public static final String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_MINUTE_FORMATTER = "yyyy-MM-dd HH:mm";
	public static final String DATE_HOUR_FORMATTER = "yyyy-MM-dd HH";
	public static final String DATE_FORMATTER = "yyyy-MM-dd";
	
	final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMATTER);
		dateFormat.setLenient(false);
		SimpleDateFormat datetimeFormat = new SimpleDateFormat(DATE_TIME_FORMATTER);
		datetimeFormat.setLenient(false);
		SimpleDateFormat dateminuteFormat = new SimpleDateFormat(DATE_MINUTE_FORMATTER);
		dateminuteFormat.setLenient(false);
		SimpleDateFormat datehourFormat = new SimpleDateFormat(DATE_HOUR_FORMATTER);
		datehourFormat.setLenient(false);
		
		List<SimpleDateFormat> dateFormatList = new ArrayList<SimpleDateFormat>();
		dateFormatList.add(dateFormat);
		dateFormatList.add(datehourFormat);
		dateFormatList.add(dateminuteFormat);
		dateFormatList.add(datetimeFormat);
		
		DateTimeEditor dte = new DateTimeEditor(dateFormatList, false);
		webDataBinder.registerCustomEditor(Date.class, dte);
		
	}

}
