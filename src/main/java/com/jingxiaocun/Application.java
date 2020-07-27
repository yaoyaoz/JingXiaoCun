package com.jingxiaocun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yaoyao on 2020-06-14.
 */
@SpringBootApplication  //(scanBasePackages = {"com.jingxiaocun"})
public class Application  {//extends SpringBootServletInitializer
    public static void main(String[] args) {
        System.out.println("[进销存] 开始启动...");
        SpringApplication.run(Application.class, args);
        System.out.println("[进销存] 启动完成...");
    }
}
