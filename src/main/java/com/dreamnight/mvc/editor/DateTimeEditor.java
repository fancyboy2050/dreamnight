package com.dreamnight.mvc.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.excalibur.core.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeEditor extends PropertyEditorSupport {

	private final static Logger logger = LoggerFactory.getLogger(DateTimeEditor.class);
	/**
	 * 按照定义时加入列表的顺序优先匹配.
	 */
	private final List<SimpleDateFormat> dateFormat;
	private final boolean allowEmpty;
	private final int exactDateLength;

	public DateTimeEditor(List<SimpleDateFormat> dateFormat, boolean allowEmpty) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;
	}

	public DateTimeEditor(List<SimpleDateFormat> dateFormat,
			boolean allowEmpty, int exactDateLength) {
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = exactDateLength;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		logger.info("---------------------------------------DateTimeEditor setAsText doing! text : "+text);
		logger.info("---------------------------------------DateTimeEditor setAsText doing! value : "+getValue());
		if (this.allowEmpty && StringHelper.isBlank(text)) {
			setValue(null);
		} else {
			if (text != null && this.exactDateLength >= 0
					&& text.length() != this.exactDateLength) {
				throw new IllegalArgumentException(
						"Could not parse date: it is not exactly"
								+ this.exactDateLength + "characters long");
			}
			for (int i = 0; i < this.dateFormat.size(); i++) {
				try {
					setValue(this.dateFormat.get(i).parse(text));
					break;
				} catch (ParseException ex) {
					if (i == this.dateFormat.size() - 1) {
						throw new IllegalArgumentException(
								"Could not parse date: " + ex.getMessage(), ex);
					}
					continue;
				}
			}
		}
	}

	@Override
	public String getAsText() {
		Date date = (Date) getValue();
		String text = "";
		if (date != null) {
			for (int i = 0; i < this.dateFormat.size(); i++) {
				text = this.dateFormat.get(i).format(date);
				if (StringHelper.isNotBlank(text)) {
					break;
				}
			}
		}
		return text;
	}
}
