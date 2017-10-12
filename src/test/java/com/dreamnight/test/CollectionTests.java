package com.dreamnight.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianbenzhen on 2017/9/29.
 */
public class CollectionTests {

    public static void main(String[] args) {
        listToArray();
    }

    private static void listToArray(){
        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        System.out.println("1 , list.toArray() : "+list.toArray());
        String[] array = new String[list.size()];
        array = list.toArray(array);
        System.out.println("2 , list.toArray() : "+array);
    }

}
