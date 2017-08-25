package com.dreamnight.test;

import com.dreamnight.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by tianbenzhen on 2017/8/22.
 */
public class TestBeanFactory {

    public static void main(String[] args) throws Exception {

        File file = new File("E:\\git workspace\\dreamnight\\src\\main\\webapp\\WEB-INF\\applicationContext-dubbo-consumer.xml");
        Resource resource = new FileSystemResource(file);
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        User user = (User)beanFactory.getBean("user");
        System.out.println("-------------------------------- user : "+user.toString());

        Resource resource1 = new ClassPathResource("applicationContext.xml");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader.getResource("").getPath());
        System.out.println(resource1.getClass().getResource("").getPath());
        System.out.println(resource1.getClass().getResource("/").getPath());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(resource1.getURL());
        BeanFactory beanFactory1 = new XmlBeanFactory(resource1);
        User user1 = (User)beanFactory.getBean("user");
        System.out.println("-------------------------------- user1 : "+user1.toString());

        BeanFactory beanFactory2 = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user2 = (User)beanFactory2.getBean("user");
        System.out.println("-------------------------------- user2 : "+user2.toString());

        BeanFactory beanFactory3 = new FileSystemXmlApplicationContext("E:\\git workspace\\dreamnight\\src\\main\\webapp\\WEB-INF\\applicationContext-dubbo-consumer.xml");
        User user3 = (User)beanFactory3.getBean("user");
        System.out.println("-------------------------------- user3 : "+user3.toString());

    }



}
