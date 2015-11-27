package com.dreamnight.test;

import org.springframework.web.util.HtmlUtils;

public class Test {
	
	public static void main(String[] args) {
		String str = "&lt;notify&gt;&lt;gmt_payment&gt;2015-11-26 14:40:37&lt;/gmt_payment&gt;&lt;partner&gt;2088021700629045&lt;/partner&gt;&lt;buyer_email&gt;tfancyboy@gmail.com&lt;/buyer_email&gt;&lt;trade_no&gt;2015112600001000300062914710&lt;/trade_no&gt;&lt;total_fee&gt;5.82&lt;/total_fee&gt;&lt;gmt_create&gt;2015-11-26 14:40:21&lt;/gmt_create&gt;&lt;out_trade_no&gt;P15112614394077681&lt;/out_trade_no&gt;&lt;subject&gt;扫码-诛仙3充值&lt;/subject&gt;&lt;trade_status&gt;TRADE_SUCCESS&lt;/trade_status&gt;&lt;qrcode&gt;gdx00931sf1d4qbfbjek719&lt;/qrcode&gt;&lt;/notify&gt;";
		System.out.println(HtmlUtils.htmlUnescape(str));
	}

}
