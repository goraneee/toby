package com.example.toby.ch01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        // 1.6
        DaoFactory factory = new DaoFactory();
        UserDao userDao1 = factory.userDao();
        UserDao userDao2 = factory.userDao();
        System.out.println(userDao1);
        System.out.println(userDao2);
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        System.out.println(context.getBean("userDao", UserDao.class));
        System.out.println(context.getBean("userDao", UserDao.class));

    }

}
