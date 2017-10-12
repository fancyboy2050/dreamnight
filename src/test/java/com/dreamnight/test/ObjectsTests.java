package com.dreamnight.test;

import com.dreamnight.model.User;

import java.util.Objects;

/**
 * Created by tianbenzhen on 2017/9/29.
 */
public class ObjectsTests {

    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();
        System.out.println(Objects.equals(user1, user2));
    }

}
