package com.dreamnight.mvc.editor;

import org.springframework.web.util.HtmlUtils;

import java.beans.PropertyEditorSupport;

/**
 * Created by tianbenzhen on 2017/8/8.
 */
public class StringHtmlEscapeEditor extends PropertyEditorSupport{

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            setValue(null);
        } else {
            String value = text.trim();
            setValue(HtmlUtils.htmlEscape(value));
        }
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return (value != null ? value.toString() : "");
    }
}
