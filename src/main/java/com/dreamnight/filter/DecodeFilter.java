package com.dreamnight.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.util.EncodingUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.excalibur.core.security.AESAlgorithm;
import com.excalibur.core.util.json.JsonUtils;

@Component
public class DecodeFilter extends OncePerRequestFilter{
	
	private final static String AES_KEY = "keyxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
			throws ServletException, IOException {
		
        int length = request.getContentLength();
        if (length > 0) {
            InputStream is = request.getInputStream();
            byte[] buffer = new byte[length]; 
            int pad = 0; 
            while(pad < length){ 
                pad += is.read(buffer, pad, length);
            }
            String content = EncodingUtils.getString(buffer, "UTF-8");
			try {
				content = AESAlgorithm.decode(Base64.decodeBase64(content), AES_KEY);
			} catch (Exception e) {
				logger.error("aes decode error！", e);
				response.setStatus(500);
				return;
			}
			try {
				Map<String, Object> map = JsonUtils.parse(content);
				//TODO:转换嵌套map未json串， 后续实现更优的方法
				Map<String, Object> mapRecombine = new HashMap<String, Object>();
				String valString = "";
				for (Map.Entry<String, Object> entry : map.entrySet()){
					if(entry.getValue() instanceof Map){
						valString = JsonUtils.objectToJson(entry.getValue());
						mapRecombine.put(entry.getKey(), valString);
					}else{
						mapRecombine.put(entry.getKey(), entry.getValue());
					}
				}
				
				if(map != null){
					DecodeRequestWrapper sdkrw = new DecodeRequestWrapper(request);
					sdkrw.putAll(mapRecombine);
					request = sdkrw;
				}
			} catch(Exception e) {
				logger.error("json parse error！", e);
				response.setStatus(500);
				return;
			}
			filterChain.doFilter(request, response);
			return;
        }
        response.setStatus(500);
	}

}
