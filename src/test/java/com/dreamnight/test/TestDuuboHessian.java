package com.dreamnight.test;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.caucho.hessian.client.HessianProxyFactory;
import com.dreamnight.restful.remote.IUserRemote;
import com.dreamnight.util.http.HttpClientUtil;

public class TestDuuboHessian {
	
	public static void main(String[] args) throws Exception {
//		HessianProxyFactory hpf = new HessianProxyFactory();
//		IUserRemote userRemote = (IUserRemote)hpf.create("http://127.0.0.1:8080/dubbo/userRemote");
//		System.out.println(userRemote.getUserById(1L));
		
		System.out.println(HttpClientUtil.invokeGet("http://dreamnight.com:9080/getDubboUser", new HashMap<String, String>(), "UTF-8", 5000, 5000));
		
		/*ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0; i<10; i++){
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					for(int j=0; j<5000; j++){
						System.out.println(HttpClientUtil.invokeGet("http://dreamnight.com:9080/getDubboUser", new HashMap<String, String>(), "UTF-8", 5000, 5000));
					}
				}
			});
			
		}*/
	}

}
