package com.dreamnight.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.dreamnight.restful.remote.IUserRemote;

public class TestDuuboHessian {
	
	public static void main(String[] args) throws Exception {
		HessianProxyFactory hpf = new HessianProxyFactory();
		IUserRemote userRemote = (IUserRemote)hpf.create("http://127.0.0.1:8080/dubbo/userRemote");
		System.out.println(userRemote.getUserById(1L));
	}

}
