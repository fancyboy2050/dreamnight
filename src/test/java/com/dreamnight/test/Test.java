package com.dreamnight.test;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.util.HtmlUtils;

import com.caucho.hessian.client.HessianProxyFactory;
import com.dreamnight.remote.IUserRemote;
import com.dreamnight.util.http.HttpClientUtil;

public class Test {
	
	public static void main(String[] args) throws Exception {
//		String str = "&lt;notify&gt;&lt;gmt_payment&gt;2015-11-26 14:40:37&lt;/gmt_payment&gt;&lt;partner&gt;2088021700629045&lt;/partner&gt;&lt;buyer_email&gt;tfancyboy@gmail.com&lt;/buyer_email&gt;&lt;trade_no&gt;2015112600001000300062914710&lt;/trade_no&gt;&lt;total_fee&gt;5.82&lt;/total_fee&gt;&lt;gmt_create&gt;2015-11-26 14:40:21&lt;/gmt_create&gt;&lt;out_trade_no&gt;P15112614394077681&lt;/out_trade_no&gt;&lt;subject&gt;扫码-诛仙3充值&lt;/subject&gt;&lt;trade_status&gt;TRADE_SUCCESS&lt;/trade_status&gt;&lt;qrcode&gt;gdx00931sf1d4qbfbjek719&lt;/qrcode&gt;&lt;/notify&gt;";
//		System.out.println(HtmlUtils.htmlUnescape(str));
//		final String url1 = "http://tmall.service.wanmei.com/test.do?rid=0&zoneid=1055&transeq=1234567&chargeamount=19400&username=songyingyingmm";
//		final String result1 = "tryPay:from=tmall,username=songyingyingmm,zoneid=1055,transeq=1234567,chargeamount==19400,uresult=(4,流水号123456已经存在。)";
//		
//		final String url2 = "http://tmall.service.wanmei.com/test.do?rid=0&zoneid=1055&transeq=123456&chargeamount=19400&username=songyingyingmm";
//		final String result2 = "tryPay:from=tmall,username=songyingyingmm,zoneid=1055,transeq=123456,chargeamount==19400,uresult=(4,流水号1234567已经存在。)";
//		
//		ExecutorService es = Executors.newFixedThreadPool(100);
//		for(int i=0; i<100; i++){
//			int ii = i%2;
//			System.out.println("ii : "+ii);
//			if(ii == 0){
//				es.execute(new Runnable() {
//					
//					@Override
//					public void run() {
//						while (true) {
//							String response = HttpClientUtil.invokeGet(url1, new HashMap<String, String>(), "UTF-8", 5000, 5000);
//							if(result1.equalsIgnoreCase(response)){
//								System.out.println(result1);
//							}
//						}
//					}
//				});
//			} else {
//				es.execute(new Runnable() {
//					
//					@Override
//					public void run() {
//						while (true) {
//							String response = HttpClientUtil.invokeGet(url2, new HashMap<String, String>(), "UTF-8", 5000, 5000);
//							if(result2.equalsIgnoreCase(response)){
//								System.out.println(result2);
//							}
//						}
//					}
//				});
//			}
//		}
		
//		String url = "http://dreamnight.com:8080/userRemote";
//		
//		HessianProxyFactory hpf = new HessianProxyFactory();
//		try {
//			IUserRemote iUserRemote = (IUserRemote)hpf.create(url);
//			System.out.println(iUserRemote.getUserById(1L));
//		} catch (MalformedURLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		Comparator<Date> dateComparator = new Comparator<Date>() {

			@Override
			public int compare(Date o1, Date o2) {
				if(o1.after(o2)){
					return -1;
				}
				if(o1.before(o2)){
					return 1;
				}
				return 0;
			}
			
		};
		
		List<Date> dateList = new ArrayList<Date>();
		String d1s = "2015-03-01";
		String d2s = "2016-03-01";
		String d3s = "2015-03-02";
		String d4s = "2015-03-05";
		String d5s = "2016-03-20";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(d1s);
		Date d2 = sdf.parse(d2s);
		Date d3 = sdf.parse(d3s);
		Date d4 = sdf.parse(d4s);
		Date d5 = sdf.parse(d5s);
		dateList.add(d1);
		dateList.add(d2);
		dateList.add(d3);
		dateList.add(d4);
		dateList.add(d5);
		Collections.sort(dateList, dateComparator);
		for(Date date : dateList){
			System.out.println(date);
		}

	}

}
