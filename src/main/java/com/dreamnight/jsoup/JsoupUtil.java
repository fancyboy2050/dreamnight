package com.dreamnight.jsoup;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class JsoupUtil {
	
	public static Whitelist user_content_filter = Whitelist.relaxed();
    
	public static String disposeContent(String html){
	    if(StringUtils.isBlank(html)) return "";
	    return Jsoup.clean(html, user_content_filter);
	}
	
	public static String escape(){
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(disposeContent("<img alt=\"\" onerror=\"alert(/123/)\" src=\"http://baidu.com\">"));
	}

}
