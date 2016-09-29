package com.dreamnight.stockapi;

import java.util.HashMap;

import com.dreamnight.util.http.HttpClientUtil;

public class BaiDuStockApiTest {
	
	public static void main(String[] args) {
		String url = "http://apis.baidu.com/apistore/stockservice/stock";
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("apikey", "dadddc226df143bf0775425f4d2081fe");
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("stockid", "sz002624");
		params.put("list", "1");
		System.out.println(HttpClientUtil.invokeGet(url, params, headers, "UTF-8", 5000, 5000));
	}

}
