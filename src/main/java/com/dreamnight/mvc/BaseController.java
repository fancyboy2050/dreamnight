package com.dreamnight.mvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dreamnight.mvc.editor.PhoneNumberEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.dreamnight.mvc.editor.DateTimeEditor;

public class BaseController {

	final static Logger logger = LoggerFactory.getLogger(BaseController.class);

	private static final String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_MINUTE_FORMATTER = "yyyy-MM-dd HH:mm";
	private static final String DATE_HOUR_FORMATTER = "yyyy-MM-dd HH";
	private static final String DATE_FORMATTER = "yyyy-MM-dd";

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		logger.info("---------------------------BaseController initBinder className : "+this.getClass().getName());
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
		webDataBinder.registerCustomEditor(String.class, new PhoneNumberEditor());

	}

}
