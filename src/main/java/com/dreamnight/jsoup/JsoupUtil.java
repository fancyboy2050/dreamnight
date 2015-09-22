package com.dreamnight.jsoup;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.util.HtmlUtils;

public class JsoupUtil {
	
	public static Whitelist user_content_filter = Whitelist.relaxed();
	
	static {
		user_content_filter.addTags("&");
	}
    
	public static String disposeContent(String html){
	    if(StringUtils.isBlank(html)) return "";
	    return Jsoup.clean(html, user_content_filter);
	}
	
	public static String disposeContent(String html, Whitelist whitelist){
	    if(StringUtils.isBlank(html)) return "";
	    return Jsoup.clean(html, whitelist);
	}
	
	public static String escape(){
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(disposeContent("<img alt=\"\" onerror=\"alert(/123/)\" src=\"http://passport.wanmei.com/sso/getrandom?random=x&&uid=1\">"));
		
		System.out.println(HtmlUtils.htmlUnescape(disposeContent("http://passport.wanmei.com/sso/getrandom?ran dom=x&&uid=1", Whitelist.none())));
	}

}
